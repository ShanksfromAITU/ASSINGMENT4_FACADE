package hometheatre.subsystem;

public class Amplifier {
    private static final int MIN_VOLUME = 0;
    private static final int MAX_VOLUME = 100;

    private boolean poweredOn;
    private int volume;
    private String audioSource;

    public void turnOn() {
        poweredOn = true;
        System.out.println("Amplifier is on.");
    }

    public void setAudioSource(String source) {
        ensurePoweredOn();

        if (source == null || source.isBlank()) {
            throw new IllegalArgumentException(
                    "Audio source must not be empty."
            );
        }

        audioSource = source.trim();
        System.out.println("Audio source: " + audioSource);
    }

    public void setVolume(int volume) {
        ensurePoweredOn();

        if (volume < MIN_VOLUME || volume > MAX_VOLUME) {
            throw new IllegalArgumentException(
                    "Volume must be between "
                            + MIN_VOLUME + " and " + MAX_VOLUME + "."
            );
        }

        this.volume = volume;
        System.out.println("Volume set to: " + volume);
    }

    public void turnOff() {
        volume = MIN_VOLUME;
        audioSource = null;
        poweredOn = false;
        System.out.println("Amplifier is off.");
    }

    public int getVolume() {
        return volume;
    }

    private void ensurePoweredOn() {
        if (!poweredOn) {
            throw new IllegalStateException(
                    "Amplifier must be turned on first."
            );
        }
    }
}