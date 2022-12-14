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
            returnValue.setData2(data.get().getData2());
        else
            returnValue.setData2("no data");
        return returnValue;
    }

    public Status insertData(Table1Model table1Model){
        var result = new Status();
        if(table1Model.getData2()!=null)
            if(!table1Model.getData2().isEmpty())
                if(table1Model.getData2().isBlank())
                    result.setStatus("blank input");
                else {
                    var table = table1Repository.findById(1L).get();
                    table.setData2(table1Model.getData2());
                    table1Repository.save(table);
                    result.setStatus("OK");
                }
            else result.setStatus("empty input");
        else result.setStatus("null input");
        return result;
    }
}
