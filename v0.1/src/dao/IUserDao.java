package dao;

import model.User;

import javax.sql.DataSource;
import java.util.List;

/**
 * Persistence interface for the User object.

 */
public interface IUserDao {

     /**
     * Creates the HSQL database if it doesn't exist.
     */
    void createDatabase();

    void save(User u);

    void delete(Long userId);

    boolean isUserExist(String login);

    User getUserById(Long id);

    User getUserByLogin(String login);

    User getUserByLoginAndPassword(String login, String password);

    List<User> find(String searchString);

    List<User> getAllUsers();

}
