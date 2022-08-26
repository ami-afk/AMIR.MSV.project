package MESSANGER.Model.DAO;

import MESSANGER.Model.Chat;

public class ChatDao extends Dao <Chat>{

    @Override
    String GetFileName() {
        return "Users.Data";
    }

}
