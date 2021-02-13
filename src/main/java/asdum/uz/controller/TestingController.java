package asdum.uz.controller;

import asdum.uz.service.TestingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/testing")
public class TestingController {

    @Autowired
    TestingService testingService;

    @GetMapping
    public HttpEntity<?> pesisatka() {
        try {

        } catch (Exception e) {

        }
        return null;
    }
}
