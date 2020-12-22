package Inference;

import Data.*;
import Znalosti_Fakta.Znalosti;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Trida pro planovani smen
 * @author Jan Rubas
 * @version 1.1.
 */
public class ShiftGenerator {

    /**
     * Metoda vygeneruje odpoledni smenu, zjisti zda je datum vikend/pracovni den a podle toho nastavi hodiny
     * @param date datum smeny
     * @return Smena
     */
    public NurseShift generateAfternoonShift(Date date) {
        NurseShift shift;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if (cal.get(Calendar.DAY_OF_WEEK) >= 2 || cal.get(Calendar.DAY_OF_WEEK) >= 6)
            shift = new NurseShift("Odpoledni", Znalosti.ODPOLEDNI_SMENA, Znalosti.ODPOLEDNI_SMENA_OD, Znalosti.ODPOLEDNI_SMENA_DO, false, date, date);

        else
            shift = new NurseShift("Odpoledni vikend", Znalosti.ODPOLEDNI_SMENA_VIKEND, Znalosti.ODPOLEDNI_SMENA_VIKEND_OD, Znalosti.ODPOLEDNI_SMENA_VIKEND_DO, false, date, date);


        return shift;
    }

    /**
     * Metoda vygeneruje ranni smenu.
     * @param date datum smeny
     * @return Smena
     */
    public NurseShift generateMorningShift(Date date) {
        NurseShift shift = new NurseShift("Ranni", Znalosti.DENNI_SMENA, Znalosti.DENNI_SMENA_OD, Znalosti.DENNI_SMENA_DO, false, date, date);
        return shift;
    }

    /**
     * Metoda vygeneruje ranni smenu.
     * @param date datum smeny
     * @return Smena
     */
    public NurseShift generateNightShift(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, 1);
        NurseShift shift = new NurseShift("Nocni", Znalosti.NOCNI_SMENA, Znalosti.NOCNI_SMENA_OD, Znalosti.NOCNI_SMENA_DO, true, date, c.getTime());

        return shift;
    }
}
