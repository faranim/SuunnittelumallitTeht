package Command;

class TogglePixelCommand extends CursorCommand {
    public TogglePixelCommand(Cursor cursor) {
        super(cursor);
    }

    @Override
    public void execute() {
        cursor.togglePixel();
    }
}