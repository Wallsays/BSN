package services.impl;

import dao.IMessagesDao;
import dao.IUserDao;
import dao.impl.JdbcImDao;
import dao.impl.JdbcUserDao;
import model.InstantMessage;
import services.IMessagesService;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Dis
 * Date: 02.01.13
 * Time: 19:50
 * To change this template use File | Settings | File Templates.
 */
public class JdbcMessageService implements IMessagesService {
    IMessagesDao md = new JdbcImDao();
    IUserDao ud = new JdbcUserDao();

    @Override
    public void sendMessage(InstantMessage im) {
        md.save(im);
    }

    @Override
    public List<InstantMessage> getAllPostedMessages(String login) {
        return md.getPostedMessages(ud.getUserByLogin(login).getId());
    }

    @Override
    public List<InstantMessage> getAllReceivedMessages(String login) {
        return md.getRecievedMessages(ud.getUserByLogin(login).getId());
    }

    @Override
    public InstantMessage viewMessage(String login) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
