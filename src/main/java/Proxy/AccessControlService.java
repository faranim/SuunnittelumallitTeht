package Proxy;

import java.util.HashMap;

public class AccessControlService {
    private final HashMap<String, Integer> permissions = new HashMap<>();
    private static AccessControlService instance;

    private AccessControlService() {}

    public static AccessControlService getInstance() {
        if (instance == null) {
            instance = new AccessControlService();
        }
        return instance;
    }

    public boolean hasAccess(int documentId, User user) {
        return permissions.getOrDefault(user.getUsername(), -1) == documentId;
    }

    public void grantAccess(String username, int documentId) {
        permissions.put(username, documentId);
    }
}
