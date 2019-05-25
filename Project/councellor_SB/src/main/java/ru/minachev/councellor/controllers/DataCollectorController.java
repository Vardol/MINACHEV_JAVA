package ru.minachev.councellor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.minachev.councellor.collectors.TechnicalDataCollector;
import ru.minachev.councellor.services.TechnicalDataService;

@Controller
@RequestMapping(value = "/collect")
public class DataCollectorController {

    @Autowired
    private TechnicalDataService technicalDataService;

    @Autowired
    private TechnicalDataCollector technicalDataCollector;

    @GetMapping
    public String GetCollectorsPage(@RequestParam(value = "range", required = false) Boolean range) {
        if (range) {
            technicalDataService.saveAllTechnicalData(technicalDataCollector.collectRange());
        } else {
            technicalDataService.saveTechnicalData(technicalDataCollector.collectLast());

        }
        return "redirect:/collected_tech_data";
    }
}