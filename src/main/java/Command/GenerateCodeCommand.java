package Command;

class GenerateCodeCommand extends CursorCommand {
    public GenerateCodeCommand(Cursor cursor) {
        super(cursor);
    }

    @Override
    public void execute() {
        cursor.generateCode();
    }
}