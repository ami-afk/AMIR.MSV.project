package MESSANGER.Model;

import java.util.Date;
import java.util.Objects;

public class StartChat implements Entity {
    private long id;
    private final User Sender;
    private final ChatState state;
    private final Date WhenRequested;

    public StartChat(long id, User sender, ChatState state, Date whenRequested) {
        this.id = id;
        Sender = sender;
        this.state = state;
        WhenRequested = whenRequested;

    }

    public StartChat(User sender, ChatState state, Date whenRequested) {
        Sender = sender;
        this.state = state;
        WhenRequested = whenRequested;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getSender() {
        return Sender;
    }

    public ChatState getState() {
        return state;
    }

    public Date getWhenRequested() {
        return WhenRequested;
    }

    @Override
    public String toString() {
        return "StartChat{" +
                "id=" + id +
                ", ChatPartner=" + Sender +
                ", state=" + state +
                ", WhenRequested=" + WhenRequested +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StartChat startChat = (StartChat) o;
        return getSender().equals(startChat.getSender());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSender());
    }
}
