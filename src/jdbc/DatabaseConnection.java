package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	/* DB 접속 객체
	 * DB Driver, url, user, password
	 * Driver : com.mysql.cj.jdbc.Driver
	 * url : jdbc:mysql://localhost:3306/DB명
	 *
	 */
	
	private static DatabaseConnection dbc = new DatabaseConnection();
	private Connection conn = null;
	
	private String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	private String jdbcUrl = "jdbc:mysql://localhost:3306/javadb";
	
	//생성자
	private DatabaseConnection() {
		try {
			//드라이버를 로드하기 위한 메서드
			Class.forName(jdbcDriver);
			//연결을 위해서 url, user, password 필요함
			conn = DriverManager.getConnection(jdbcUrl, "javaUser", "mysql");
		} catch (ClassNotFoundException e) {
			// 해당 드라이버를 찾을 수 없을 때
			System.out.println("드라이버를 찾을 수 없습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			// conn 연결 정보가 잘못되었을 경우
			System.out.println("연결정보가 정확하지 않습니다.");
			e.printStackTrace();
		}
		
		
		
	}
	public static DatabaseConnection getInstance() {
		return dbc;
	}
	
	public Connection getConnection() {
		return conn;
	}
}
