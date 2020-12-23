package User_Interface;

import Data.DataLoader;
import Data.Department;
import Data.Nurse;
import Data.NurseShift;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Trida reprezentujici ovladani GUI
 * @author Jan Rubas
 * @version 1.0.
 */
public class Controller {


    @FXML
    private ListView<Nurse> nrsLV;

    @FXML
    private ListView<Department> depLV;

    @FXML
    private ListView<NurseShift> shiftLV;


    public void initialize() {
        depLV.getItems().addAll(DataLoader.departments);

    }

    /**
     * Akce na klik jednu polozku zdravotni sestry, ktera rozklikne vsechnny jeji smeny
     * @param arg0 parametr
     */
    @FXML
    public void handleMouseClickShift(MouseEvent arg0) {

    }

    /**
     * Akce na klik jednu polozku zdravotni sestry, ktera zobrazi ve vedlejsim LV jeji smeny
     * @param arg0 parametr
     */
    @FXML
    public void handleMouseClickNrs(MouseEvent arg0) {
        shiftLV.getItems().removeAll(shiftLV.getItems());
        shiftLV.getItems().addAll(nrsLV.getSelectionModel().getSelectedItem().shifts);
    }

    /**
     * Akce na klik jednu polozku oddeleni, ktera zobrazi seznam zdravotnich sester na LV
     * @param arg0 parametr
     */
    @FXML
    public void handleMouseClickDep(MouseEvent arg0) {
        nrsLV.getItems().removeAll(nrsLV.getItems());
        nrsLV.getItems().addAll(depLV.getSelectionModel().getSelectedItem().nurses);
    }


    @FXML
    private void getInfo(ActionEvent event){

    }

    /**
     * ukonceni aplikace
     * @param event stisk tlacitka
     */
    @FXML
    public void closeApp(ActionEvent event){
        Platform.exit();
    }

}
