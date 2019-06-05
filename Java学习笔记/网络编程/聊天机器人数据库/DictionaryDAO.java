

package socket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import charactor.Hero;

public class DictionaryDAO {

public DictionaryDAO() {
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/android?characterEncoding=UTF-8", "root",
				"root");
	}

	public List<Dictionary> query(String recieve) {
		List<Dictionary> ds = new ArrayList<Dictionary>();

		String sql = "select * from dictionary where receive = ? ";

		try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			ps.setString(1, recieve);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Dictionary d = new Dictionary();
				int id = rs.getInt(1);
				String receive = rs.getString("receive");
				String response = rs.getString("response");
				d.id=id;
				d.receive=receive;
				d.response=response;
				ds.add(d);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return ds;
	}

}