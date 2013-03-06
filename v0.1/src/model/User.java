package model;

/**
 * Created by IntelliJ IDEA.
 * User: Dis
 * Date: 01.01.13
 * Time: 17:13
 * To change this template use File | Settings | File Templates.
 */

public class User {

    /**
     * Unique identifier.
     */
    private Long id = null;

    /** */
    private static final long serialVersionUID = 1L;

    /**
     * Login of the user
     */
    private String login;

    /**
     * Password of the user
     */
    private String password;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    private String fullName;

    /**
     * Url of the avatar image
     */
    private String avatarUrl;

//    /**
//     * The birthday of the {@link UserRole#VIP} user
//     */
//    @Temporal(TemporalType.DATE)
//    private Calendar birthDate = Calendar.getInstance(getDefLocale());

    /**
     * Role of the user
     */
    private UserRole role = UserRole.USER;

    /**
     * User's info
     */
    private String info;

    /**
     * Default empty constructor
     */
    public User() {
    }

    /**
     * Constructor with fields
     *
     * @param login    Login
     * @param password Password
     * @param role     Role
     */
    public User(Long id, String login, String password, UserRole role, String info) {
        //super();
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
        this.info = info;

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

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the role
     */
    public UserRole getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(UserRole role) {
        this.role = role;
    }

    /**
     * @return the avatarUrl
     */
    public String getAvatarUrl() {
        return avatarUrl;
    }

    /**
     * @param avatarUrl the avatarUrl to set
     */
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    /**
     * @return the info
     */
    public String getInfo() {
        return info;
    }

    /**
     * @param info is info about user
     */
    public void setInfo(String info) {
        this.info = info;
    }

//    /**
//     * @return the birthDate
//     */
//    public Calendar getBirthDate() {
//        return birthDate;
//    }
//
//    /**
//     * @param birthDate
//     *            the birthDate to set
//     */
//    public void setBirthDate(Calendar birthDate) {
//        this.birthDate = birthDate;
//    }

    public String toString(){
        return (id+" "+login+" "+password+" "+avatarUrl+" "+role+" "+info);
    }
}
