package com.example.djangoserverfl.service;

import com.example.djangoserverfl.model.Status;
import com.example.djangoserverfl.model.Table1Model;
import com.example.djangoserverfl.repository.Table1Repository;
import org.springframework.stereotype.Service;

@Service
public class Table1Service {

    private final Table1Repository table1Repository;
    public Table1Service(Table1Repository table1Repository) {
        this.table1Repository = table1Repository;
    }

    public Table1Model getData(){
        var data = table1Repository.findById(1L);
        var returnValue = new Table1Model();
        if(data.isPresent())
            returnValue.setData1(data.get().getData1());
        else
            returnValue.setData1("no data");
        return returnValue;
    }

    public Status insertData(Table1Model table1Model){
        var result = new Status();
        if(table1Model.getData1()!=null)
            if(!table1Model.getData1().isEmpty())
                if(table1Model.getData1().isBlank())
                    result.setStatus("blank input");
                else {
                    var table = table1Repository.findById(1L).get();
                    table.setData1(table1Model.getData1());
                    table1Repository.save(table);
                    result.setStatus("OK");
                }
            else result.setStatus("empty input");
        else result.setStatus("null input");
        return result;
    }
}
