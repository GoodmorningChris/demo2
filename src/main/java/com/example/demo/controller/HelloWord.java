package com.example.demo.controller;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
@RequestMapping("/hello")
@CrossOrigin
public class HelloWord {
    @GetMapping("/HelloWorld")
    public String helloWord(){
        System.out.println("成功了一小步！！！");
        try (Reader reader = Files.newBufferedReader(Paths.get("src/main/java/com/example/demo/asserts/organizational_diversity_active_domains_by_data_source_by_contributions.csv"));
             CSVReader csvReader = new CSVReader(reader)) {

            String[] record;
            while ((record = csvReader.readNext()) != null) {
                System.out.println("User["+ String.join(", ", record) +"]");
            }
        } catch (IOException | CsvValidationException ex) {
            ex.printStackTrace();
        }
        return "Hello World!！！！";
    }
}