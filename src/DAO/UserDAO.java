package DAO;

import model.User;
import DB.*;
import sun.security.util.Password;


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
            pstmt.setString(3, user.getName());
            pstmt.setInt(4, user.getType());
            pstmt.setString(5, user.getSex());
            pstmt.setString(6, user.getComm());
            pstmt.setString(7, user.getAddress());
            pstmt.setString(8, user.getRecommender());
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

    public void updateUser(User user)
    {
        conn = DB.dbConn.getconn();
        String sql = "UPDATE User set Sex = '"+user.getSex()+"' WHERE ID = "+user.getId()+"";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally
        {
            DB.dbClose.queryClose(pstmt, rs, conn);
        }
    }

    public User searchUserByName(String username)
    {
        User user = new User();
        conn = DB.dbConn.getconn();
        String sname = null;
        String sPassWord = null;
        int sId = -1;
        int sType=-1;
        String sql = "SELECT * FROM USER WHERE LoginID = ?";
        try
        {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();
            if (rs.next())
            {
                sId = rs.getInt(1);
                sname = rs.getString(2);
                sPassWord = rs.getString(3);
                sType =rs.getInt(5);
            }
            user.setId(sId);
            user.setLoginID(sname);
            user.setPassword(sPassWord);
            user.setType(sType);
        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            DB.dbClose.queryClose(pstmt, rs, conn);
        }
        return user;
    }

    public User searchUserById(int id)
    {
        User user = new User();
        conn = DB.dbConn.getconn();
        String sql = "SELECT * FROM USER WHERE ID = ?";
        try
        {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            while (rs.next())
            {
                user.setId(rs.getInt(1));
                user.setLoginID(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setName(rs.getString(4));
                user.setBirthday(rs.getDate(6));
                user.setSex(rs.getString(7));
                user.setComm(rs.getString(8));
                user.setAddress(rs.getString(9));
                user.setCommit(rs.getString(10));
                user.setSubcommit(rs.getString(11));
            }
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
