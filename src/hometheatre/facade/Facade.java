package hometheatre.facade;

import hometheatre.subsystem.Amplifier;
import hometheatre.subsystem.DvdPlayer;
import hometheatre.subsystem.Lights;
import hometheatre.subsystem.Projector;
import hometheatre.subsystem.Screen;

import java.util.Objects;

public class Facade {
    private static final int MOVIE_VOLUME = 30;
    private static final int MOVIE_BRIGHTNESS = 20;
    private static final String DVD_SOURCE = "DVD";

    private final DvdPlayer player;
    private final Amplifier amplifier;
    private final Projector projector;
    private final Screen screen;
    private final Lights lights;

    private boolean movieRunning;

    public Facade(
            DvdPlayer player,
            Amplifier amplifier,
            Projector projector,
            Screen screen,
            Lights lights
    ) {
        this.player = Objects.requireNonNull(player, "Player is required.");
        this.amplifier = Objects.requireNonNull(
                amplifier, "Amplifier is required."
        );
        this.projector = Objects.requireNonNull(
                projector, "Projector is required."
        );
        this.screen = Objects.requireNonNull(screen, "Screen is required.");
        this.lights = Objects.requireNonNull(lights, "Lights are required.");
    }

    public void watchMovie(String movieTitle) {
        if (movieRunning) {
            throw new IllegalStateException(
                    "End the current movie before starting another one."
            );
        }

        try {
            preparePlayer(movieTitle);
            prepareVideo();
            prepareAudio();

            lights.dim(MOVIE_BRIGHTNESS);
            player.play();
            movieRunning = true;

            System.out.println("Home theater is ready. Enjoy the movie!");
        } catch (IllegalArgumentException | IllegalStateException exception) {
            shutDown();
            throw new IllegalStateException(
                    "Could not start the movie: " + exception.getMessage(),
                    exception
            );
        }
    }

    public void endMovie() {
        if (!movieRunning) {
            System.out.println("No movie is currently running.");
            return;
        }

        shutDown();
        System.out.println("Movie session ended.");
    }

    private void preparePlayer(String movieTitle) {
        player.turnOn();
        player.loadMovie(movieTitle);
    }

    private void prepareVideo() {
        screen.lower();
        projector.turnOn();
        projector.setInputSource(DVD_SOURCE);
        projector.enableWideScreenMode();
    }

    private void prepareAudio() {
        amplifier.turnOn();
        amplifier.setAudioSource(DVD_SOURCE);
        amplifier.setVolume(MOVIE_VOLUME);
    }

    private void shutDown() {
        player.turnOff();
        amplifier.turnOff();
        projector.turnOff();
        screen.raise();
        lights.turnOn();
        movieRunning = false;
    }
}