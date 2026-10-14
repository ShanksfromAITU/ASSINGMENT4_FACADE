package hometheatre.subsystem;

public class Projector {
    private boolean poweredOn;
    private boolean wideScreenMode;
    private String inputSource;

    public void turnOn() {
        poweredOn = true;
        System.out.println("Projector is on.");
    }

    public void setInputSource(String source) {
        ensurePoweredOn();

        if (source == null || source.isBlank()) {
            throw new IllegalArgumentException(
                    "Input source must not be empty."
            );
        }

        inputSource = source.trim();
        System.out.println("Projector input: " + inputSource);
    }

    public void enableWideScreenMode() {
        ensurePoweredOn();

        if (inputSource == null) {
            throw new IllegalStateException(
                    "Select an input source before configuring projection."
            );
        }

        wideScreenMode = true;
        System.out.println("Widescreen mode enabled.");
    }

    public void turnOff() {
        wideScreenMode = false;
        inputSource = null;
        poweredOn = false;
        System.out.println("Projector is off.");
    }

    public boolean isReady() {
        return poweredOn && inputSource != null && wideScreenMode;
    }

    private void ensurePoweredOn() {
        if (!poweredOn) {
            throw new IllegalStateException(
                    "Projector must be turned on first."
            );
        }
    }
}
