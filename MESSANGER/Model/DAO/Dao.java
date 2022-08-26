package MESSANGER.Model.DAO;

import MESSANGER.EXCEPTIONS.Errors.AlreadyExistException;
import MESSANGER.EXCEPTIONS.Errors.FileOpException;
import MESSANGER.EXCEPTIONS.Errors.NotFoundException;
import MESSANGER.Model.Entity;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Dao <T extends Entity> {
    private static final String FILES_PATH = "/RecycleBin";

    protected Dao() {
    }

    private Collection<T> ReadFromFile() {

        try {
            File dir = new File(FILES_PATH);
            if (!dir.exists()) {
                dir.mkdir();

            }
            File file = new File(FILES_PATH + "/" + GetFileName());
            if (!file.exists()) {
                file.createNewFile();
            }

            if (file.length() == 0) {
                WriteToFile(new ArrayList<>());
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (Collection<T>) objectInputStream.readObject();

        } catch (IOException | ClassNotFoundException e) {
            throw new FileOpException();
        }


    }
    private void WriteToFile(Collection<T> Records)  {
        try {
            File file = new File(  FILES_PATH+ "/" + GetFileName());
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(Records);
        } catch (IOException e) {
            throw new FileOpException();
        }



    }


    abstract String GetFileName() ;


     public T getByid(long id) {
        return getAll()
                .stream()
                .filter(item -> item.getId()==id )
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }


    public Collection<T> getAll() {
        return ReadFromFile();
    }


     public void save(T item) {
        Collection<T> items = getAll();

        items
                .stream()
                .filter(record -> record.equals(record))
                .findAny()
                .ifPresent(user -> {
                    throw new AlreadyExistException();
                });
        items.add(item) ;
        WriteToFile(items);
    }


    public void update(long id, T item) {

        getByid(id);

        delete(id);

        save(item);

    }



    public void delete(long id) {
        List<T> CollectionWithoutItem = getAll()
                .stream()
                .filter(user -> user.getId()!= id)
                .collect(Collectors.toList());
        WriteToFile(CollectionWithoutItem);

    }
}
