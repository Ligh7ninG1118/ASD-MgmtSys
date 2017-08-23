package model;

import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable
{
    private static final long serialVersionUID = 1;

    private int id;
    private User author;
    private String content;
    private Date commentdate;
    private boolean choice;

    public int getID(){return id;}
    public void setID(int id){this.id = id;}

    public User getAuthor(){return author;}
    public void setAuthor(User author){this.author = author;}

    public String getContent(){return content;}
    public void setContent(String content){this.content = content;}

    public Date getCommentDate(){return commentdate;}
    public void setCommentDate(Date commentdate){this.commentdate = commentdate;}

    public boolean getChoice(){return choice;}
    public void setChoice(boolean choice){this.choice = choice;}
}
