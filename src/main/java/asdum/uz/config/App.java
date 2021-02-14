package asdum.uz.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
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

    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection("jdbc:postgresql://db-postgresql-nyc3-via-do-user-117293-0.a.db.ondigitalocean.com:25060/asdum?sslmode=require", "doadmin", "d91iknqapy867fje");
            c.setAutoCommit(false);
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("select s.id, p.id as pid,  s.name sn, p.distance d, p.marshrut_id mid, p.lat, p.lng from stations s left join points p on p.station_id=s.id where s.id>0 and length(s.name)>0 and s.deleted=false and p.distance>=0 and p.marshrut_id = (select id from marshrut where id=550 and  viamobile=true) order by length(s.name), name, p.distance;");
            List<Map<String, Object>> maps = new ArrayList<>();
            while (rs.next()) {
                Map<String, Object> map = new HashMap<>();
                map.put("id", rs.getLong("id"));
                map.put("table_name", rs.getLong("pid"));
                map.put("sn", rs.getString("sn"));
                map.put("d", rs.getDouble("d"));
                map.put("mid", rs.getDouble("mid"));
                map.put("lat", rs.getDouble("lat"));
                map.put("lng", rs.getDouble("lng"));
                maps.add(map);
            }
            System.out.println(maps);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }
}
