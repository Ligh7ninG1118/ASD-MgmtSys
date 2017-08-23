package model;

import java.io.Serializable;
import java.sql.Date;

public final class User implements Serializable
{

    private static final long serialVersionUID = 1;
    /***
     *  Account stuff
     */

    private int id;
    private String loginID;
    private String password;

    /***
     *  Personal Info
     */
    private String name;
    private String sex;
    private Date birthday;
    private String address;
    private int type;
    private String comm;
    private String recommender;
    private String commit;
    private String subcommit;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getLoginID()
    {
        return loginID;
    }

    public void setLoginID(String loginID)
    {
        this.loginID = loginID;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public Date getBirthday()
    {
        return birthday;
    }

    public void setBirthday(Date birthday)
    {
        this.birthday = birthday;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public int getType()
    {
        return type;
    }

    public void setType(int type)
    {
        this.type = type;
    }

    public String getComm()
    {
        return comm;
    }

    public void setComm(String comm)
    {
        this.comm = comm;
    }

    public String getRecommender()
    {
        return recommender;
    }

    public void setRecommender(String recommender)
    {
        this.recommender = recommender;
    }

    public String getCommit()
    {
        return commit;
    }

    public void setCommit(String commit)
    {
        this.commit = commit;
    }

    public String getSubcommit()
    {
        return subcommit;
    }

    public void setSubcommit(String subcommit)
    {
        this.subcommit = subcommit;
    }



}
