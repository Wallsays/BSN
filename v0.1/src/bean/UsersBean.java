package bean;

import model.User;
import services.IUserService;
import services.impl.JdbcUserService;

import javax.faces.event.ComponentSystemEvent;
import java.io.Serializable;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Dis
 * Date: 15.01.13
 * Time: 20:20
 * To change this template use File | Settings | File Templates.
 */
public class UsersBean  implements Serializable {
    private List<User> users;

    public UsersBean() {

    }

    public List<User> getUsers() {
        IUserService us = new JdbcUserService();
        this.users=us.ShowAllUsers();
       return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    void initialize(ComponentSystemEvent event){
        IUserService us = new JdbcUserService();
        this.users=us.ShowAllUsers();
//        return this.users;
    }
    
}
