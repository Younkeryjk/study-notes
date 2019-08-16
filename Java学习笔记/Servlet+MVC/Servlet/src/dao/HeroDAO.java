package dao;

import bean.Hero;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HeroDAO {
    public HeroDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root", "root");
    }
    public int getTotal() {
        int total = 0;
        try (
                Connection c = getConnection();
                Statement s = c.createStatement();
        ) {
            String sql = "select count(*) from hero";
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
            }
            System.out.println("total:" + total);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }
    public List<Hero> list() {
        return list(0, Short.MAX_VALUE);
    }
    public List<Hero> list(int start, int count) {
        List<Hero> heros = new ArrayList<Hero>();

        String sql = "select * from hero order by id desc limit ?,? ";

        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setInt(1, start);
            ps.setInt(2, count);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Hero hero = new Hero();
                int id = rs.getInt(1);
                String name = rs.getString(2);
                float hp = rs.getFloat(3);
                hero.id = id;
                hero.name = name;
                hero.hp = hp;
                heros.add(hero);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return heros;
    }
    public void add(Hero hero) {
        String sql = "insert into hero values(null,?,?)";
        try (Connection connection = getConnection();PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setString(1, hero.name);
            preparedStatement.setFloat(2, hero.hp);
            preparedStatement.execute();
           /* ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            while (generatedKeys.next()) {
                int id = generatedKeys.getInt(1);
                hero.id = id;
            }*/
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try (Connection connection = getConnection();Statement statement = connection.createStatement();) {
            String sql = "delete from hero where id = " + id;
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Hero get(int id) {
        Hero hero = null;
        try (Connection connection = getConnection();Statement statement = connection.createStatement();) {
            String sql = "select * from hero where id = " + id;
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                hero = new Hero();
                String name = resultSet.getString("name");
                float hp = resultSet.getFloat("hp");
                hero.name = name;
                hero.hp = hp;
                hero.id = id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hero;
    }

    public void update(Hero hero) {
        String sql = "update hero set name= ?, hp= ? where id= ?";

        try (Connection connection = getConnection();PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setString(1, hero.name);
            preparedStatement.setFloat(2, hero.hp);
            preparedStatement.setInt(3, hero.id);

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
