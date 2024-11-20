package Visitor;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class SearchVisitor implements FileSystemVisitor {
    private Pattern pattern;
    private List<File> matchingFiles;

    public SearchVisitor(String regex) {
        this.pattern = Pattern.compile(regex);
        this.matchingFiles = new ArrayList<>();
    }

    @Override
    public void visit(File file) {
        if (pattern.matcher(file.getName()).matches()) {
            matchingFiles.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
    }

    public List<File> getMatchingFiles() {
        return matchingFiles;
    }
}
