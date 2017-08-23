package Util;

import DAO.UserDAO;
import DB.dbClose;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Logger
{
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    UserDAO udao = new UserDAO();

    public void addUserInfo(int userid)
    {
        conn = DB.dbConn.getconn();
        String sql = "INSERT INTO LOG(UserID) VALUES(?)";
        try
        {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userid);
            pstmt.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            dbClose.addClose(pstmt, conn);
        }

    }

    public User requireUserInfo()
    {
        int id=-1;
        conn = DB.dbConn.getconn();
        String sql = "SELECT * FROM LOG";
        try
        {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next())
            {
                id = rs.getInt(2);
            }

        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            DB.dbClose.queryClose(pstmt, rs, conn);
        }
        return udao.searchUserById(id);
    }
}
