package MESSANGER.Service;

import MESSANGER.EXCEPTIONS.Errors.LoginFailedException;
import MESSANGER.Model.DAO.StartChatDao;
import MESSANGER.Model.DAO.UserDao;
import MESSANGER.Model.User;

import java.util.Objects;

public class UserManager {
    private UserDao UserDao;
    private StartChatDao startChatDao;

    private IdGenerator<User> userIdGenerator;

    public UserManager(UserDao userDao, StartChatDao startChatDao, IdGenerator<User> userIdGenerator) {

        this.UserDao = userDao;
        this.startChatDao = startChatDao;
        this.userIdGenerator = userIdGenerator;
    }

    public User login(String UserName, String Password) {

        return UserDao.getAll()
                .stream()
                .filter(user -> Objects
                        .equals(user.getUserName(), UserName) && user
                        .getPassword()
                        .equals(Password))
                .findFirst()
                .orElseThrow(() -> new LoginFailedException());


    }

    public User Register(String UserName, String Password) {
        User user= new User(UserName,Password,"https://");
        user.setId(userIdGenerator.getNextid());

        UserDao.save(user);
        return user;
    }
}


