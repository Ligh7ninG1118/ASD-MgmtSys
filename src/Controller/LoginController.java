package Controller;

import Util.UserVerif;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javax.swing.*;
import java.util.logging.Logger;


public class LoginController
{
    UserVerif uvf = new UserVerif();


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
        if(loginID.equals("")||password.equals(""))
        {
            alertmessage.setText("Empty");
            return;
        }
        if(!uvf.AuthInfoVerif(loginID,password))
        {
            alertmessage.setText("Error");
            return;
        }
        else
            alertmessage.setText("Success");
    }

    public void regAction(ActionEvent e)
    {

    }

}
