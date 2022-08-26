package MESSANGER.Model;

import java.util.Objects;

public class User implements Entity {

    private long id;
    private String UserName;
    private String Password;
    private String Profile;
    private String Bio;


    public User(long id, String userName, String password, String profile, String bio) {
        this.id = id;
        UserName = userName;
        Password = password;
        Profile = profile;
        Bio = bio;
    }

    public User(long id) {
        this.id = id;


    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getProfile() {
        return Profile;
    }

    public void setProfile(String profile) {
        Profile = profile;
    }

    public String getBio() {
        return Bio;
    }

    public void setBio(String bio) {
        Bio = bio;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", UserName='" + UserName + '\'' +
                ", Password='" + "!!!!!!!!" + '\'' +
                ", Profile='" + Profile + '\'' +
                ", Bio='" + Bio + '\'' +
                '}';
    }

    public User(String userName, String password, String profile) {
        UserName = userName;
        Password = password;
        Profile = profile;





    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getUserName().equals(user.getUserName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserName());
    }
}
