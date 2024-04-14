package main;

import java.sql.Connection;

import Database.DBConnection;

public class main {

	public static void main(String[] args) {
		
		DBConnection dbconn = new DBConnection();
		Connection conn = dbconn.getConnection();
	}

}
