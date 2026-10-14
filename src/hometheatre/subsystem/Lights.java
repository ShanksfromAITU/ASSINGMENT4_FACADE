package hometheatre.subsystem;

public class Lights {
    private static final int MIN_BRIGHTNESS = 0;
    private static final int MAX_BRIGHTNESS = 100;

    private int brightness = MAX_BRIGHTNESS;

    public void dim(int brightness) {
        if (brightness < MIN_BRIGHTNESS
                || brightness > MAX_BRIGHTNESS) {
            throw new IllegalArgumentException(
                    "Brightness must be between "
                            + MIN_BRIGHTNESS + " and "
                            + MAX_BRIGHTNESS + "."
            );
        }

        this.brightness = brightness;
        System.out.println("Lights brightness: " + brightness + "%");
    }

    public void turnOn() {
        dim(MAX_BRIGHTNESS);
    }

    public int getBrightness() {
        return brightness;
    }
}