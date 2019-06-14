package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Hero;

public class HeroDAO {

	public void add(Hero hero) {

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
					"root", "root");

			String sql = "insert into hero values(null,?,?,?)";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, hero.name);
			ps.setFloat(2, hero.hp);
			ps.setInt(3, hero.damage);

			ps.execute();

			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				int id = rs.getInt(1);
				hero.id = id;
			}

			ps.close();

			c.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update(Hero hero) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
					"root", "root");

			String sql = "update hero set name= ?, hp = ? , damage = ? where id = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, hero.name);
			ps.setFloat(2, hero.hp);
			ps.setInt(3, hero.damage);
			ps.setInt(4, hero.id);

			ps.execute();

			ps.close();

			c.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void delete(int id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
					"root", "root");

			Statement s = c.createStatement();

			String sql = "delete from hero where id = " + id;

			s.execute(sql);

			s.close();

			c.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Hero get(int id) {
		Hero hero = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
					"root", "root");

			Statement s = c.createStatement();

			String sql = "select * from hero where id = " + id;

			ResultSet rs = s.executeQuery(sql);

			if (rs.next()) {
				hero = new Hero();
				String name = rs.getString(2);
				float hp = rs.getFloat("hp");
				int damage = rs.getInt(4);
				hero.name = name;
				hero.hp = hp;
				hero.damage = damage;
				hero.id = id;
			}

			s.close();

			c.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hero;
	}

	public List<Hero> list() {
		return list(0, Short.MAX_VALUE);
	}

	public List<Hero> list(int start, int count) {
		List<Hero> heros = new ArrayList<Hero>();

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
					"root", "root");

			String sql = "select * from hero order by id desc limit ?,? ";

			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, count);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Hero hero = new Hero();
				int id = rs.getInt(1);
				String name = rs.getString(2);
				float hp = rs.getFloat("hp");
				int damage = rs.getInt(4);
				hero.id = id;
				hero.name = name;
				hero.hp = hp;
				hero.damage = damage;
				heros.add(hero);
			}

			ps.close();

			c.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return heros;
	}
	
	

}