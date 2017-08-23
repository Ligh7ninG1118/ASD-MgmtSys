package Controller;

import DAO.UserDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.User;
import Util.*;

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

    boolean isFilled[];
    UserVerif uv = new UserVerif();
    UserDAO udao = new UserDAO();
    @FXML
    public void registerAction(ActionEvent e)
    {
        if (ifInvaildInput())
           return;

        isFilled = new boolean[2];
        if (addressTextField.getText().equals(""))
            isFilled[0] = false;
        else
            isFilled[0] = true;
        if (recommTextField.getText().equals(""))
            isFilled[1] = false;
        else
            isFilled[1] = true;
        alertmessageLabel.setText("");
        String ipusername = usernameTextField.getText().trim();
        String ippassword = passwordTextField.getText();

        String ipname = nameTextField.getText().trim();
        String ipsex = sexCBox.getValue().toString();
        String ipcomm = commTextField.getText().trim();
        String ipsubcommit = subcommitCBox.getValue().toString();
        String ipcommit = commitCBox.getValue().toString();
        String iprecommender = recommTextField.getText().trim();
        String ipaddress = "";
        String ipbirthday ="";

        if (isFilled[0])
        {
            ipaddress = addressTextField.getText().trim().trim();
        }

        if (isFilled[1])
        {
             ipbirthday = birthdayDatePicker.getValue().toString();
        }


        if (uv.ifUserExists(ipusername))
        {
            alertmessageLabel.setText("用户已存在");
            return;
        }
        else
        {
            User user = new User();
            user.setLoginID(ipusername);
            user.setPassword(ippassword);
            user.setName(ipname);
            user.setSex(ipsex);
            user.setType(0);
            user.setComm(ipcomm);
            user.setSubcommit(ipsubcommit);
            user.setCommit(ipcommit);
            user.setAddress(ipaddress);
            user.setRecommender(iprecommender);
            //user.setBirthday(ipbirthday);


            boolean bool = udao.addUser(user);
            if (bool)
                alertmessageLabel.setText("注册信息提交");
        }
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
        if (usernameTextField.getText().length() > 24)
        {
            alertmessageLabel.setText("用户名过长");
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
        if (nameTextField.getText().length() > 24)
        {
            alertmessageLabel.setText("姓名过长");
            return true;
        }
        if (commTextField.getText().equals(""))
        {
            alertmessageLabel.setText("联系方式不能为空");
            return true;
        }
        if (commTextField.getText().length() > 24)
        {
            alertmessageLabel.setText("联系方式过长");
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
        if (birthdayDatePicker.getValue().toString().compareTo(LocalDate.now().toString()) > 0 ||
                LocalDate.now().getYear() - birthdayDatePicker.getValue().getYear() >= 100)
        {
            alertmessageLabel.setText("生日选择错误");
            return true;
        }
        if (passwordTextField.getText().length() < 6 || passwordTextField.getText().length() > 18 || !passwordTextField.getText().matches("[0-9a-zA-Z]+"))
        {
            alertmessageLabel.setText("密码不符规定");
            return true;
        }
        if (!commTextField.getText().matches("[0-9]+"))
        {
            alertmessageLabel.setText("联系方式不符规定");
            return true;
        }
        return false;

    }
}