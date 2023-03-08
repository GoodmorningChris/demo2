package com.example.demo.controller;

import com.example.demo.model.TensorFlow;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

@RestController
@RequestMapping("/company")
@CrossOrigin
public class CompanyController {
    @GetMapping("/getTensorFlowInfo")
    public ArrayList<TensorFlow> getTensorFlowInfo(){
        ArrayList<TensorFlow> tensorFlow=new ArrayList<>();
        try (Reader reader = Files.newBufferedReader(Paths.get("src/main/java/com/example/demo/asserts/Tensorflow/organizational_diversity_active_domains_by_data_source_by_contributions.csv"));
             CSVReader csvReader = new CSVReader(reader)) {
            String[] record;
            record = csvReader.readNext();
            while ((record = csvReader.readNext()) != null) {
                int idx=record[1].indexOf('.');
                int idx2=record[2].indexOf(',');
                int idx3=record[3].indexOf(',');
                int num,num2;
//                System.out.println(record[2]);
                if(idx2!=-1){
                    num=Integer.parseInt(record[2].substring(0,idx2)+record[2].substring(idx2+1));
                }else num=Integer.parseInt(record[2]);
                if(idx3!=-1){
                    num2=Integer.parseInt(record[3].substring(0,idx3 )+record[3].substring(idx3+1));
                }else num2=Integer.parseInt(record[3]);
                if(idx!=-1){
                    tensorFlow.add(new TensorFlow(record[1].substring(0,idx),num,num2));
                }else tensorFlow.add(new TensorFlow(record[1],num,num2));
            }
        } catch (IOException | CsvValidationException ex) {
            ex.printStackTrace();
        }
        return tensorFlow;
    }
    @GetMapping("/getPyTorchInfo")
    public ArrayList<TensorFlow> getPyTorchInfo(){
        ArrayList<TensorFlow> tensorFlow=new ArrayList<>();
        try (Reader reader = Files.newBufferedReader(Paths.get("src/main/java/com/example/demo/asserts/PyTorch/organizational_diversity_active_domains_by_data_source_by_contributions.csv"));
             CSVReader csvReader = new CSVReader(reader)) {
            String[] record;
            record = csvReader.readNext();
            while ((record = csvReader.readNext()) != null) {
                int idx=record[0].indexOf('.');
                int idx2=record[1].indexOf(',');
                int num,num2;
//                System.out.println(record[2]);
                if(idx2!=-1){
                    num=Integer.parseInt(record[1].substring(0,idx2)+record[1].substring(idx2+1));
                }else num=Integer.parseInt(record[2]);
                if(idx!=-1){
                    tensorFlow.add(new TensorFlow(record[0].substring(0,idx),num,0));
                }else tensorFlow.add(new TensorFlow(record[1],num,0));
            }
        } catch (IOException | CsvValidationException ex) {
            ex.printStackTrace();
        }
        return tensorFlow;
    }
}
