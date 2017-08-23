package Util;

import DAO.UserDAO;
import model.User;

public class UserVerif
{
    UserDAO test = new UserDAO();
    private User tu=null;
    public boolean ifUserExists(String username)
    {
        tu = test.searchUserByName(username);
        if (tu.getLoginID() != null)
            return true;
        else
            return false;
    }

    public boolean AuthInfoVerif(String un, String pw)
    {
        tu = test.searchUserByName(un);

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

    public int getUserId(String username)
    {
        tu = test.searchUserByName(username);
        return tu.getId();
    }
}
