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
import javafx.stage.StageStyle;

import java.io.InputStream;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class Main extends Application {
    public static String loginViewID = "LoginView";
    public static String loginViewRes = "/View/Login.fxml";

    public static String RegisterViewID = "RegisterView";
    public static String RegisterViewRes = "/View/Register.fxml";

    public static String WriterViewID = "WriterView";
    public static String WriterViewRes = "/View/Writer.fxml";

    public static String ArticleDetailViewID = "RegisterView";
    public static String ArticleDetailViewRes = "/View/Register.fxml";

    private StageController stageController;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        stageController = new StageController();

        //将主舞台交给控制器处理
        stageController.setPrimaryStage("primaryStage", primaryStage);
        stageController.loadStage(loginViewID, loginViewRes);
        stageController.loadStage(RegisterViewID, RegisterViewRes);

        //显示MainView舞台
        stageController.setStage(loginViewID);
    }

    public void showWriterView()
    {

    }

    public void showArticleDetailView()
    {
        stageController.loadStage(ArticleDetailViewID, ArticleDetailViewRes);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
