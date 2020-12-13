package com.justa.convert.service;

import com.justa.convert.model.Units;
import org.springframework.stereotype.Service;

@Service
public class UnitService {

    private Units unit = new Units();

    public Units convertUnits(String units) throws Exception {
        unit = unit.ConvertUnits(units);
        return unit;
    }
}
