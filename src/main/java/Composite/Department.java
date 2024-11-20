package Composite;

import java.util.List;
import java.util.ArrayList;


public class Department extends Component {
    private List<Component> components = new ArrayList<>();

    public Department(String name) {
        super(name);
    }

    @Override
    public double getSalary() {
        return components.stream().mapToDouble(Component::getSalary).sum();
    }

    @Override
    public void add(Component component) {
        this.components.add(component);
    }

    @Override
    public void remove(Component component) {
        this.components.remove(component);
    }

    @Override
    public void printStructure(String indent) {
        System.out.println(indent + "Department: " + name);
        for (Component component : components) {
            component.printStructure(indent + "    ");
        }
    }

    @Override
    public void printXML(String indent) {
        System.out.println(indent + "<Department name=\"" + name + "\">");
        for (Component component : components) {
            component.printXML(indent + "    ");
        }
        System.out.println(indent + "</Department>");
    }
}