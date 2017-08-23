package DAO;

import model.User;
import DB.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class UserDAO
{
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    public boolean addUser(User user)
    {
        boolean flag= false;
        conn = DB.dbConn.getconn();
        String sql = "INSERT INTO USER(LoginID,Password,AccountType) VALUES(?,?,?)";
        try
        {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,user.getLoginID());
            pstmt.setString(2,user.getPassword());
            pstmt.setInt(3,user.getType());

            int rs = pstmt.executeUpdate();
            if (rs > 0)
            {
                flag = true;
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }finally
        {
            dbClose.addClose(pstmt,conn);
        }
        return flag;
    }

    public static void updateUser(User user)
    {

    }

    public static void searchUser(User user)
    {

    }
}
