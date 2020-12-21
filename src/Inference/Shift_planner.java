package Inference;

import Data.*;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Shift_planner {

    public List<Department> departments = DataLoader.departments;
    public List<Nurse> nurses = DataLoader.nurses;
    public Shift_planner(){

    }
    public void addToQueue(Nurse nrs){
        for (Department dp:
                departments) {
            if (nrs.getDep().getID() == dp.getID()){
                dp.addToQueue(nrs);
            }
        }
        
    }

    public NurseShift generateAfternoonShift(Nurse nrs, Date date) {
        // TODO dodelat rozpoznani vikendu
        NurseShift shift = new NurseShift("Odpoledni", Znalosti.ODPOLEDNI_SMENA, Znalosti.ODPOLEDNI_SMENA_OD, Znalosti.ODPOLEDNI_SMENA_DO, false, date);

        return shift;
    }
    
    public NurseShift generateMorningShift(Date date) {
        NurseShift shift = new NurseShift("Ranni", Znalosti.DENNI_SMENA, Znalosti.DENNI_SMENA_OD, Znalosti.DENNI_SMENA_DO, false, date);
        return shift;
    }
    
    public NurseShift generateNightShift(Date date) {
        NurseShift shift = new NurseShift("Nocni", Znalosti.NOCNI_SMENA, Znalosti.NOCNI_SMENA_OD, Znalosti.NOCNI_SMENA_DO, true, date);

        return shift;
    }
}
