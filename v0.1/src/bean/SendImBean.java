package bean;

import dao.IUserDao;
import dao.impl.JdbcUserDao;
import model.InstantMessage;
import model.User;
import services.IMessagesService;
import services.IUserService;
import services.impl.JdbcMessageService;
import services.impl.JdbcUserService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: Dis
 * Date: 05.01.13
 * Time: 22:51
 * To change this template use File | Settings | File Templates.
 */

public class SendImBean {
    private String senderLogin;
    private String adressLogin;
    private String message;
    private Date postTime = Calendar.getInstance(new Locale("ru", "RU")).getTime();

    public SendImBean() {
    }

    public String getSenderLogin() {
        return senderLogin;
    }

    public void setSenderLogin(String senderLogin) {
        this.senderLogin = senderLogin;
    }

    public String getAdressLogin() {
        return adressLogin;
    }

    public void setAdressLogin(String adressLogin) {
        this.adressLogin = adressLogin;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getPostTime() {
        return postTime;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }

    public void sendIm(){
        IMessagesService ims = new JdbcMessageService();
        IUserDao iud = new JdbcUserDao();
        
        FacesContext context = FacesContext.getCurrentInstance();
        String myLogin = context.getExternalContext().getSessionMap().get("user").toString();
        
        User iAm = iud.getUserByLogin(myLogin);
        Long myId  = iAm.getId();
        User adr = iud.getUserByLogin(adressLogin);
        Long adrId  = adr.getId();

        InstantMessage im = new InstantMessage();
        im.setSender(myId);
        im.setRecipient(adrId);
        im.setMessage(message);
        ims.sendMessage(im);
    }


    
    public List<InstantMessage> getMyMessages(){
        IMessagesService ims = new JdbcMessageService();
        List<InstantMessage> lst = new LinkedList<InstantMessage>();
        
        
        return lst;
    }
    
    public List<InstantMessage> getMessagesForMe(){
        IMessagesService ims = new JdbcMessageService();
        List<InstantMessage> lst = new LinkedList<InstantMessage>();
        
        
        return lst;
    }

    public User initialize(){
        IUserService im = new JdbcUserService();
        FacesContext context = FacesContext.getCurrentInstance();
        String myLogin = context.getExternalContext().getSessionMap().get("user").toString();
        User iAm = im.ViewMyProfile(myLogin);
        System.out.println(iAm);
        //        this.avatarUrl=iAm.getAvatarUrl();
//        this.role=iAm.getRole();
//        this.info=iAm.getInfo();
        //setInfo(iAm.getInfo());
        return iAm;
    }
}

