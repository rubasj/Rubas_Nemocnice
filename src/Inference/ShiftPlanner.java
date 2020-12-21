package Inference;

import Data.DataLoader;
import Data.Department;
import Data.Nurse;

import java.util.*;

public class ShiftPlanner {

    public List<Department> departments = DataLoader.departments;


    public void createPlan() {
        departments.forEach(dep -> {

            List<Nurse> nightShift = new LinkedList<>();
            List<Nurse> afternoonShift = new LinkedList<>();
            List<Nurse> morningShift = new LinkedList<>();
            List<Nurse> nextMorningShift = new LinkedList<>();
            List<Nurse> nextAfternoonShift = new LinkedList<>();


            Calendar cal = Calendar.getInstance();


            for (int j = 0; j <= 365; j++) {            // Nacitani dni
                    // TODO napsat zde vyvoj jednotlivych smen a prirazovat je k sestrickam


                for (int i = 1; i <= dep.minCapacity; i++) {     //Ranni
                    morningShift.add(dep.changePositionInQueue());

                }
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
            }

        });

    }
}
