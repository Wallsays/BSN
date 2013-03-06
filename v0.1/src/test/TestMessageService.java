package test;

import model.InstantMessage;
import services.IMessagesService;
import services.impl.JdbcMessageService;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

/**
 * Created by IntelliJ IDEA.
 * User: Dis
 * Date: 02.01.13
 * Time: 21:32
 * To change this template use File | Settings | File Templates.
 */
public class TestMessageService {
    public static void main(String[] args) {
        IMessagesService ims = new JdbcMessageService();

        InstantMessage im = new InstantMessage();
        im.setSender(3L);
        im.setRecipient(1L);
        im.setMessage("just for lulz");


        System.out.println("----- SEND -----");
        ims.sendMessage(im);
        System.out.println(im);
        System.out.println(im.getFormattedPostTime());

        System.out.println("----- getAllPostedMessages -----");
        for (InstantMessage tmp : ims.getAllPostedMessages("dis")) {
            System.out.println(tmp);
        }

        System.out.println("----- getAllReceivedMessages -----");
        for (InstantMessage tmp : ims.getAllReceivedMessages("alex")) {
            System.out.println(tmp);
        }

    }
}
