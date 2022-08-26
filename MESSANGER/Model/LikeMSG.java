package MESSANGER.Model;

import java.util.Date;
import java.util.Objects;

public class LikeMSG implements Entity {

    private long id;
    private final User Liker;
    private final Chat Chat;
    private final Date When;

    public LikeMSG(User liker, MESSANGER.Model.Chat chat, Date when) {
        Liker = liker;
        Chat = chat;
        When = when;
    }

    public LikeMSG(long id, User liker, MESSANGER.Model.Chat chat, Date when) {
        this.id = id;
        Liker = liker;
        Chat = chat;
        When = when;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getLiker() {
        return Liker;
    }

    public MESSANGER.Model.Chat getChat() {
        return Chat;
    }

    public Date getWhen() {
        return When;
    }

    @Override
    public String toString() {
        return "LikeMSG{" +
                "id=" + id +
                ", Liker=" + Liker +
                ", Chat=" + Chat +
                ", When=" + When +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LikeMSG likeMSG = (LikeMSG) o;
        return getLiker().equals(likeMSG.getLiker()) && getChat().equals(likeMSG.getChat());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLiker(), getChat());
    }
}
