package fr.groupe5.compte_bancaire.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

	
	private static DataBaseConnection instance;
    private Connection connection;
    private String url = "jdbc:mysql://localhost:3306/compte_bancaire?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private String username = "root";
    private String password = "root";

    
    public Connection getConnection() {
    	return connection;
    }
    
    // connection à la database singleton: 
    
    public static DataBaseConnection getInstance() throws SQLException {
    	
    	if(instance == null) {
    		instance = new DataBaseConnection();
    	}else if(instance.getConnection().isClosed()) {
    		instance = new DataBaseConnection();
    	}
    	
    	return instance;
    	
    } 
    
    /**
     * 
     * @return
     * @throws SQLException
     */
    
	 public DataBaseConnection() throws SQLException {
	    	
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 this.connection = DriverManager.getConnection(url, username, password);
			 
			
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("Erreur création database " + e.getMessage());
		}  	
    } 
}
