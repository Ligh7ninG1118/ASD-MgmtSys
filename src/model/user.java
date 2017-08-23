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
    private String tel;
    /*
      提案
      用户级别
      blabla
     */

    public int getID(){return id;}
    public void setID(int id){this.id = id;}

    public String getLoginID(){return loginID;}
    public void setLoginID(String loginID){this.loginID = loginID;}

    public String getPassword(){return password;}
    public void setPassword(String password){this.password = password;}

    public String getName(){return name;}
    public void setName(String name){this.name = name;}

    public String getSex(){return sex;}
    public void setSex(String sex){this.sex = sex;}

    public Date getBirthday(){return birthday;}
    public void setBirthday(Date birthday){this.birthday = birthday;}

    public String getAddress(){return address;}
    public void setAddress(String address){this.address = address;}

    public int getType(){return type;}
    public void setType(int type){this.type = type;}

    public String getTel(){return tel;}
    public void setTel(String tel){this.tel = tel;}
}
