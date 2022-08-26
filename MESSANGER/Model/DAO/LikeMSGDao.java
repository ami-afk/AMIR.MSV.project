package MESSANGER.Model.DAO;

import MESSANGER.Model.LikeMSG;

public class LikeMSGDao extends Dao <LikeMSG>  {

    @Override
    String GetFileName() {
        return "Users.Data";
    }
}
