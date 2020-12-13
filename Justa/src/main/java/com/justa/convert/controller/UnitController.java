package com.justa.convert.controller;

import com.justa.convert.model.Units;
import com.justa.convert.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping({"/units/si"})
public class UnitController {

    @Autowired
    private UnitService unitService;


    @GetMapping
    public @ResponseBody
    Units ConvertUnits(@RequestParam("units") String units) throws Exception {
        return unitService.convertUnits(units);
    }


}

