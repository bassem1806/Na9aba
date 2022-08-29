package com.example.Securite_Routiere.service;

import com.example.Securite_Routiere.repositories.PvAccident1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DateAccidentService {
    @Autowired
    private PvAccident1Repository pvAccident1Repository;

    public Object[] getdateAccident() {

        Object[] accidentDate = pvAccident1Repository.countTotalaccidByperiode();
        return accidentDate;
    }
}
