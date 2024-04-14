package Database;

import java.sql.*;

public class DBConnection {
	
	private String host 	= 	"";
	private String port	 	=	"";
	private String schema	= 	"";
	private String name 	=	"";
	private String password = 	"";
	
	private Connection connection = null;
	
	public DBConnection(String host, String port, String schema, String name, String password) {
		this.host = host;
		this.port = port;
		this.schema = schema;
		this.name = name;
		this.password = password;
		
		this.connect();
	}
	
	public DBConnection() {
		this.host = "localhost";
		this.port = "3306";
		this.schema = "lanchonete";
		this.name = "root";
		this.password = "";
		
		this.connect();
	}
	
	public Connection getConnection() {
		return this.connection;
	}
	
	private void connect() {
		try {
			String timezone = "?useTimezone=true&serverTimezone=UTC";
			String url = "jdbc:mysql://" + this.host + ":" + this.port + "/" + this.schema + timezone;
			this.connection = DriverManager.getConnection(url, this.name, this.password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
