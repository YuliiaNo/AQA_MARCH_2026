package org.prog.session12;

import java.sql.*;

public class DBHelper {

    private Connection connection;

    public DBHelper() throws SQLException {

        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db",
                "root",
                "password"
        );

        createTable();
    }

    private void createTable() throws SQLException {

        Statement statement = connection.createStatement();

        statement.execute(
                "CREATE TABLE IF NOT EXISTS allo_ua_goods (" +
                        "id INT AUTO_INCREMENT PRIMARY KEY," +
                        "product_code VARCHAR(255)," +
                        "product_name VARCHAR(500)" +
                        ")"
        );
    }

    public boolean exists(String code, String name)
            throws SQLException {

        PreparedStatement preparedStatement =
                connection.prepareStatement(
                        "SELECT COUNT(*) FROM allo_ua_goods " +
                                "WHERE product_code=? AND product_name=?"
                );

        preparedStatement.setString(1, code);
        preparedStatement.setString(2, name);

        ResultSet resultSet =
                preparedStatement.executeQuery();

        if (resultSet.next()) {
            return resultSet.getInt(1) > 0;
        }

        return false;
    }

    public void insert(String code, String name)
            throws SQLException {

        PreparedStatement preparedStatement =
                connection.prepareStatement(
                        "INSERT INTO allo_ua_goods " +
                                "(product_code, product_name) " +
                                "VALUES (?, ?)"
                );

        preparedStatement.setString(1, code);
        preparedStatement.setString(2, name);

        preparedStatement.execute();

        System.out.println("Inserted into DB");
    }

    public void close() throws SQLException {
        connection.close();
    }
}