package MESSANGER.Service;

import MESSANGER.Model.DAO.Dao;
import MESSANGER.Model.Entity;

import java.util.Comparator;

public class IdGenerator <T extends Entity> {

    private Dao<T> dao;
    public IdGenerator(Dao<T> dao) {
        this.dao = dao;
    }
    public long getNextid() {
        Long Lastpersistedid = dao.getAll().stream()
                .map(Entity::getId)
                .sorted(Comparator.reverseOrder())
                .findFirst()
                .orElse(0L);

        return Lastpersistedid++;
    }
}
