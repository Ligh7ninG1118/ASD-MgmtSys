package model;

import java.io.Serializable;
import java.sql.Date;

public class Comment implements Serializable
{
    private static final long serialVersionUID = 1;

    private int id;
    private User author;
    private String content;
    private Date commentdate;
    private boolean choice;

    public int getArticleid()
    {
        return articleid;
    }

    public void setArticleid(int articleid)
    {
        this.articleid = articleid;
    }

    private int articleid;

    public Article getArticle()
    {
        return article;
    }

    public void setArticle(Article article)
    {
        this.article = article;
    }

    private Article article;

    public int getID()
    {
        return id;
    }

    public void setID(int id)
    {
        this.id = id;
    }

    public User getAuthor()
    {
        return author;
    }

    public void setAuthor(User author)
    {
        this.author = author;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public Date getCommentDate()
    {
        return commentdate;
    }

    public void setCommentDate(Date commentdate)
    {
        this.commentdate = commentdate;
    }

    public boolean getChoice()
    {
        return choice;
    }

    public void setChoice(boolean choice)
    {
        this.choice = choice;
    }
}
