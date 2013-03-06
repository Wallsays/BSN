package services;

import model.User;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Dis
 * Date: 02.01.13
 * Time: 19:13
 * To change this template use File | Settings | File Templates.
 */
public interface IUserService {
    
    public boolean Login(String login, String password);

    public void Logout(String login);   
    
    public boolean Registration(User u);
    
    public User ViewOtherProfile(Long id, Long idToView);

    public User ViewMyProfile(String login);
    
    public List<User> ShowAllUsers();





}
