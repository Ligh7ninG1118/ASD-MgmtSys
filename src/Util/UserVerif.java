package Util;

import DAO.UserDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.User;

import javax.xml.soap.Text;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

public class UserVerif
{
    public boolean ifUserExists(String username)
    {
        UserDAO test = new UserDAO();
        User tu = test.searchUser(username);
        if(tu.getLoginID()!=null)
            return true;
        else
            return false;
    }
}
