package Data;

import java.util.Date;

/**
 * Trida pro reprezentaci jednotlivych smen
 * @author  Jan Rubas
 * @version 1.0.2
 */
public class NurseShift {

    /**
     * Typ smeny
     */
    public String typ;
    /**
     * Pocet hodin
     */
    public int pocetHodin;
    /**
     * Zacatek
     */
    public int startTime;
    /**
     * Konec
     */
    public int endTime;
    /**
     * Zda byla smena pres pulnoc
     */
    public boolean konecNasledujiciDen;

    /**
     * Datum smeny
     */
    public Date date;

    /**
     * Konstruktor
     * @param typ Typ smeny
     * @param pocetHodin Pocet hodin k odpracovani
     * @param startTime Zacatek smeny
     * @param endTime Konec smeny
     * @param konecNasledujiciDen zda se pracuje pres pulnoc
     * @param date datum smeny
     * @param endDate datum konce
     */
    public NurseShift(String typ, int pocetHodin, int startTime, int endTime, boolean konecNasledujiciDen, Date date, Date endDate) {
        this.date = date;
        this.typ = typ;
        this.pocetHodin = pocetHodin;
        this.startTime = startTime;
        this.endTime = endTime;
        this.konecNasledujiciDen = konecNasledujiciDen;
    }

}
