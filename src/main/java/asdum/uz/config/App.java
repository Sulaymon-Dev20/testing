/*todo kerak
package asdum.uz.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class App {
    @Value("${app.datasource.second.url}")
    private static String url;
    @Value("${app.datasource.second.password}")
    private static String password;
    @Value("${app.datasource.second.username}}")
    private static String user;

    */
/*    public static void main(String[] args) {
            Connection c;
            Statement stmt;
            try {
                Class.forName("org.postgresql.Driver");
                c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/myschool", "postgres", "1234");
                c.setAutoCommit(false);

                stmt = c.createStatement();
                stmt.executeUpdate("");
                c.commit();

                ResultSet rs = stmt.executeQuery("SELECT * FROM buglist;");
                while (rs.next()) {
                    System.out.println("ID = " + rs.getLong("id"));
                    System.out.println("NAME = " + rs.getString("table_name"));
                    System.out.println("ADDRESS = " + rs.getString("classname"));
                    System.out.println();
                }
                rs.close();
                stmt.close();
                c.close();
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
            System.out.println("Operation done successfully");
        }*//*

    public static void main(String[] args) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/myschool", "postgres", "1234");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM buglist;");
            Map<String, Object> map = new HashMap<>();
            while (rs.next()) {
                map.put("id", rs.getLong("id"));
                System.out.println("ID = " + rs.getLong("id"));
                System.out.println("NAME = " + rs.getString("table_name"));
                System.out.println("ADDRESS = " + rs.getString("classname"));
                System.out.println();
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }
}
*/
