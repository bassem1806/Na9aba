package com.example.Securite_Routiere.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.Securite_Routiere.repositories.PvAccident1Repository;
import org.springframework.stereotype.Service;

@Service
public class DataAccidentService {
    @Autowired
    private PvAccident1Repository pvAccident1Repository;

    public Object[] getNumberAccident(){
        //System.out.println(pvAccident1Repository.countTotalaccidByGov());
        Object[] accidentData = pvAccident1Repository.countTotalaccidByGov();
        return accidentData;
    }
}
