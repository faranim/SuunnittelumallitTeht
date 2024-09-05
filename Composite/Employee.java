package Composite;

public class Employee extends Component {
    private double salary;

    public Employee(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public void add(Component component) {
        throw new UnsupportedOperationException("Cannot add to an employee.");
    }

    @Override
    public void remove(Component component) {
        throw new UnsupportedOperationException("Cannot remove from an employee.");
    }

    @Override
    public void printStructure(String indent) {
        System.out.println(indent + "Employee: " + name + ", Salary: $" + salary);
    }

    @Override
    public void printXML(String indent) {
        System.out.println(indent + "<Employee name=\"" + name + "\" salary=\"" + salary + "\" />");
    }
}
