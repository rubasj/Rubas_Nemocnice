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

    /** seznam smen */
    public LinkedList<NurseShift> shifts;

    /**
     * Konstruktor tridy
     * @param ID id sestry
     * @param name krestni jmeno
     * @param lastName prijmeni
     * @param dep oddeleni, pro ktere se specialiyuje
     */
    public Nurse(int ID, String name, String lastName, Department dep) {
        this.ID = ID;
        this.name = name;
        this.lastName = lastName;
        this.dep = dep;
        shifts = new LinkedList<>();
    }

    /**
     * Ziskani krestniho jmena
     * @return krestni jmeno
     */
    public String getName() {
        return name;
    }

    /**
     * Ziskani prijmeni
     * @return prijmeni
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Ziskani pracoviste - oddeleni sestry
     * @return pracoviste
     */
    public Department getDep() {
        return dep;
    }

    /**
     * Kompletni info o zdravotni sestre
     * @return
     */
    public String getInfo(){
        return "Id: \t" + ID + "\n" +
                "Jméno:\t" + this.toString() + "\n"
                + "Specializace:\t" + getDep().name;
    }
    /**
     * Textovy vypis
     * @return vypis
     */
    @Override
    public String toString() {
        return getLastName() + " " + getName();
    }
}
