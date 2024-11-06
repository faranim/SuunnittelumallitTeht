package Visitor;


public class Main {
    public static void main(String[] args) {
        Directory root = new Directory("Root");
        Directory musicFolder = new Directory("Music");
        Directory docsFolder = new Directory("Documents");

        root.addElement(new File("image.png", 1.5));
        root.addElement(new File("notes.txt", 0.4));
        root.addElement(musicFolder);
        root.addElement(docsFolder);

        musicFolder.addElement(new File("song.mp3", 3.2));
        docsFolder.addElement(new File("resume.pdf", 0.9));

        SizeCalculator sizeCalculator = new SizeCalculator();
        root.accept(sizeCalculator);
        System.out.println("Total size: " + sizeCalculator.getTotalSize() + " MB");

        SearchVisitor searchVisitor = new SearchVisitor(".*\\.mp3");
        root.accept(searchVisitor);
        searchVisitor.getMatchingFiles().forEach(file -> System.out.println("Found: " + file.getName()));
    }
}
