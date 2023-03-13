package com.example.demo.controller;

import com.example.demo.model.PeoAndCom;
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
@RequestMapping("/relations")
@CrossOrigin
public class PeoAndComController {
    @GetMapping("/getTenRelations")
    public ArrayList<PeoAndCom> getTenRelations(){
        ArrayList<PeoAndCom> peoAndComs=new ArrayList<>();
        try (Reader reader = Files.newBufferedReader(Paths.get("src/main/java/com/example/demo/asserts/Tensorflow/People Contributing.csv"));
             CSVReader csvReader = new CSVReader(reader)) {
            String[] record;
            record = csvReader.readNext();
            while ((record = csvReader.readNext()) != null) {
                int idx=record[0].indexOf('.');
                int idx3=record[1].indexOf(',');
                int num2;
                if(idx3!=-1){
                    num2=Integer.parseInt(record[1].substring(0,idx3 )+record[1].substring(idx3+1));
                }else num2=Integer.parseInt(record[1]);
                if(idx!=-1){
                    peoAndComs.add(new PeoAndCom(record[0].substring(0,idx),num2));
                }else peoAndComs.add(new PeoAndCom(record[0],num2));
            }
        } catch (IOException | CsvValidationException ex) {
            ex.printStackTrace();
        }
        return peoAndComs;
    }
    @GetMapping("/getPyRelations")
    public ArrayList<PeoAndCom> getPyRelations(){
        ArrayList<PeoAndCom> peoAndComs=new ArrayList<>();
        try (Reader reader = Files.newBufferedReader(Paths.get("src/main/java/com/example/demo/asserts/Pytorch/People Contributing.csv"));
             CSVReader csvReader = new CSVReader(reader)) {
            String[] record;
            record = csvReader.readNext();
            while ((record = csvReader.readNext()) != null) {
                int idx=record[0].indexOf('.');
                int idx3=record[1].indexOf(',');
                int num2;
                if(idx3!=-1){
                    num2=Integer.parseInt(record[1].substring(0,idx3 )+record[1].substring(idx3+1));
                }else num2=Integer.parseInt(record[1]);
                if(idx!=-1){
                    peoAndComs.add(new PeoAndCom(record[0].substring(0,idx),num2));
                }else peoAndComs.add(new PeoAndCom(record[0],num2));
            }
        } catch (IOException | CsvValidationException ex) {
            ex.printStackTrace();
        }
        return peoAndComs;
    }
}
