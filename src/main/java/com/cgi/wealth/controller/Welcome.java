package com.cgi.wealth.controller;

import com.cgi.wealth.component.AutoTest;
import com.cgi.wealth.component.QualificationExercise;
import com.cgi.wealth.lib.multithreading.entity.AppUser;
import com.cgi.wealth.service.AppUserService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@Slf4j
public class Welcome {

    @Autowired
    AppUserService appUserService;

    @Autowired
    QualificationExercise qualificationExercise;

    @Autowired
    AutoTest autoTest;

    @GetMapping("/")
    public ResponseEntity<String> welcome(){
        AppUser appUser = appUserService.addUser("Venkata", "Chintalapati");
        qualificationExercise.printQualification();
        return ResponseEntity.ok("Welcome to spring functionalities demo");
    }

    @GetMapping("/auto")
    public ResponseEntity<String> autoTest(){
        log.info("Auto test");
        autoTest.getByNameTest().doTest();
        autoTest.getTypeTest().doTest();
        return ResponseEntity.ok("Welcome to spring functionalities demo");
    }

    @SneakyThrows(IOException.class)
    @GetMapping("/errorPage")
    public ResponseEntity<String> errorPage() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmmss");
        String now = LocalDateTime.now().format(formatter);
        String fileName = now+".txt";
        byte[] dummy = "dummy".getBytes();
        try(FileOutputStream fos = new FileOutputStream(fileName)){
            fos.write(dummy);
        }
        return ResponseEntity.ok(
                String.format("Errors are logged in the file %s",now));
    }

    @GetMapping("/scannerPage")
    public ResponseEntity<String> scannerPage() throws Exception {
        String now = getStrDate();

        try (AutoCloseableResourcesFirst af = new AutoCloseableResourcesFirst()){
            af.doSomething();
        }
        return ResponseEntity.ok(
                String.format("Errors are logged in the file %s",now));
    }

    private String getStrDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmmss");
        return LocalDateTime.now().format(formatter);
    }
}
