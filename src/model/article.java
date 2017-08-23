package model;

import java.sql.Date;

public class Article
{
    private static final long serialVersionUID = 1;


    private int id;
    private User author;
    private String title;
    private String content;
    private Date submiteDate;
    private Date deadlineDate;
    private boolean status;
    private int yay;
    private int nay;
    private int articleType;
    private String commentids;

    public String getAuthorname()
    {
        return authorname;
    }

    public void setAuthorname(String authorname)
    {
        this.authorname = authorname;
    }

    private String authorname;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
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

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public Date getSubmiteDate()
    {
        return submiteDate;
    }

    public void setSubmiteDate(Date submiteDate)
    {
        this.submiteDate = submiteDate;
    }

    public Date getDeadlineDate()
    {
        return deadlineDate;
    }

    public void setDeadlineDate(Date deadlineDate)
    {
        this.deadlineDate = deadlineDate;
    }

    public boolean isStatus()
    {
        return status;
    }

    public void setStatus(boolean status)
    {
        this.status = status;
    }

    public int getYay()
    {
        return yay;
    }

    public void setYay(int yay)
    {
        this.yay = yay;
    }

    public int getNay()
    {
        return nay;
    }

    public void setNay(int nay)
    {
        this.nay = nay;
    }

    public int getArticleType()
    {
        return articleType;
    }

    public void setArticleType(int articleType)
    {
        this.articleType = articleType;
    }

    public String getCommentids()
    {
        return commentids;
    }

    public void setCommentids(String commentids)
    {
        this.commentids = commentids;
    }




}
