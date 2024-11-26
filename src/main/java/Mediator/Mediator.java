package Mediator;

import java.util.HashMap;
import java.util.Map;

public class Mediator {
    private final Map<String, Controller> clients = new HashMap<>();

    public void registerClient(String username, Controller controller) {
        clients.put(username, controller);
    }

    public void sendMessage(String sender, String recipient, String message) {
        if (clients.containsKey(recipient)) {
            clients.get(recipient).receiveMessage(sender, message);
        }
    }
}
