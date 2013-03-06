package services.impl;

import com.sun.org.apache.xpath.internal.operations.And;
import dao.IUserDao;
import dao.impl.JdbcUserDao;
import model.User;
import model.UserRole;
import services.IUserService;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Dis
 * Date: 02.01.13
 * Time: 19:49
 * To change this template use File | Settings | File Templates.
 */
public class JdbcUserService implements IUserService {
    IUserDao ud = new JdbcUserDao();

    @Override
    public boolean Login(String login, String password) {
        User u = ud.getUserByLoginAndPassword(login, password);
        if (u != null) {
            return true;
        }
        return false;
    }

    @Override
    public void Logout(String login) {
       // session close
    }

    @Override
    public boolean Registration(User u) {
        if(ud.isUserExist(u.getLogin())){
        }   else {
            ud.save(u);
            return true;
        }
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public User ViewOtherProfile(Long id, Long idToView) {
        User fu = ud.getUserById(id);
        UserRole role1 = fu.getRole();
        User u = ud.getUserById(idToView);
        UserRole role2 = u.getRole();
        if(role1== UserRole.ADMIN && role2==UserRole.ADMIN){
            //ok
        }   else if(role1== UserRole.ADMIN && role2==UserRole.USER) {
            //ok
        } else if(role1== UserRole.USER && role2==UserRole.USER){
            //ok
        } else {
            // user wants to see admins info
            u.setInfo("not allowed");
            System.out.println(" not");
        }
        
        return u;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public User ViewMyProfile(String login) {
        User iAm = ud.getUserByLogin(login);
        return iAm;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<User> ShowAllUsers() {
        List<User> lst = null;
        lst = ud.getAllUsers();
        return lst;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
