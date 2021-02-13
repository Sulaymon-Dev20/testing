package asdum.uz.controller;

import asdum.uz.entity.first.Table;
import asdum.uz.entity.secoud.Stol;
import asdum.uz.repositroy.first.TableRepository;
import asdum.uz.repositroy.secoud.StolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Map<String,Object>> gettest(@RequestParam String table) {
        return jdbcTemplate.queryForList("select * from "+table+"");
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
}
