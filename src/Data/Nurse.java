package Data;

/**
 * Trida pro reprezentaci zdravotni sestry
 * @author Jan Rubas
 * @version 1.0
 */

public class Nurse {

    public int ID;
    public String name;
    public String lastName;
    public Department dep;
    public String status;


    public Nurse(int ID, String name, String lastName, Department dep, String status) {
        this.ID = ID;
        this.name = name;
        this.lastName = lastName;
        this.dep = dep;
        this.status = status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Department getDep() {
        return dep;
    }

    public String getStatus() {
        return status;
    }
}
