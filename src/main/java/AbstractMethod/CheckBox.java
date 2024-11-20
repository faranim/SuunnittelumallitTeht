package AbstractMethod;

public abstract class CheckBox {
    protected String text;

    public CheckBox(String text) {
        this.text = text;
    }

    public abstract void display();

    public void setText(String text) {
        this.text = text;
    }
}
