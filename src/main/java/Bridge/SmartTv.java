package Bridge;

public class SmartTv extends Tv {
    private String browser;

    public void browseInternet(String url) {
        this.browser = url;  // Store the URL in the browser field
        System.out.println("Browsing: " + url);  // Output the URL being accessed
    }

    @Override
    public void printStatus() {
        System.out.println("------------------------------------");
        System.out.println("| I'm Smart TV.");
        System.out.println("| I'm " + (super.isEnabled() ? "enabled" : "disabled"));
        System.out.println("| Current volume is " + getVolume() + "%");
        System.out.println("| Current channel is " + getChannel());
        if (browser != null) {
            System.out.println("| Current browser is " + browser);
        }
        System.out.println("------------------------------------\n");
    }
}


