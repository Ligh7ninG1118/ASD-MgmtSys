package DAO;

import model.Comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class CommentDAO
{
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    public boolean addComment(Comment cmt)
    {
        boolean flag= false;
        conn = DB.dbConn.getconn();
        String sql = "INSERT INTO COMMENT(AuthorID,Content,CommentDate,Choice,ArticleID) VALUES(?,?,?,?,?)";
        try
        {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,cmt.getAuthor().getID());
            pstmt.setString(2,cmt.getContent());
            pstmt.setDate(3,cmt.getCommentDate());
            pstmt.setBoolean(4,cmt.getChoice());
            pstmt.setInt(5,cmt.getArticle().getId());

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
            DB.dbClose.addClose(pstmt,conn);
        }
        return flag;
    }

}
