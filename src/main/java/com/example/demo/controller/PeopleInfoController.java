package com.example.demo.controller;

import com.example.demo.model.People;
import com.example.demo.model.TensorFlow;
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
import java.util.ArrayList;

@RestController
@RequestMapping("/people")
@CrossOrigin
public class PeopleInfoController {
    @GetMapping("/getTensorFlowPeopleInfo")
    public ArrayList<People> getTensorFlowPeopleInfo(){
        ArrayList<People> people=new ArrayList<>();
        try (Reader reader = Files.newBufferedReader(Paths.get("src/main/java/com/example/demo/asserts/Tensorflow/Developers by Project.csv"));
             CSVReader csvReader = new CSVReader(reader)) {
            String[] record;
            record = csvReader.readNext();
            while ((record = csvReader.readNext()) != null) {
                int idx3=record[5].indexOf(',');
                int num2;
                if(idx3!=-1){
                    num2=Integer.parseInt(record[5].substring(0,idx3 )+record[5].substring(idx3+1));
                }else num2=Integer.parseInt(record[5]);
                    people.add(new People(record[0],num2));
            }
        } catch (IOException | CsvValidationException ex) {
            ex.printStackTrace();
        }
        return people;
    }
    @GetMapping("/getPyTorchPeopleInfo")
    public ArrayList<People> getPyTorchPeopleInfo(){
        ArrayList<People> people=new ArrayList<>();
        try (Reader reader = Files.newBufferedReader(Paths.get("src/main/java/com/example/demo/asserts/Pytorch/Authors.csv"));
             CSVReader csvReader = new CSVReader(reader)) {
            String[] record;
            record = csvReader.readNext();
            while ((record = csvReader.readNext()) != null) {
                int idx3=record[4].indexOf(',');
                int num2;
                if(idx3!=-1){
                    num2=Integer.parseInt(record[4].substring(0,idx3 )+record[4].substring(idx3+1));
                }else num2=Integer.parseInt(record[4]);
                people.add(new People(record[1],num2));
            }
        } catch (IOException | CsvValidationException ex) {
            ex.printStackTrace();
        }
        return people;
    }
}
