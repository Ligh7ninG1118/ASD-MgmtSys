package Controller;

import MgmtSys.Main;
import Util.Logger;
import Util.UserVerif;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.User;

import static MgmtSys.Main.WriterViewID;
import static MgmtSys.Main.WriterViewRes;


public class LoginController implements ControlledStage
{
    UserVerif uvf = new UserVerif();
    StageController myController = new StageController();
    Logger myLogger = new Logger();
    @FXML
    private Button btn_login;
    @FXML
    private Button btn_reg;
    @FXML
    private TextField userField;
    @FXML
    private TextField pwField;
    @FXML
    private Label alertmessage;

    @FXML
    public void loginAction(ActionEvent e)
    {
        String loginID = userField.getText().trim();
        String password = pwField.getText().trim();
        if (loginID.equals("") || password.equals(""))
        {
            alertmessage.setText("Empty");
            return;
        }
        if (!uvf.AuthInfoVerif(loginID, password))
        {
            alertmessage.setText("Error");
            return;
        } else
        {
            myLogger.addUserInfo(uvf.getUserId(loginID));
            myController.loadStage(WriterViewID, WriterViewRes);
            myController.setStage(WriterViewID, Main.loginViewID);

        }
    }

    public void regAction(ActionEvent e)
    {
        myController.setStage(Main.RegisterViewID);
    }

    public void setStageController(StageController stageController)
    {
        this.myController = stageController;
    }

}
