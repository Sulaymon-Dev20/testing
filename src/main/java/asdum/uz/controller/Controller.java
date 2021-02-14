package asdum.uz.controller;

import asdum.uz.entity.first.Table;
import asdum.uz.entity.secoud.Stol;
import asdum.uz.repository.first.TableRepository;
import asdum.uz.repository.second.StolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/my")
public class Controller {

    @Autowired
    TableRepository tableRepository;

    @Autowired
    StolRepository stolRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;//faqat first database working!

    @GetMapping
    public void saveStol(@RequestParam String name) {
        try {
            stolRepository.save(new Stol(name));
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    @GetMapping("/api")
    public List<Stol> getAll() {
        return stolRepository.findAll();
    }

    @GetMapping("/test")
    public List<Map<String,Object>> gettest(@RequestBody String query) {
        return jdbcTemplate.queryForList(query);
    }

    @GetMapping("/api2")
    public List<Table> getTableAll() {
        return tableRepository.findAll();
    }

    @GetMapping("/boshqa")
    public List<Table> objects() {
        List<Stol> all = stolRepository.findAll();
        for (Stol stol : all) {
            if (stol != null) {
                tableRepository.save(new Table(stol.getName()));
            }
        }
        return tableRepository.findAll();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println(ManagementFactory.getRuntimeMXBean().getName().split("@")[0]);
        System.out.println(ManagementFactory.getRuntimeMXBean().getName());
    }
}