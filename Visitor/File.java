package Visitor;

public class File implements FileSystemElement {
    private String name;
    private double size; // in megabytes

    public File(String name, double size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getSize() {
        return size;
    }
}
