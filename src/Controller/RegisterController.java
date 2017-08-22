package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.xml.soap.Text;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

public class RegisterController
{
    @FXML
    private Label alertmessageLabel;
    @FXML
    private Button regButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Button clrButton;

    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private PasswordField repasswordTextField;
    @FXML
    private TextField nameTextField;
    @FXML
    private DatePicker birthdayDatePicker;
    @FXML
    private ChoiceBox sexCBox;
    @FXML
    private TextField commTextField;
    @FXML
    private TextField addressTextField;
    @FXML
    private TextField recommTextField;
    @FXML
    private ChoiceBox subcommitCBox;
    @FXML
    private ChoiceBox commitCBox;


    @FXML
    public void registerAction(ActionEvent e)
    {
        if (ifInvaildInput())
            return;

        alertmessageLabel.setText("");
        String username = usernameTextField.getText().trim();
        String password = passwordTextField.getText();
        String repassword = repasswordTextField.getText();

        String name = nameTextField.getText().trim();
        String birthday = birthdayDatePicker.getValue().toString();
        String sex = sexCBox.getValue().toString();
        String comm = commTextField.getText().trim();
        String address = addressTextField.getText().trim().trim();
        String subcommit = subcommitCBox.getValue().toString();
        String commit = commitCBox.getValue().toString();


    }

    @FXML
    public void cancelAction(ActionEvent e)
    {

    }

    @FXML
    public void clearAction(ActionEvent e)
    {
        usernameTextField.clear();
        passwordTextField.clear();
        repasswordTextField.clear();
        nameTextField.clear();
        commTextField.clear();
        addressTextField.clear();
        recommTextField.clear();

        birthdayDatePicker.setValue(null);
        sexCBox.setValue(null);
        subcommitCBox.setValue(null);
        commitCBox.setValue(null);

        alertmessageLabel.setText("");
    }

    public boolean ifInvaildInput()
    {
/**
 *  TextFields 判断
 */
        if (usernameTextField.getText().equals(""))
        {
            alertmessageLabel.setText("用户名不能为空");
            return true;
        }
        if (passwordTextField.getText().equals(""))
        {
            alertmessageLabel.setText("密码不能为空");
            return true;
        }
        if (repasswordTextField.getText().equals(""))
        {
            alertmessageLabel.setText("确认密码不能为空");
            return true;
        }
        if (nameTextField.getText().equals(""))
        {
            alertmessageLabel.setText("姓名不能为空");
            return true;
        }
        if (commTextField.getText().equals(""))
        {
            alertmessageLabel.setText("联系方式不能为空");
            return true;
        }
/**
 *  ChoiceBoxs 判断
 */

        if (sexCBox.getValue() == null)
        {
            alertmessageLabel.setText("请选择性别");
            return true;
        }
        if (commitCBox.getValue() == null)
        {
            alertmessageLabel.setText("请选择专委会");
            return true;
        }
        if (subcommitCBox.getValue() == null)
        {
            alertmessageLabel.setText("请选择行业分会");
            return true;
        }
/**
 *  其他 判断
 */

        if (!passwordTextField.getText().equals(repasswordTextField.getText()))
        {
            alertmessageLabel.setText("两次输入密码不一致");
            return true;
        }
        System.out.println(birthdayDatePicker.getValue().toString());
        System.out.println(LocalDate.now().toString());
        if(birthdayDatePicker.getValue().toString().compareTo(LocalDate.now().toString()) > 0)
        {
            alertmessageLabel.setText("生日选择错误");
            return true;
        }


        return false;

    }
}