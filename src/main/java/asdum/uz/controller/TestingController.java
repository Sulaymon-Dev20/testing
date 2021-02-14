package asdum.uz.controller;

import asdum.uz.entity.third.BugList;
import asdum.uz.repository.third.BugListRepository;
import asdum.uz.service.TestingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;

@RestController
@RequestMapping("/api/testing")
public class TestingController {

    @Autowired
    TestingService testingService;

    @Autowired
    BugListRepository bugListRepository;

    @GetMapping
    public HttpEntity<?> pesisatka(@RequestParam Long aPoint, @RequestParam Long bPoint) {
        try {
            String ipAddress = InetAddress.getLocalHost().getHostAddress();
            System.out.println(ipAddress);
            return ResponseEntity.ok(testingService.exchange(aPoint, bPoint));
        } catch (Exception e) {
            bugListRepository.save(new BugList(null, "Stations", "TestingController", "pesisatka", "tabni sahranit qila olmaslik ehtimoli mavjud"));
            return ResponseEntity.ok("Error");
        }
    }

    @GetMapping("/Setup")
    public HttpEntity<?> setUp() {
        try {
            return ResponseEntity.ok(testingService.setUp());
        } catch (Exception e) {
            bugListRepository.save(new BugList(null, "Stations", "TestingController", "setUp", null));
            return ResponseEntity.ok("Error");
        }
    }
}
