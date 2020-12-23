package User_Interface;

import Inference.ShiftGenerator;
import Inference.ShiftPlanner;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import Data.DataLoader;

/**
 * Vychozi trida programu
 * @author Jan Rubas
 * @email janrubas@students.zcu.cz
 * @version 1.0
 */
public class Main extends Application {

    public ShiftGenerator planovac = new ShiftGenerator();

    /**
     * Start GUI
     * @param primaryStage primarni cast GUI
     * @throws Exception vyjimka
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("mainStage.fxml"));
        primaryStage.setTitle("Plánovač směn");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    /**
     * Startovaci metoda programu
     * @param args argumenty prikazove radky
     */
    public static void main(String[] args) {

        DataLoader dl = new DataLoader();
        dl.loadData();

        ShiftPlanner sp = new ShiftPlanner();
        sp.createPlan();

        launch(args);
    }


}
