package Data;

/**
 * Trida pro reprezentaci oddeleni v nemocnici
 * @author Jan Rubas
 * @version 1.0
 */
public class Department {

    /** ID oddeleni **/
    public int id;

    /** Nazev oddeleni **/
    public String name;


    public int minCapacity;


    public Department(int id, String name, int minCapacity) {
        this.id = id;
        this.name = name;
        this.minCapacity = minCapacity;
    }

    public String getName() {
        return name;
    }

    public int getMinCapacity() {
        return minCapacity;
    }

    public int getID() {
        return id;
    }
}
