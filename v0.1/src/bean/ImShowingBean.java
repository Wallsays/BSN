package bean;

import dao.IUserDao;
import dao.impl.JdbcUserDao;
import model.InstantMessage;
import model.InstantMessageWrapper;
import services.IMessagesService;
import services.impl.JdbcMessageService;

import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Dis
 * Date: 15.01.13
 * Time: 12:10
 * To change this template use File | Settings | File Templates.
 */
public class ImShowingBean implements Serializable {
    public InstantMessageWrapper[] outCome() {
        IMessagesService ims = new JdbcMessageService();
        IUserDao iud = new JdbcUserDao();

        FacesContext context = FacesContext.getCurrentInstance();
        String myLogin = context.getExternalContext().getSessionMap().get("user").toString();

        List<InstantMessage> list = ims.getAllPostedMessages(myLogin);

        if (list == null) return null;
        List<InstantMessageWrapper> l = new ArrayList<InstantMessageWrapper>();
        for (InstantMessage tmp : list) {
            String sender = iud.getUserById(tmp.getSender()).getFullName();
            String recipient = iud.getUserById(tmp.getRecipient()).getFullName();
            InstantMessageWrapper imw = new InstantMessageWrapper(tmp.getId(), sender, recipient, tmp.getMessage(), tmp.getFormattedPostTime());
            l.add(imw);
        }
        InstantMessageWrapper[] array = new InstantMessageWrapper[l.size()];
        l.toArray(array); // fill the array
        return array;
    }

    public InstantMessageWrapper[] inCome() {
        IMessagesService ims = new JdbcMessageService();
        IUserDao iud = new JdbcUserDao();

        FacesContext context = FacesContext.getCurrentInstance();
        String myLogin = context.getExternalContext().getSessionMap().get("user").toString();

        List<InstantMessage> list = ims.getAllReceivedMessages(myLogin);
        if (list == null) return null;
        List<InstantMessageWrapper> l = new ArrayList<InstantMessageWrapper>();
        for (InstantMessage tmp : list) {
            String sender = iud.getUserById(tmp.getSender()).getFullName();
            String recipient = iud.getUserById(tmp.getRecipient()).getFullName();
            InstantMessageWrapper imw = new InstantMessageWrapper(tmp.getId(), sender, recipient, tmp.getMessage(), tmp.getFormattedPostTime());
            l.add(imw);
        }
        InstantMessageWrapper[] array = new InstantMessageWrapper[l.size()];
        l.toArray(array); // fill the array
        return array;
    }
}
