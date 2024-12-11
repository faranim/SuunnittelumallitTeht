package Command;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

class Cursor {
    private int x = 0, y = 0;
    private final int rows = 8, columns = 8;
    private final int[][] pixels = new int[rows][columns];
    private final GridPane gridPane = new GridPane();

    public Cursor() {
        initializeGrid();
    }

    private void initializeGrid() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                Rectangle rectangle = new Rectangle(60, 55, Color.WHITE);
                rectangle.setStroke(Color.BLACK);
                gridPane.add(rectangle, col, row);
            }
        }
        updateCursor();
    }
    public void moveCursor(int dx, int dy) {
        x = Math.max(0, Math.min(rows - 1, x + dx));
        y = Math.max(0, Math.min(columns - 1, y + dy));
        updateCursor();
    }

    public void togglePixel() {
        pixels[y][x] ^= 1;
        updateCell(x, y);
    }

    private void updateCursor() {
        gridPane.getChildren().forEach(node -> ((Rectangle) node).setStroke(Color.BLACK));
        getRectangle(x, y).setStroke(Color.RED);
    }

    private void updateCell(int x, int y) {
        getRectangle(x, y).setFill(pixels[y][x] == 1 ? Color.BLACK : Color.WHITE);
    }

    private Rectangle getRectangle(int x, int y) {
        return (Rectangle) gridPane.getChildren().get(y * columns + x);
    }

    public void generateCode() {
        StringBuilder sb = new StringBuilder("int[][] pixelArt = {\n");
        for (int[] row : pixels) {
            sb.append("    {").append(String.join(", ",
                            java.util.Arrays.stream(row).mapToObj(String::valueOf).toArray(String[]::new)))
                    .append("},\n");
        }
        sb.setLength(sb.length() - 3);
        sb.append("\n};");
        System.out.println(sb);
    }

    public GridPane getGridPane() {
        return gridPane;
    }
}