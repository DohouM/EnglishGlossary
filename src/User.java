/**
 * A class that describes a user of the application.
 * 
 * @author Medhy DOHOU, Jean-Camille LAPIERRE, Dorian MOUNIER, Cyril PIGEYRE,
 *         Gabriel SAPONARA
 *
 */
public class User {
    /**
     * The username of the app user.
     */
    private String userName;

    /**
     * Constructor for User class.
     * @param userName The user name of the created user.
     */
    public User(String userName) {
	this.userName = userName;
    }

    /**
     * A getter for this User userName.
     * @return The <code>userName</code> of the User. 
     */
    public String getUserName() {
	return userName;
    }

    /**
     * A setter for this User userName
     * @param userName The <code>userName</code> to set.
     */
    public void setUserName(String userName) {
	this.userName = userName;
    }

}
