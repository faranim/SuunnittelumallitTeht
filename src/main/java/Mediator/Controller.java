package Mediator;


import javafx.application.Platform;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
    private final String username;
    private final Mediator mediator;
    private final TextArea chatArea;

    public Controller(String username, Mediator mediator, TextArea chatArea) {
        this.username = username;
        this.mediator = mediator;
        this.chatArea = chatArea;
        mediator.registerClient(username, this);
    }

    public void sendMessage(String recipient, String message) {
        mediator.sendMessage(username, recipient, message);
    }

    public void receiveMessage(String sender, String message) {
        Platform.runLater(() -> chatArea.appendText(sender + ": " + message + "\n"));
    }
}
