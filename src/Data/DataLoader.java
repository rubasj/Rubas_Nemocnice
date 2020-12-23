package Data;

import Znalosti_Fakta.Znalosti;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Trida pro nacitani dat
 * @author Jan Rubáš
 * @version 1.2.1
 */
public class DataLoader {

    /**
     * Seznam oddeleni
     */
    public static List<Department> departments = new ArrayList();

    /**
     * Seznam sestricek
     */
    public static List<Nurse> nurses = new ArrayList();

    /**
     * Metoda pro nacteni dat, ktera je volana z GUI, popr Mainu
     */
    public void loadData(){
        readDepartments();
        readNurses();

        departments.forEach(department -> {
            if (department.nurseQueue.size() < department.getMinCapacity() * Znalosti.MAX_POCET_SMEN * Znalosti.DNI_VOLNO_MIN){
                System.out.println("Nedostatek zdravotnich sester na oddělení " + department.getName() +
                        ".\n Bude docházet k přesčasům zdravotních sester podle pravidel nastavených v systému.");

            }
        });
        System.out.println(departments);
    }

    /**
     * Metoda pro nacteni zdravotnich sester
     */
    private void readNurses() {
        loadFile(Paths.get("Nurse_Data.csv"));
    }

    /**
     * Obecna metoda, ktera obsahuje nacteni jednotlivych souboru.
     * @param filePath cesta k souboru
     */
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
                    Nurse nrs = new Nurse(Integer.parseInt(values[1]), values[2], values[3], findDepartment(values[4]));
                    nurses.add(nrs);
                    for (Department d:
                            departments
                         ) {
                        if (d.getID() == nrs.getDep().getID()) {
                            d.addToQueue(nrs);
                            d.nurses.add(nrs);
                        }
                        // zarazeni zdravotni sestry na konkretni oddeleni
                    }

                    System.out.println(nrs);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Zjisteni oddeleni, kam patri zdravotni sestra
     * @param dep oddeleni ve string
     * @return konkretni oddeleni
     */
    private Department findDepartment(String dep) {
        for(Department d:departments) {
            if (d.name.equals(dep)){
                return  d;
            }
        }
        System.err.println("CHYBA PRI NACITANI DAT");
        System.exit(-1);
        return new Department(0, "Chyba nacteni Oddeleni", 100); // pokud dojde k nejake chybe pri nacitani, i kdyz asi nedojde
    }

    /**
     * Nacitani jednotlivych oddeleni
     */
    private void readDepartments(){
        loadFile(Paths.get("Department_Data.csv"));
    }

}
