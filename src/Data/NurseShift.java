package Data;

import java.text.SimpleDateFormat;
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
     * Datum smeny
     */
    public Date date;

    /**
     * Konecne datum smeny.
     */
    public Date endDate;

    /**
     * Konstruktor
     * @param typ Typ smeny
     * @param pocetHodin Pocet hodin k odpracovani
     * @param startTime Zacatek smeny
     * @param endTime Konec smeny
     * @param date datum smeny
     * @param endDate datum konce
     */
    public NurseShift(String typ, int pocetHodin, int startTime, int endTime, Date date, Date endDate) {
        this.date = date;
        this.typ = typ;
        this.pocetHodin = pocetHodin;
        this.startTime = startTime;
        this.endTime = endTime;
        this.endDate = endDate;
    }

    /**
     * Vypise pouze zakladni udaje o smene.
     * @return vrati stringovy retezec
     */
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dateString = sdf.format(date);
        return dateString + " " + typ;
    }

    /**
     * Vypise informace o smene
     * @return informace
     */
    public String getInfo() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dateString = sdf.format(date);
        String endString = sdf.format(endDate);
        return "Směna:\t" + typ +"\n" +
                "\tzačátek:\t" + startTime+":00 dne " + dateString + "\n" +
                "\tkonec" + endTime + ":00 dne " + endString;
    }
}
