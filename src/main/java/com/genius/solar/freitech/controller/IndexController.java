package com.genius.solar.freitech.controller;

import com.genius.solar.freitech.db.elasticsearch.repository.ElectricEnergyIndexRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class IndexController {

    private ElectricEnergyIndexRepository electricEnergyIndexRepository;

    public IndexController(ElectricEnergyIndexRepository electricEnergyIndexRepository) {
        this.electricEnergyIndexRepository = electricEnergyIndexRepository;
    }

    @GetMapping("/service/index")
    public String index() {
        return "service/index";
    }

    @GetMapping("/service/index/create")
    public String indexCreate() {
        try{
            electricEnergyIndexRepository.createIndex();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return "service/index";
    }

}
