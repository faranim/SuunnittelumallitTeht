package Command;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GUI extends Application {
    @Override
    public void start(Stage stage) {
        Cursor cursor = new Cursor();

        BorderPane root = new BorderPane();
        root.setCenter(cursor.getGridPane());

        Button generateButton = new Button("Create Code");
        generateButton.setOnAction(e -> new GenerateCodeCommand(cursor).execute());
        root.setBottom(generateButton);
        Scene scene = new Scene(root, 500, 500);
        scene.setOnKeyPressed(event -> {
            KeyCode code = event.getCode();
            if (code == KeyCode.UP) new MoveCursorCommand(cursor, 0, -1).execute();
            else if (code == KeyCode.DOWN) new MoveCursorCommand(cursor, 0, 1).execute();
            else if (code == KeyCode.LEFT) new MoveCursorCommand(cursor, -1, 0).execute();
            else if (code == KeyCode.RIGHT) new MoveCursorCommand(cursor, 1, 0).execute();
            else if (code == KeyCode.SPACE) new TogglePixelCommand(cursor).execute();
        });

        scene.getRoot().requestFocus();
        stage.setScene(scene);
        stage.setTitle("Pixel Art Editor");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
