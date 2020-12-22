package Inference;

import Data.DataLoader;
import Data.Department;
import Data.Nurse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Soubor s metodou, ktera postupne vytvari jednotlive instance smen podle prednstaveneho data.
 * @author Jan Rubas
 * @version 1.0.
 */
public class ShiftPlanner {

    public List<Department> departments = DataLoader.departments;


    /**
     * Metoda vytvori plan pro vsechna oddeleni
     */
    public void createPlan() {
        departments.forEach(dep -> {

            List<Nurse> nightShift = new LinkedList<>();
            List<Nurse> afternoonShift = new LinkedList<>();
            List<Nurse> morningShift = new LinkedList<>();
            List<Nurse> nextMorningShift = new LinkedList<>();
            List<Nurse> nextAfternoonShift = new LinkedList<>();


            SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
            String dateInString = "01-01-2020";                                 //Prednastavene datum. Lze casem zmenit.
            try {
                Date date = sdf.parse(dateInString);

                Calendar cal = Calendar.getInstance();
                cal.setTime(date);

            for (int j = 0; j <= 365; j++) {            // Nacitani dni
                cal.add(Calendar.DATE, j);              // pridani dne


                for (int i = 1; i <= dep.minCapacity; i++) {     //Ranni
                    morningShift.add(dep.changePositionInQueue());
                }
                //TODO dodelat pridani smen

                for (int i = 1; i <= dep.minCapacity; i++) {     //Odpoledni
                    if (nextMorningShift.size() == 0) {
                        afternoonShift.add(dep.changePositionInQueue());
                    } else {
                        afternoonShift.addAll(nextMorningShift);
                    }
                }



                for (int i = 1; i <= dep.minCapacity; i++) {     //Nocni
                    if (nextAfternoonShift.size() == 0) {
                        afternoonShift.add(dep.changePositionInQueue());
                    } else {
                        nightShift.addAll(nextAfternoonShift);
                    }
                }



                nextMorningShift.addAll(morningShift);
                nextAfternoonShift.addAll(afternoonShift);
                morningShift.clear();
                afternoonShift.clear();

                nightShift.forEach(dep::addToQueue);      // opetovne vlozeni sester do fronty
                nightShift.clear();
            }


            } catch (ParseException e) {
                    e.printStackTrace();
            }


        });

    }

}
