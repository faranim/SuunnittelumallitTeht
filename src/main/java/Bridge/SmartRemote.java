package Bridge;

import Bridge.Device;
import Bridge.SmartTv;

public class SmartRemote extends AdvancedRemote {

    public SmartRemote(Device device) {
        super(device);
    }

    public void voiceControl(String command) {
        System.out.println("Voice control command: " + command);
        if (command.equalsIgnoreCase("browse")) {
            if (device instanceof SmartTv) {
                ((SmartTv) device).browseInternet("http://example.com");
            } else {
                System.out.println("This device does not support browsing.");
            }
        }
    }
}
