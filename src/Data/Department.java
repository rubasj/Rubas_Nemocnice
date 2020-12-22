package Data;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Trida pro reprezentaci oddeleni v nemocnici
 * @author Jan Rubas
 * @version 1.0
 */
public class Department {

    public Queue<Nurse> nurseQueue = new LinkedList<>();

    /** ID oddeleni **/
    public int id;

    /** Nazev oddeleni **/
    public String name;

    /** Minimalni pocet sester v jednu chvili na oddeleni */
    public int minCapacity;

    /**
     * Konstruktor tridy
     * @param id ID oddeleni
     * @param name nazev oddeleni
     * @param minCapacity minimalni pocet sester v jednu chvili na oddeleni
     */
    public Department(int id, String name, int minCapacity) {
        this.id = id;
        this.name = name;
        this.minCapacity = minCapacity;
    }

    /**
     * Pridani sestricky do fronty na smeny
     * @param nrs zdravotni sestra
     */
    public void addToQueue(Nurse nrs){
        nurseQueue.add(nrs);
    }

    /**
     * Metoda, ktera zmeni
     * @return Sestra vytahnuta z fronty
     */
    public Nurse moveFromQueue(){
        Nurse nurse = nurseQueue.poll();

        return nurse;
    }

    /**
     * Ziskani nazvu oddeleni
     * @return nazev oddeleni
     */
    public String getName() {
        return name;
    }

    /**
     * Ziskani minimalniho poctu sester v jednu chvili
     * @return minimalni pocet sester
     */
    public int getMinCapacity() {
        return minCapacity;
    }

    /**
     * Ziska cislo oddeleni
     * @return ID oddeleni
     */
    public int getID() {
        return id;
    }

    @Override
    public String toString() {
        return "Department{" +
                "nurseQueue=" + nurseQueue +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", minCapacity=" + minCapacity +
                '}';
    }
}
