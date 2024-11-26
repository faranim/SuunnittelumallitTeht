package Mediator;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ChatApp extends Application {
    private final Mediator mediator = new Mediator();

    @Override
    public void start(Stage primaryStage) {
        createClientWindow("Alice");
        createClientWindow("Bob");
        createClientWindow("Charlie");
    }

    private void createClientWindow(String username) {
        Stage stage = new Stage();
        stage.setTitle(username);

        TextArea chatArea = new TextArea();
        chatArea.setEditable(false);

        TextField recipientField = new TextField();
        recipientField.setPromptText("Recipient");

        TextField messageField = new TextField();
        messageField.setPromptText("Type your message");

        Button sendButton = new Button("Send");

        Controller controller = new Controller(username, mediator, chatArea);

        sendButton.setOnAction(e -> {
            String recipient = recipientField.getText();
            String message = messageField.getText();
            if (!recipient.isEmpty() && !message.isEmpty()) {
                controller.sendMessage(recipient, message);
                chatArea.appendText("You: " + message + "\n");
                messageField.clear();
            }
        });

        GridPane layout = new GridPane();
        layout.setPadding(new Insets(10));
        layout.setHgap(10);
        layout.setVgap(10);

        layout.add(new Label("Chat:"), 0, 0);
        layout.add(chatArea, 0, 1, 2, 1);
        layout.add(new Label("To:"), 0, 2);
        layout.add(recipientField, 1, 2);
        layout.add(messageField, 0, 3, 2, 1);
        layout.add(sendButton, 1, 4);

        Scene scene = new Scene(layout, 400, 300);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

