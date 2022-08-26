package MESSANGER.Model;

import java.util.Date;
import java.util.Objects;

public class Reply implements Entity {

    private Long id;
    private final String Text;
    private final User Replyer;
    private final Chat Chat;
    private final Date When;

    public Reply(Long id, String text, User replyer, MESSANGER.Model.Chat chat, Date when) {
        this.id = id;
        Text = text;
        Replyer = replyer;
        Chat = chat;
        When = when;
    }

    public Reply(String text, User replyer, MESSANGER.Model.Chat chat, Date when) {
        Text = text;
        Replyer = replyer;
        Chat = chat;
        When = when;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return Text;
    }

    public User getReplyer() {
        return Replyer;
    }

    public MESSANGER.Model.Chat getChat() {
        return Chat;
    }

    public Date getWhen() {
        return When;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "id=" + id +
                ", Text='" + Text + '\'' +
                ", Replyer=" + Replyer +
                ", Chat=" + Chat +
                ", When=" + When +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reply reply = (Reply) o;
        return Objects.equals(getId(), reply.getId()) && getText().equals(reply.getText()) && getReplyer().equals(reply.getReplyer()) && getChat().equals(reply.getChat()) && getWhen().equals(reply.getWhen());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getText(), getReplyer(), getChat(), getWhen());
    }
}
