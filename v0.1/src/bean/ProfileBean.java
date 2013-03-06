package bean;

import model.User;
import model.UserRole;
import services.IUserService;
import services.impl.JdbcUserService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

/**
 * Created by IntelliJ IDEA.
 * User: Dis
 * Date: 04.01.13
 * Time: 22:42
 * To change this template use File | Settings | File Templates.
 */

public class ProfileBean {
    private String avatarUrl;
    private UserRole role;
    private String info;

    public ProfileBean() {
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public User initialize(){
        IUserService im = new JdbcUserService();
        FacesContext context = FacesContext.getCurrentInstance();
        String myLogin = null;
        try {
            myLogin = context.getExternalContext().getSessionMap().get("user").toString();
        } catch (Exception e) {
            //e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return null;
        }

        User iAm = im.ViewMyProfile(myLogin);
        System.out.println(iAm);
        //        this.avatarUrl=iAm.getAvatarUrl();
//        this.role=iAm.getRole();
//        this.info=iAm.getInfo();
        //setInfo(iAm.getInfo());
        return iAm;
    }

}
