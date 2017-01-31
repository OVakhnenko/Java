package mysql;

import java.sql.*;

public class JDBCStatementCreateExample {

    private static final String DB_DRIVER = "com.mysql.jdbc.Driver"; //"oracle.jdbc.driver.OracleDriver";
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/departments";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "oJ0K58fE29kZhgXcQQV7";

    public static void main(String[] argv) {

        try {
            createDbUserTable();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void createDbUserTable() throws SQLException {

        Connection dbConnection = null;
        Statement statement = null;

        String showTableSQL = "SHOW TABLES FROM TEST";
        String dropTableSQL = "DROP TABLE TEST";
        String createTableSQL = "CREATE TABLE IF NOT EXISTS TEST ("
                + "id int(11) NOT NULL, "
                + "name varchar(50) NOT NULL, "
                + "author varchar(50) NOT NULL, "
                + "PRIMARY KEY (id) "
                + ")ENGINE = InnoDB";
        String insertDataToTable1 = "INSERT INTO TEST "
                + "(id, name, author) VALUES (1, 'Effective Java', 'Joshua Bloch')";
        String insertDataToTable2 = "INSERT INTO TEST "
                + "(id, name, author) VALUES (2, 'Java Concurrency in Practice', 'Brian Goetz')";
        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            System.out.println(dropTableSQL);
            statement.execute(dropTableSQL);

            System.out.println(createTableSQL);
            statement.execute(createTableSQL);

            System.out.println(insertDataToTable1);
            statement.execute(insertDataToTable1);
            System.out.println(insertDataToTable2);
            statement.execute(insertDataToTable2);

            System.out.println("Table \"TEST\" is created!");

            String query = "select name from test where name='Effective Java'";

            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                //int id = rs.getInt(1);
                String name = rs.getString(1);
                System.out.println("name: " + name);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }

    private static Connection getDBConnection() {

        Connection dbConnection = null;

        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            dbConnection = DriverManager.getConnection(
                    DB_CONNECTION, DB_USER, DB_PASSWORD);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return dbConnection;
    }
}