/**
 * 
 */

/**
 * @author jcl
 *
 */
public class Student extends User {
	public Student(String userName) {
		super(userName);
		// TODO Auto-generated constructor stub
	}

	private String group;

	/**
	 * @return the group
	 */
	public String getGroup() {
		return group;
	}

	/**
	 * @param group the group to set
	 */
	public void setGroup(String group) {
		this.group = group;
	}
}
