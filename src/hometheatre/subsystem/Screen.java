package hometheatre.subsystem;

public class Screen {
    private boolean lowered;

    public void lower() {
        if (lowered) {
            return;
        }

        lowered = true;
        System.out.println("Screen lowered.");
    }

    public void raise() {
        if (!lowered) {
            return;
        }

        lowered = false;
        System.out.println("Screen raised.");
    }

    public boolean isLowered() {
        return lowered;
    }
}