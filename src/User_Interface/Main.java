package User_Interface;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.xml.crypto.Data;

import Data.DataLoader;

/**
 * Vychozi trida programu
 * @author Jan Rubas
 * @version 1.0
 */
public class Main extends Application {

    /**
     * Start GUI
     * @param primaryStage primarni cast GUI
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    /**
     * Startovaci metoda programu
     * @param args argumenty prikazove radky
     */
    public static void main(String[] args) {

        DataLoader dl = new DataLoader();

        dl.loadData();
        launch(args);
    }


}
