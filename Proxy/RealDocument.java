package Proxy;

import java.sql.Date;

public class RealDocument implements iDocument {
    private final int id;
    private final Date date;
    private final String content;

    public RealDocument(int id, Date date, String content) {
        this.id = id;
        this.date = date;
        this.content = content;
    }

    @Override
    public int getIdentifier() {
        return id;
    }

    @Override
    public Date getCreationDate() {
        return date;
    }

    @Override
    public String getContent(User user) {
        return content;
    }
}
