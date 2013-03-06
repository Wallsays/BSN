package model;


import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.text.DateFormat;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by IntelliJ IDEA.
 * User: Dis
 * Date: 01.01.13
 * Time: 18:04
 * To change this template use File | Settings | File Templates.
 */
public class InstantMessage {

    /**
     * Unique identifier.
     */
    private Long id = null;

    /** */
    private static final long serialVersionUID = 1L;

    /**
     * Message sender
     */
    private Long sender;

    /**
     * Message recipient
     */
    private Long recipient;

    /**
     * Message text
     */
    private String message;

    /**
     * Message post time
     */
    private DateTime postTime = new DateTime();

    public InstantMessage() {
    }

    public InstantMessage(Long id, Long sender, Long recipient, String message, DateTime postTime) {
        this.id = id;
        this.sender = sender;
        this.recipient = recipient;
        this.message = message;
        this.postTime = postTime;
    }

    public Long getSender() {
        return sender;
    }

    public void setSender(Long sender) {
        this.sender = sender;
    }

    public Long getRecipient() {
        return recipient;
    }

    public void setRecipient(Long recipient) {
        this.recipient = recipient;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DateTime getPostTime() {
        String a = new DateTime().toString("dd MMM HH:mm:ss");
        return postTime;
    }

    public String getFormattedPostTime() {
        return postTime.toString("dd MMM HH:mm:ss");
    }

    public void setPostTime(DateTime postTime) {
        this.postTime = postTime;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    public String toString(){
        return (id+" "+sender+" "+recipient+" "+message+" "+postTime);
    }
}
