package DB;

import java.sql.*;

public class dbConn
{
    public static Connection getconn()
    {
        String driver = "com.hxtt.sql.access.AccessDriver";
        String url = "jdbc:Access:///testDB.mdb";

        Connection conn=null;
        try{
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url);
        }catch(Exception e){
            e.printStackTrace();
        }
        return conn;
    }

}
