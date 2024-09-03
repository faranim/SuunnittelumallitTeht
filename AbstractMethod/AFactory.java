package AbstractMethod;

public class AFactory extends UIFactory {

    @Override
    public TextField createTextField(String text) {
        return new TextFieldA(text);
    }

    @Override
    public CheckBox createCheckBox(String text) {
        return new CheckBoxA(text);
    }

    @Override
    public Button createButton(String text) {
        return new ButtonA(text);
    }


}
