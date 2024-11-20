package Bridge;

public class SmartRemote extends AdvancedRemote {

    public SmartRemote(Device device) {
        super(device);
    }

    public void voiceControl(String command) {
        System.out.println("Voice control command: " + command);
        if (command.equalsIgnoreCase("browse")) {
            if (device instanceof SmartTv) {
                // Pass a URL when calling browserInternet
                ((SmartTv) device).browserInternet("http://example.com");
            } else {
                System.out.println("This device does not support browsing.");
            }
        }
        // Add more voice commands here if necessary
    }
}
