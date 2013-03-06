package test;

import model.User;
import services.IUserService;
import services.impl.JdbcUserService;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/**
 * Created by IntelliJ IDEA.
 * User: Dis
 * Date: 02.01.13
 * Time: 19:46
 * To change this template use File | Settings | File Templates.
 */
public class TestUserService {
    public static void main(String[] args){

        IUserService im = new JdbcUserService();

        String l = "dis";
        String p = "111";

//        System.out.println("----- LOGIN -----");
//        System.out.println(im.Login(l, p));
//        System.out.println(im.Login("pop",p));
//        System.out.println(im.Login(null,p));
//
//        System.out.println("----- Logout -----");
//        im.Logout(l);
//        im.Logout("pop");
//        im.Logout(null);
//
//        System.out.println("----- Registration -----");
//        User u = new User();
//        u.setInfo("bla-bla");
//        u.setLogin("alla");
//        System.out.println(im.Registration(u));
//
//
//        System.out.println("----- ViewOtherProfile -----");
//        Long id1 = 1L;   // dis  admin
//        Long id2 = 2L; // alex  user
//        Long id3 = 3L; // alla  user
//        System.out.println(im.ViewOtherProfile(id2,id1));

        System.out.println("----- ShowAllUsers -----");
        for (User tmp : im.ShowAllUsers()) {
            System.out.println(tmp);
        }
    }
}
