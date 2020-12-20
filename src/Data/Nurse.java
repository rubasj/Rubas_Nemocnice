package Data;

import java.util.LinkedList;

/**
 * Trida pro reprezentaci zdravotni sestry
 * @author Jan Rubas
 * @version 1.0
 */

public class Nurse {

    /** ID sestry **/
    public int ID;
    /** Krestni jmeno **/
    public String name;
    /** Prijmeni **/
    public String lastName;
    /** Pracoviste **/
    public Department dep;

    public LinkedList<NurseShift> smeny;

    public Nurse(int ID, String name, String lastName, Department dep) {
        this.ID = ID;
        this.name = name;
        this.lastName = lastName;
        this.dep = dep;

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

    @Override
    public String toString() {
        return "Nurse{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dep=" + dep.getName() +
                '}';
    }
}
