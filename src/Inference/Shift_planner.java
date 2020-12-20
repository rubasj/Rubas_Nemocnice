package Inference;

import Data.DataLoader;
import Data.Department;
import Data.Nurse;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Shift_planner {

    public List<Department> departments = DataLoader.departments;
    public Queue<Nurse> frontaInterna;
    public Queue<Nurse> frontaJIP;
    public Queue<Nurse> frontaChirurg;

    public Shift_planner(){
        frontaChirurg = new LinkedList<>();
        frontaJIP = new LinkedList<>();
        frontaInterna = new LinkedList<>();

    }
    public void addToQueue(Nurse nrs){
        for (Department dp:
                departments) {
            if (nrs.getDep().getID() == dp.getID()){

            }
        }

    }

    public void removeFromQueue(){

    }

}
