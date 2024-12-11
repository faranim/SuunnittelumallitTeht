package Command;

class MoveCursorCommand extends CursorCommand {
    private final int dx, dy;

    public MoveCursorCommand(Cursor cursor, int dx, int dy) {
        super(cursor);
        this.dx = dx;
        this.dy = dy;
    }

    @Override
    public void execute() {
        cursor.moveCursor(dx, dy);
    }
}