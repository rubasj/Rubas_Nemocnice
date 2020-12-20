package Data;

/**
 * Trida pro reprezentaci oddeleni v nemocnici
 * @author Jan Rubas
 * @version 1.0
 */
public class Department {

    public int id;
    public String name;
    public int maxCapacity;
    public int minCapacity;


    public Department(int id, String name, int maxCapacity, int minCapacity) {
        this.id = id;
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.minCapacity = minCapacity;
    }

    public String getName() {
        return name;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getMinCapacity() {
        return minCapacity;
    }
}
