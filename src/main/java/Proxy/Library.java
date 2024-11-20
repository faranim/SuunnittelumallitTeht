package Proxy;

import java.util.HashMap;

public class Library {
    private final HashMap<Integer, iDocument> documents = new HashMap<>();

    public void addDocument(iDocument document) {
        documents.put(document.getIdentifier(), document);
    }

    public iDocument fetchDocument(int documentId) {
        return documents.get(documentId);
    }
}
