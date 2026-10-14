package hometheatre.config;

import hometheatre.facade.Facade;
import hometheatre.subsystem.Amplifier;
import hometheatre.subsystem.DvdPlayer;
import hometheatre.subsystem.Lights;
import hometheatre.subsystem.Projector;
import hometheatre.subsystem.Screen;

public final class Configuration {

    private Configuration() {
    }

    public static Facade createHomeTheater() {
        return new Facade(
                new DvdPlayer(),
                new Amplifier(),
                new Projector(),
                new Screen(),
                new Lights()
        );
    }
}