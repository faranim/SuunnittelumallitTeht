package Bridge;

import Bridge.Device;

public class SmartRemote extends AdvancedRemote {

    public SmartRemote(Device device) {
        super(device);
    }

    public void voiceControl(String command) {
        System.out.println("Voice control command: " + command);
        if (command.equalsIgnoreCase("browse")) {
            if (device instanceof SmartTv) {
                ((SmartTv) device).browserInternet();
            } else {
                System.out.println("This device does not support browsing.");
            }
        }
        // Add more voice commands here if necessary
    }
}

