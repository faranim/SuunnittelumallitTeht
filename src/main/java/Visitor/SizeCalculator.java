package Visitor;

public class SizeCalculator implements FileSystemVisitor {
    private double totalSize = 0.0;

    @Override
    public void visit(File file) {
        totalSize += file.getSize();
    }

    @Override
    public void visit(Directory directory) {
    }

    public double getTotalSize() {
        return totalSize;
    }
}
