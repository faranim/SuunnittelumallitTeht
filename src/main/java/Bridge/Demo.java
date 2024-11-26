package Bridge;

import Bridge.Device;

import Bridge.Tv;
import Bridge.Radio;
import Bridge.SmartTv;
import Bridge.BasicRemote;
import Bridge.AdvancedRemote;
import Bridge.SmartRemote;

public class Demo {
    public static void main(String[] args) {
        testDevice(new Tv());

        testDevice(new Radio());

        testDeviceWithSmartRemote(new SmartTv());
    }

    public static void testDevice(Device device) {
        System.out.println("Tests with basic remote.");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();

        System.out.println("Tests with advanced remote.");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();
    }

    public static void testDeviceWithSmartRemote(SmartTv smartTv) {
        System.out.println("Tests with smart remote (voice control).");
        SmartRemote smartRemote = new SmartRemote(smartTv);

        smartRemote.power();
        smartRemote.voiceControl("browse");

        smartTv.printStatus();
    }
}
