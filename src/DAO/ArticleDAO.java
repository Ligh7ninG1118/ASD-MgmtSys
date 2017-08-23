package DAO;

import model.Article;
import model.Comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class ArticleDAO
{
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    public boolean addArticle(Article article)
    {
        boolean flag= false;
        conn = DB.dbConn.getconn();
        String sql = "INSERT INTO ARTICLE(AuthorID,Title,Content,SubmitDate,DeadlineDate,Status,Yay,Nay,ArticleType,CommentIDs) VALUES(?,?,?,?,?,?,?,?,?,?)";
        try
        {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,article.getAuthor().getId());
            pstmt.setString(2,article.getTitle());
            pstmt.setString(3,article.getContent());
            pstmt.setDate(4,article.getSubmiteDate());
            pstmt.setDate(5,article.getDeadlineDate());
            pstmt.setBoolean(6,article.isStatus());
            pstmt.setInt(7,article.getYay());
            pstmt.setInt(8,article.getNay());
            pstmt.setInt(9,article.getArticleType());
            pstmt.setString(10,article.getCommentids());

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
