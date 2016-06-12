package API_GHSC;

import java.sql.*;
import java.net.*;


public class DataAccess {


	private static Connection postgres = null;

    public DataAccess() {
        if( postgres == null )
        	postgres = this.getConnection();
    }


    private static Connection getConnection() {
    	
    	Connection c = null;
    	try
    	{
	    	String dbUrl = System.getenv("DATABASE_URL");
	    	c = DriverManager.getConnection(dbUrl);
    	}
    	catch( Exception e )
    	{ 
    		System.err.println("DatabaseConnection - Failed");
    		System.err.println(e.getMessage());
    		System.err.println(e.getStackTrace());
    	}

    	return c;

	}

    public static ResultSet ExecuteQuery(String sql, int Param)
    {

        PreparedStatement st = conn.prepareStatement(sql);
        st.setInt(1, Param);
        ResultSet rs = st.executeQuery();
        while (rs.next())
        {
           System.err.println("Column 1 returned ");
           System.err.println(rs.getString(1));
        }
        rs.close();
        st.close();

        return rs;

    }

}
