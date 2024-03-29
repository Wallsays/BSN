package bean;

import model.User;
import model.UserRole;
import services.IUserService;
import services.impl.JdbcUserService;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Dis
 * Date: 04.01.13
 * Time: 19:32
 * To change this template use File | Settings | File Templates.
 */


public class RegistrationBean {
    private String username;
    private String password;
    private String avatarUrl;
    private UserRole role = UserRole.USER;
    private String info;

    public RegistrationBean() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    //Generated by Map
    private static Map<String,Object> roleValue;
    static{
        roleValue = new LinkedHashMap<String,Object>();
        for(UserRole ur:UserRole.values()) {
            roleValue.put(ur.toString(), ur);
        }

    }

    public Map<String,Object> getRoleValue() {
        return roleValue;
    }

    public String register(){
        IUserService im = new JdbcUserService();

        User u = new User();
        u.setLogin(username);
        u.setPassword(password);
        u.setAvatarUrl(avatarUrl);
        u.setRole(role);
        u.setInfo(info);

        if ( im.Registration(u)) {
            //im.Login(username, password);
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getSessionMap().put("user", username);
            return "success";
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            FacesMessage message = new FacesMessage("Something wrong");
            context.addMessage("regForm", message);
            return "failure";
        }

    }
}
