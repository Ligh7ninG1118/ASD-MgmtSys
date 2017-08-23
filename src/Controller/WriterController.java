package Controller;

import Util.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.User;
import sun.rmi.runtime.Log;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class WriterController implements ControlledStage, Initializable
{
    StageController myController;
    Logger myLogger = new Logger();
    User user = null;

    @FXML
    private RadioButton rbtn_eula;

    @FXML
    private DatePicker birthdayDatePicker;

    @FXML
    private ChoiceBox subcommitCBox;
    @FXML
    private ChoiceBox commitCBox;
    @FXML
    private ChoiceBox searchTypeCBox;

    @FXML
    private TextField searchTextField;
    @FXML
    private TextField articleTitleTextField;
    @FXML
    private TextArea articleContentTextArea;
    @FXML
    private TextField oldpwTextField;
    @FXML
    private TextField newpwTextField;
    @FXML
    private TextField repwTextField;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField sexTextField;
    @FXML
    private TextField commTextField;
    @FXML
    private TextField addressTextField;


    @FXML
    private Button btn_search;
    @FXML
    private Button btn_signoff;
    @FXML
    private Button btn_submit;
    @FXML
    private Button btn_print;
    @FXML
    private Button btn_save;
    @FXML
    private Button btn_edit;
    @FXML
    private Button btn_clear;

    @FXML
    private Label nametag;


    public void setStageController(StageController stageController)
    {
        this.myController = stageController;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        user = myLogger.requireUserInfo();
        nametag.setText("欢迎您, "+user.getLoginID());
    }


}
