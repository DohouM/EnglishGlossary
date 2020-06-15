
/**
 * A class that describes a student.
 * 
 * @author Medhy DOHOU, Jean-Camille LAPIERRE, Dorian MOUNIER, Cyril PIGEYRE,
 *         Gabriel SAPONARA
 */
public class Student extends User {
    /**
     * Constructor of the Student class.
     * 
     * @param userName The username of the created student.
     */
    public Student(String userName) {
	super(userName);
    }

    /**
     * The group of the student.
     */
    private String group;

    /**
     * @return The group of the student.
     */
    public String getGroup() {
	return this.group;
    }

    /**
     * @param group The group to set for the student.
     */
    public void setGroup(String group) {
	this.group = group;
    }
}
