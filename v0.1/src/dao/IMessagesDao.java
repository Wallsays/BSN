package dao;

import model.InstantMessage;
import model.User;

import java.util.List;

/**
 * Persistence interface for the InstantMessages object.

 */
public interface IMessagesDao {

     /**
     * Creates the HSQL database if it doesn't exist.
     */
    void createDatabase();

    void save(InstantMessage u);

    void deleteMessage(InstantMessage u);

    List<InstantMessage> getPostedMessages(Long userId);

    List<InstantMessage> getRecievedMessages(Long userId);



}
