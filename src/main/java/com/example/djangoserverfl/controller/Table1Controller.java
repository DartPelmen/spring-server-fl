package com.example.djangoserverfl.controller;

import com.example.djangoserverfl.model.Status;
import com.example.djangoserverfl.model.Table1Model;
import com.example.djangoserverfl.service.Table1Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Table1Controller {
    private final Table1Service table1Service;

    public Table1Controller(Table1Service table1Service) {
        this.table1Service = table1Service;
    }

    @GetMapping("/")
    public Table1Model getFirst(){
        return table1Service.getData();
    }
    @PostMapping("/")
    public Status insertData(@RequestBody  Table1Model table1Model){
        return table1Service.insertData(table1Model);
    }
}
