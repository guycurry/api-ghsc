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

}
