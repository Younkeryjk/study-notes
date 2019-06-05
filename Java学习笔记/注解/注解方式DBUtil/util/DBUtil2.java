package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import anno.JDBCConfig;

/**
 * @author Younker
 *
 * 2019年6月3日
 * 
 * 注解方式DBUtil
 */
@JDBCConfig(ip = "127.0.0.1", database = "test", encoding = "UTF-8", loginName = "root", password = "root")
public class DBUtil2 {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		JDBCConfig config = DBUtil2.class.getAnnotation(JDBCConfig.class);
		String ip = config.ip();
		int port = config.port();
		String database = config.database();
		String encoding = config.encoding();
		String loginName = config.loginName();
		String password = config.password();
		String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s", ip, port, database, encoding);
		return DriverManager.getConnection(url, loginName, password);
	}

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, SQLException {
		Connection c = getConnection();
		System.out.println(c);
	}
}
