package services;

import model.InstantMessage;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Dis
 * Date: 02.01.13
 * Time: 19:25
 * To change this template use File | Settings | File Templates.
 */
public interface IMessagesService {
    public void sendMessage (InstantMessage im);

    public List<InstantMessage> getAllPostedMessages (String login);

    public List<InstantMessage> getAllReceivedMessages (String login);

    public InstantMessage viewMessage (String login);
}
