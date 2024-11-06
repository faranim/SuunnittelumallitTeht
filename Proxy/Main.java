package Proxy;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        AccessControlService accessService = AccessControlService.getInstance();

        User user1 = new User("user1");
        User user2 = new User("user2");

        accessService.grantAccess("user1", 1);

        iDocument openDoc = new RealDocument(2, new Date(System.currentTimeMillis()), "Accessible to all");
        iDocument restrictedDoc = new DocumentProxy(1, new Date(System.currentTimeMillis()), "Restricted Content", accessService);

        library.addDocument(openDoc);
        library.addDocument(restrictedDoc);

        System.out.println("Open Document: " + library.fetchDocument(2).getContent(user1));
        System.out.println("Protected Document (user1): " + library.fetchDocument(1).getContent(user1));
        System.out.println("Protected Document (user2): " + library.fetchDocument(1).getContent(user2));
    }
}
