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
    UserDAO test = new UserDAO();

    public boolean ifUserExists(String username)
    {
        User tu = test.searchUser(username);
        if (tu.getLoginID() != null)
            return true;
        else
            return false;
    }

    public boolean AuthInfoVerif(String un, String pw)
    {
        User tu = test.searchUser(un);

        if (tu.getLoginID() == null)
        {
            return false;
        }
        if (!tu.getPassword().equals(pw))
        {
            return false;
        }
        return true;
    }
}
