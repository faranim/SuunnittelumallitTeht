package AbstractMethod;

public class Main {
    public static void main(String[] args) {
        UIFactory factoryA = new AFactory();
        UIFactory factoryB = new BFactory();

        TextField textFieldA = factoryA.createTextField("Write here");
        Button buttonA = factoryA.createButton("Ok");
        CheckBox checkBoxA = factoryA.createCheckBox("Click me");

        TextField textFieldB = factoryB.createTextField("Type here");
        Button buttonB = factoryB.createButton("Click");
        CheckBox checkBoxB = factoryB.createCheckBox("Yes");

        System.out.println("TextFields: ");
        textFieldA.display();
        textFieldB.display();

        System.out.println("CheckBoxes: ");
        checkBoxA.display();
        checkBoxB.display();
    }
}
