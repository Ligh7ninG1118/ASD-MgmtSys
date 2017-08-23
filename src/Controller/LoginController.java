package Controller;

import DAO.UserDAO;
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
        UserDAO udao = new UserDAO();
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
            if (udao.searchUserByName(loginID).getType() == 0)
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("登录失败");
                alert.setHeaderText(null);
                alert.setContentText("账户申请尚未通过");
                alert.showAndWait();
                return;
            } else
            {
                userField.setText("");
                pwField.setText("");

                //myLogger.addUserInfo(uvf.getUserId(loginID));
                myController.loadStage(WriterViewID, WriterViewRes);
                myController.setStage(WriterViewID, Main.loginViewID);
            }
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
