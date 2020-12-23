package User_Interface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Ovladac okna pro zobrazeni informaci a ovladani aplikace.
 * @author Jan Rubas
 * @email janrubas@students.zcu.cz
 * @version 1.0
 */
public class InfoStageController {

    /**
     * Tlacitko pro zavreni okna.
     */
    @FXML
    private Button cancelBT;

    /**
     * Akce pro zavreni okna.
     * @param event uzavreni okna.
     */
    @FXML
    private void closeWindow(ActionEvent event){
        // get a handle to the stage
        Stage stage = (Stage) cancelBT.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

}
