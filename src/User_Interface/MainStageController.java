package User_Interface;

import Data.DataLoader;
import Data.Department;
import Data.Nurse;
import Data.NurseShift;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * Trida reprezentujici ovladani GUI
 * @author Jan Rubas
 * @version 1.3.
 */
public class MainStageController {

    /** LV pro zdravotni sestry */
    @FXML
    private ListView<Nurse> nrsLV;

    /** LV pro nemocnicni oddeleni */
    @FXML
    private ListView<Department> depLV;

    /** LV pro smeny zdravotnich sester */
    @FXML
    private ListView<NurseShift> shiftLV;

    /** Inicializace zakladnich dat. */
    public void initialize() {
        depLV.getItems().addAll(DataLoader.departments);

    }

    /**
     * Akce na klik jednu polozku zdravotni sestry, ktera rozklikne vsechnny jeji smeny
     * @param arg0 parametr
     */
    @FXML
    public void handleMouseClickShift(MouseEvent arg0) throws IOException {
        if (arg0.getClickCount() == 2) {// Double click

            Label secondLabel = new Label(shiftLV.getSelectionModel().getSelectedItem().getInfo());
            StackPane secondaryLayout = new StackPane();
            secondaryLayout.getChildren().add(secondLabel);
            Scene secondScene = new Scene(secondaryLayout, 230, 100);
            Stage infoStage = new Stage();
            infoStage.setTitle(shiftLV.getSelectionModel().getSelectedItem().typ);
            infoStage.setScene(secondScene);
            infoStage.show();
        }
    }

    /**
     * Akce na klik jednu polozku zdravotni sestry, ktera zobrazi ve vedlejsim LV jeji smeny
     * @param arg0 parametr
     */
    @FXML
    public void handleMouseClickNrs(MouseEvent arg0) throws IOException {
        if (arg0.getClickCount() == 2) {                                            // Double click
            Label secondLabel = new Label(nrsLV.getSelectionModel().getSelectedItem().getInfo());
            StackPane secondaryLayout = new StackPane();
            secondaryLayout.getChildren().add(secondLabel);
            Scene secondScene = new Scene(secondaryLayout, 230, 100);
            Stage infoStage = new Stage();
            infoStage.setTitle(nrsLV.getSelectionModel().getSelectedItem().toString());
            infoStage.setScene(secondScene);
            infoStage.show();
        }
        shiftLV.getItems().removeAll(shiftLV.getItems());
        shiftLV.getItems().addAll(nrsLV.getSelectionModel().getSelectedItem().shifts);
    }

    /**
     * Akce na klik jednu polozku oddeleni, ktera zobrazi seznam zdravotnich sester na LV
     * @param arg0 parametr
     */
    @FXML
    public void handleMouseClickDep(MouseEvent arg0) throws IOException {
        if (arg0.getClickCount() == 2) {                                            // Double click
            Label secondLabel = new Label(depLV.getSelectionModel().getSelectedItem().getInfo());
            StackPane secondaryLayout = new StackPane();
            secondaryLayout.getChildren().add(secondLabel);
            Scene secondScene = new Scene(secondaryLayout, 230, 100);
            Stage infoStage = new Stage();
            infoStage.setTitle(depLV.getSelectionModel().getSelectedItem().getName());
            infoStage.setScene(secondScene);
            infoStage.show();
        }
        shiftLV.getItems().clear();
        nrsLV.getItems().removeAll(nrsLV.getItems());
        nrsLV.getItems().addAll(depLV.getSelectionModel().getSelectedItem().nurses);
    }


    /**
     * Ziskani informaci o ovladani programu.
     * @param event po kliknuti
     * @throws IOException vyhozeni vyjimky.
     */
    @FXML
    private void getInfo(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("infoStage.fxml"));
        Stage infoStage = new Stage();
        infoStage.setTitle("Informace");
        infoStage.setScene(new Scene(root));
        infoStage.show();
    }

    /**
     * Ukonceni aplikace
     * @param event stisk tlacitka
     */
    @FXML
    public void closeApp(ActionEvent event){
        Platform.exit();
    }




}
