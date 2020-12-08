package main;

import java.sql.*;

public class JDBCPractice {
    public static void main(String[] args) {
        try {
            //loading drivers
            Class.forName("com.mysql.cj.jdbc.Driver");
            //INSERT
            int rows = insertData(12,"Vaibhav", "vai@gmail.com", 5.73);
            System.out.println("INSERT Query performed..");
            System.out.println("No. of rows affected = " + rows);
            //UPDATE
            rows = updateData(8.91, 12);
            System.out.println("UPDATE Query performed..");
            System.out.println("No. of rows affected = " + rows);
            //DELETE
            rows = deleteData(9.9);
            System.out.println("DELETE Query performed..");
            System.out.println("No. of rows affected = " + rows);
            //SELECT
            ResultSet resultSet = selectData();
            System.out.println("SELECT Query performed..");
            if(resultSet != null) {
                while(resultSet.next()){
                    int rollno = resultSet.getInt("rollno");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    double cpi = resultSet.getDouble("cpi");
                    System.out.println(rollno + "\t" + name + "\t" + email + "\t" + cpi );
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //method for creating connection
    public static Connection getDbConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/gla";
        String user = "root";
        String pass = "";
        Connection connection = DriverManager.getConnection(url, user, pass);
        return connection;
    }

    //method for inserting data
    public static int insertData(int rollno, String name, String email, double cpi) throws SQLException {
        Connection connection = getDbConnection();
        String sql = "INSERT INTO student (rollno, name, email, cpi) VALUES (?, ?, ?, ?);";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,rollno);
        statement.setString(2,name);
        statement.setString(3,email);
        statement.setDouble(4,cpi);
        int rows = statement.executeUpdate();
        return rows;
    }

    //method for updating data on basis of rollno
    public static int updateData(double cpi, int rollno) throws SQLException {
        Connection connection = getDbConnection();
        String sql = "UPDATE student SET cpi=? WHERE rollno=?;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setDouble(1,cpi);
        statement.setInt(2,rollno);
        int rows = statement.executeUpdate();
        return rows;
    }

    //method for deleting data on basis of cpi
    public static int deleteData(double cpi) throws SQLException {
        Connection connection = getDbConnection();
        String sql = "DELETE FROM student WHERE cpi=?;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setDouble(1,cpi);
        int rows = statement.executeUpdate();
        return rows;
    }

    //method for selecting data
    public static ResultSet selectData() throws SQLException {
        Connection connection = getDbConnection();
        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM student;";
        ResultSet resultSet = statement.executeQuery(sql);
        return resultSet;
    }
}
