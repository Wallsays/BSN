package bean;

import org.apache.tomcat.jni.Directory;
import services.IUserService;
import services.impl.JdbcUserService;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * Created by IntelliJ IDEA.
 * User: Dis
 * Date: 04.01.13
 * Time: 17:40
 * To change this template use File | Settings | File Templates.
 */


public class LoginBean {
    String username;
    String password;

    public LoginBean() {
        //Empty Constructor
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String data) {
        this.username = data;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String data) {
        this.password = data;
    }

    public String login() {
        IUserService im = new JdbcUserService();
        FacesContext context = FacesContext.getCurrentInstance();
        if (im.Login(username, password)) {
            context.getExternalContext().getSessionMap().put("user", username);
            return "success";
        } else {
            FacesMessage message = new FacesMessage("Invalid Username and/or Password");
            context.addMessage("loginForm", message);
            return "failure";
        }
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "login.xhtml?faces-redirect=true";
    }
}