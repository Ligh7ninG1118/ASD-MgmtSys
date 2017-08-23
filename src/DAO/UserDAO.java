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
        boolean flag = false;
        conn = DB.dbConn.getconn();
        String sql = "INSERT INTO USER(LoginID,Password,RealName,AccountType,Sex,Communication,Address,Recommender) VALUES(?,?,?,?,?,?,?,?)";
        try
        {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getLoginID());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3,user.getName());
            pstmt.setInt(4,user.getType());
            pstmt.setString(5,user.getSex());
            pstmt.setString(6,user.getComm());
            pstmt.setString(7,user.getAddress());
            pstmt.setString(8,user.getRecommender());
            int rs = pstmt.executeUpdate();
            if (rs > 0)
            {
                flag = true;
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            dbClose.addClose(pstmt, conn);
        }
        return flag;
    }

    public static void updateUser(User user)
    {

    }

    public User searchUser(String username)
    {
        User user = new User();
        conn = DB.dbConn.getconn();
        String sname = null;
        String sPassWord = null;

        String sql = "SELECT * FROM USER WHERE LoginID = ?";
        try
        {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();
            if (rs.next())
            {
                sname = rs.getString(2);
                sPassWord = rs.getString(3);
            }

            user.setLoginID(sname);
            user.setPassword(sPassWord);

        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            DB.dbClose.queryClose(pstmt, rs, conn);
        }
        return user;
    }
}
