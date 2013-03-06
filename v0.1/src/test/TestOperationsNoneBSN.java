package test;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/**
 * Created by IntelliJ IDEA.
 * User: Dis
 * Date: 15.01.13
 * Time: 14:39
 * To change this template use File | Settings | File Templates.
 */
public class TestOperationsNoneBSN {

    public static void main(String[] args) {
        // from Joda to JDK
        DateTime dt = new DateTime();
        Calendar jdkCal = dt.toCalendar(new Locale("ru","RU"));
        System.out.println(jdkCal.getTime());

        java.util.Date dt2 = jdkCal.getTime();
        java.text.SimpleDateFormat sdf =
                new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", new Locale("ru", "RU"));
        String currentTime = sdf.format(dt2);
        System.out.println(currentTime);

        // from JDK to Joda
        dt = new DateTime(jdkCal);
        System.out.println(dt);

        String a = new DateTime().toString("dd MMM HH:mm:ss");
        System.out.println(a);

        List lst= null;
        System.out.println(lst.size());



    }
}
