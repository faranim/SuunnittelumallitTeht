package AbstractMethod;

public class BFactory extends UIFactory {

    @Override
    public TextField createTextField(String text) {
        return new TextFieldB(text);
    }
    @Override
    public Button createButton(String text) {
        return new ButtonB(text);
    }

    @Override
    public CheckBox createCheckBox(String text) {
        return new CheckBoxB(text);
    }
}