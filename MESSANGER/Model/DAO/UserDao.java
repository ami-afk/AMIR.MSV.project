package MESSANGER.Model.DAO;

import MESSANGER.Model.User;

public class UserDao  extends Dao <User> {
    String GetFileName() {
        return "Users.Data";
    }


}
