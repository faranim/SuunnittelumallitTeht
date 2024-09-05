package Composite;

public abstract class Component {
    public String name;

    public Component(String name) {
        this.name = name;
    }

    public abstract double getSalary();

    public abstract void add(Component component);
    public abstract void remove(Component component);

    // Unified print method for XML and structure printing
    public abstract void printStructure(String indent);
    public abstract void printXML(String indent);
}
