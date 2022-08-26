package MESSANGER.Model.DAO;

import MESSANGER.Model.Reply;

public class ReplyDao extends Dao <Reply> {

    @Override
    String GetFileName() {
        return "Users.Data";
    }
}
