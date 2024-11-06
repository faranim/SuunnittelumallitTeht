package Proxy;

import java.util.Date;

public interface iDocument {
    Date getCreationDate();
    String getContent(User user);
    int getIdentifier();
}

