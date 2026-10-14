package hometheatre.subsystem;

public class DvdPlayer {
    private boolean poweredOn;
    private boolean playing;
    private String loadedMovie;

    public void turnOn() {
        poweredOn = true;
        System.out.println("DVD player is on.");
    }

    public void loadMovie(String movieTitle) {
        ensurePoweredOn();

        if (movieTitle == null || movieTitle.isBlank()) {
            throw new IllegalArgumentException(
                    "Movie title must not be empty."
            );
        }

        if (playing) {
            throw new IllegalStateException(
                    "Stop playback before loading another movie."
            );
        }

        loadedMovie = movieTitle.trim();
        System.out.println("Movie loaded: " + loadedMovie);
    }

    public void play() {
        ensurePoweredOn();

        if (loadedMovie == null) {
            throw new IllegalStateException(
                    "Load a movie before starting playback."
            );
        }

        if (playing) {
            throw new IllegalStateException(
                    "A movie is already playing."
            );
        }

        playing = true;
        System.out.println("Playing: " + loadedMovie);
    }

    public void stop() {
        if (!playing) {
            return;
        }

        playing = false;
        System.out.println("Playback stopped.");
    }

    public void turnOff() {
        stop();
        loadedMovie = null;
        poweredOn = false;
        System.out.println("DVD player is off.");
    }

    public boolean isPlaying() {
        return playing;
    }

    private void ensurePoweredOn() {
        if (!poweredOn) {
            throw new IllegalStateException(
                    "DVD player must be turned on first."
            );
        }
    }
}
