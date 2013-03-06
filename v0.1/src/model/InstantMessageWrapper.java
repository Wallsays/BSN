package model;

/**
 * Created by IntelliJ IDEA.
 * User: Dis
 * Date: 15.01.13
 * Time: 20:49
 * To change this template use File | Settings | File Templates.
 */
public class InstantMessageWrapper {
    private Long iMid;
    private String sender;
    private String recipient;
    private String message;
    private String postTime;

    public InstantMessageWrapper(Long iMid, String sender, String recipient, String message, String postTime) {
        this.iMid = iMid;
        this.sender = sender;
        this.recipient = recipient;
        this.message = message;
        this.postTime = postTime;
    }

    public Long getiMid() {
        return iMid;
    }

    public void setiMid(Long iMid) {
        this.iMid = iMid;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String dateTime) {
        this.postTime = dateTime;
    }
}
