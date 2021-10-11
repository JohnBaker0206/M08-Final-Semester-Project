package Main;

//Import javafx
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;


import Model.RealEstate;
import Model.Stock;
import Model.User;
import Views.Root;


//My main class
public class Driver extends Application {
    //Objects used to store the user data
    public static User user;
    public static RealEstate realEstate;
    public static Stock stock;
    public static double NET_WORTH = 0;

    
    @Override
    public void start(Stage stage) throws Exception {
    	//Creates new scene
        stage.setScene(new Scene(new Root().getBorderPane(), 600, 400));
        //Sets title to "Track Investment"
        stage.setTitle("Track Investment");
        //Displays stage
        stage.show();
    }

    //My main
    public static void main(String[] args) {
        launch(args);
    }

    //Shows error message or information depending on the situation
    public static void showDialog(String msg, int type) {
        Alert alert;
        if (type == 0) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
        } else {
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("INFORMATION");
        }
        alert.setHeaderText(msg);
        alert.show();
    }
}
