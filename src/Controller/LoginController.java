package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javax.swing.*;
import java.util.logging.Logger;


public class LoginController
{

    @FXML
    private Button btn_login;
    @FXML
    private Button btn_reg;
    @FXML
    private TextField userField;
    @FXML
    private TextField pwField;
    @FXML
    private RadioButton rbtn_isWriter;
    @FXML
    private RadioButton rbtn_isAdmin;

    @FXML
    public void loginAction(ActionEvent e)
    {
        String loginID = userField.getText().trim();
        String password = pwField.getText().trim();
        if(loginID.equals("")||password.equals(""))
        {
            //messagelabel输出反馈信息
            return;
        }
    }

    public void regAction(ActionEvent e)
    {

    }

}
