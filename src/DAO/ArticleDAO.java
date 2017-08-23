package DAO;

import model.Article;
import model.Comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public final class ArticleDAO
{
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    UserDAO udao = new UserDAO();

    public boolean addArticle(Article article)
    {
        boolean flag = false;
        conn = DB.dbConn.getconn();
        String sql = "INSERT INTO ARTICLE(AuthorID,Title,Content,SubmitDate,DeadlineDate,Status,Yay,Nay,ArticleType,CommentIDs) VALUES(?,?,?,?,?,?,?,?,?,?)";
        try
        {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, article.getAuthor().getId());
            pstmt.setString(2, article.getTitle());
            pstmt.setString(3, article.getContent());
            pstmt.setDate(4, article.getSubmiteDate());
            pstmt.setDate(5, article.getDeadlineDate());
            pstmt.setBoolean(6, article.isStatus());
            pstmt.setInt(7, article.getYay());
            pstmt.setInt(8, article.getNay());
            pstmt.setInt(9, article.getArticleType());
            pstmt.setString(10, article.getCommentids());

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
            DB.dbClose.addClose(pstmt, conn);
        }
        return flag;
    }

    public ArrayList<Article> queryArticles(String key, int mode)
    {
        ArrayList<Article> articlesList = new ArrayList<Article>();
        conn = DB.dbConn.getconn();
        String sql = null;
        int authid = udao.searchUserByName(key).getId();
        switch (mode)
        {
            case 1:
                if(key.matches("[0-9]+"))
                     sql = "SELECT  * FROM Article WHERE AuthorID = "+authid+" OR Title LIKE '%" + key + "%' OR ID = "+ Integer.parseInt(key)+"";
                else
                    sql = "SELECT  * FROM Article WHERE AuthorID = "+authid+" OR Title LIKE '%" + key + "%'";
                break;
            case 2:
                sql = "SELECT * FROM Article WHERE AuthorID = " + authid;
                break;
            case 3:
                sql = "SELECT * FROM Article WHERE Title LIKE '%" + key + "%'";
                break;
            case 4:
                sql = "SELECT * FROM Article WHERE ID = "+ Integer.parseInt(key);
                break;
        }
        try
        {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next())
            {
                Article temp = new Article();
                temp.setId(rs.getInt(1));
                temp.setAuthorname(udao.searchUserById(rs.getInt(2)).getLoginID());
                temp.setTitle(rs.getString(3));
                temp.setDeadlineDate(rs.getDate(6));
                temp.setStatus(rs.getBoolean(7));
                temp.setYay(rs.getInt(8));
                temp.setNay(rs.getInt(9));
                articlesList.add(temp);
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            DB.dbClose.queryClose(pstmt, rs, conn);
        }
        return articlesList;
    }

}
