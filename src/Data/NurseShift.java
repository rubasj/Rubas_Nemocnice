package Data;

public class NurseShift {
    public String nazev;
    public int pocetHodin;
    public int startTime;
    public int endTime;
    public boolean konecNasledujiciDen;

    public NurseShift(String nazev, int pocetHodin, int startTime, int endTime, boolean konecNasledujiciDen) {
        this.nazev = nazev;
        this.pocetHodin = pocetHodin;
        this.startTime = startTime;
        this.endTime = endTime;
        this.konecNasledujiciDen = konecNasledujiciDen;
    }

    public String getNazev() {
        return nazev;
    }

    public int getPocetHodin() {
        return pocetHodin;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public boolean isKonecNasledujiciDen() {
        return konecNasledujiciDen;
    }
}
