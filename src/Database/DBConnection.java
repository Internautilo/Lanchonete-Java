package Database;

import java.sql.Connection;

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
	}
	
	public DBConnection() {
		this.host = "localhost";
		this.port = "3306";
		this.schema = "lanchonete";
		this.name = "root";
		this.password = "";
	}
}
