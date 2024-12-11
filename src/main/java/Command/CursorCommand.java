package Command;

abstract class CursorCommand implements Command {
    protected final Cursor cursor;

    public CursorCommand(Cursor cursor) {
        this.cursor = cursor;
    }
}