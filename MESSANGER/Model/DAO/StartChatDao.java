package MESSANGER.Model.DAO;

import MESSANGER.Model.StartChat;

public class StartChatDao extends Dao <StartChat> {
    @Override
    String GetFileName() {
        return "Users.Data";
    }

}
