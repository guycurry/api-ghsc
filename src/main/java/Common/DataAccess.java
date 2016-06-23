package API_GHSC;

import java.sql.*;
import java.net.*;
import java.util.*;


public class DataAccess {

    private static String connectionURL = null;
	private static Connection conn = null;
    private static String userName = null;
    private static String password = null;

    public DataAccess() {
        
    }


    private static Connection getConnection() {

        if( conn != null )
            return conn;        

        String[] params = DataAccess.GetConnectionString();

        Properties props = new Properties();
        props.setProperty("user",params[1]);
        props.setProperty("password",params[2]);
        props.setProperty("ssl","true");

    	Connection c = null;
    	try
    	{
            //Class.forName("org.postgresql.Driver");

	    	c = DriverManager.getConnection(System.getenv("DATABASE_URL"));
            //c = DriverManager.getConnection(params[0],props);
            //c = DriverManager.getConnection(params[0],params[1],params[2]);



    	}
        catch( SQLException e )
        {
            System.err.println("DatabaseConnection - Failed (SQLException)");
            System.err.println("Database URL");
            //System.err.println(params[0]);
            //System.err.println(params[1]);
            //System.err.println(params[2]);
            System.err.println(e.getMessage());
            System.err.println(e.getStackTrace());
            System.err.println(e.getSQLState());
            System.err.println(e.getLocalizedMessage());
        }
    	/*
        catch( ClassNotFoundException e )
    	{ 
    		System.err.println("DatabaseConnection - Failed (ClassNotFoundException)");
            System.err.println("Database URL");
            //System.err.println(params[0]);
            //System.err.println(params[1]);
            //System.err.println(params[2]);
    		System.err.println(e.getMessage());
    		System.err.println(e.getStackTrace());
            System.err.println(e.getLocalizedMessage());
            System.err.println(e.getCause());

    	}
        */

    	return c;

	}

    private static String[] GetConnectionString()
    {
        

        if( connectionURL == null )
            connectionURL = System.getenv("DATABASE_URL");

        if( connectionURL == null )
            connectionURL = "postgres://zrtyqvgdixrxvw:dho7HLp0KpTMFeNvsOafGFeAct@ec2-54-235-132-192.compute-1.amazonaws.com:5432/da5s7hb54a0q5d";


        
        String[] params = connectionURL.split(":");
        String URL = "jdbc:postgresql://"+params[2].split("@")[1]+":"+params[3];

        String UserName = params[1].substring(2,params[1].length());
        String Password = params[2].split("@")[0];
        
        System.err.println("DB_URL = "+ URL);
        System.err.println("UserName = "+ UserName);
        System.err.println("Password = "+ Password);

        return new String[] {URL, UserName, Password};

    }

    public static ResultSet ExecuteQuery(String sql, int Param) 
    {
        if( conn == null )
            conn = DataAccess.getConnection();
        if( conn == null )
            return null;

        ResultSet rs = null;
        try
        {

            Statement st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM mytable WHERE columnfoo = 500");
            //PreparedStatement st = conn.prepareStatement(sql);
            //st.setInt(1, Param);
            //rs = st.executeQuery();
            while (rs.next())
            {
               System.err.println("Column 1 returned ");
               System.err.println(rs.getString(1));
            }
            rs.close();
            st.close();
        }
        catch( SQLException e )
        {
            System.err.println("ExecuteQuery - Failed");
            System.err.println(e.getMessage());
            System.err.println(e.getStackTrace());
            System.err.println(e.getSQLState());
        }

        return rs;

    }

}
