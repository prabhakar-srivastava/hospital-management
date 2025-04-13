package hospital;

import java.sql.*;

public class ConnectionClass {
  Connection con = null;
  Statement st = null;

  ConnectionClass() {
    try {
      // Load the JDBC driver
      Class.forName("com.mysql.cj.jdbc.Driver");
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java ", "root", "root");
      st = con.createStatement();
      if (con.isClosed()) {
        System.out.println("Connection is null");
      } else {
        System.out.println("Connection is successful");

      }

    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
    }
  }
  public static void main(String[] args) {
     new ConnectionClass();
  }
}
