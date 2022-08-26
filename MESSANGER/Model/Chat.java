package MESSANGER.Model;

import java.util.Date;
import java.util.Objects;

public class Chat implements Entity  {

    private long id;
    private final Date WritedAt;
    private final String MediaURL;
    private final User Sender;

    public Chat(long id, Date writedAt, String mediaURL, User sender) {
        this.id = id;
        WritedAt = writedAt;
        MediaURL = mediaURL;
        Sender = sender;
    }

    public Chat(Date writedAt, String mediaURL, User sender) {
        WritedAt = writedAt;
        MediaURL = mediaURL;
        Sender = sender;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getWritedAt() {
        return WritedAt;
    }

    public String getMediaURL() {
        return MediaURL;
    }

    public User getSender() {
        return Sender;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "id=" + id +
                ", WritedAt=" + WritedAt +
                ", MediaURL='" + MediaURL + '\'' +
                ", Sender=" + Sender +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chat chat = (Chat) o;
        return getId() == chat.getId() && getWritedAt().equals(chat.getWritedAt()) && getMediaURL().equals(chat.getMediaURL()) && getSender().equals(chat.getSender());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getWritedAt(), getMediaURL(), getSender());
    }
}
