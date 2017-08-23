package MgmtSys;


import Controller.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Constant;

import java.io.InputStream;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class Main extends Application {

    private Stage mainStage;
    private Stage modalStage;
    private MainController mainController;

    @Override
    public void start(Stage stage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Register");
        stage.setScene(scene);
        stage.show();
    }




    public static void main(String[] args) {
        launch(args);
    }
}
