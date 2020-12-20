package Data;

import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataLoader {

    public static List<Department> departments = new ArrayList<Department>();
    public static List<Nurse> nurses = new ArrayList<Nurse>();

    public void loadData(){
        readDepartments();
        readNurses();
    }

    private void readNurses() {
        loadFile(Paths.get("Nurse_Data.csv"));
    }

    private void loadFile(Path filePath) {
        try (BufferedReader br = Files.newBufferedReader(filePath.toAbsolutePath(),
                StandardCharsets.UTF_8)) {
            String line;
            while ((line = br.readLine()) != null){
                String[] values = line.split(";");
                if (values.length == 4) {      // pocet parametru instance Department
                    departments.add(new Department(Integer.parseInt(values[1]), values[2], Integer.parseInt(values[3])));
                    System.out.println(new Department(Integer.parseInt(values[1]), values[2], Integer.parseInt(values[3])));
                }
                else if(values.length == 5){ // pocet parametru instance Nurse
                    nurses.add(new Nurse(Integer.parseInt(values[1]), values[2], values[3], findDepartment(values[4])));
                    System.out.println(new Nurse(Integer.parseInt(values[1]), values[2], values[3], findDepartment(values[4])));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Department findDepartment(String dep) {
        for(Department d:departments) {
            if (d.name.equals(dep)){
                return  d;
            }
        }
        return new Department(0, "Chyba nacteni Oddeleni", 100);
    }

    private void readDepartments(){
        loadFile(Paths.get("Department_Data.csv"));
    }

}
