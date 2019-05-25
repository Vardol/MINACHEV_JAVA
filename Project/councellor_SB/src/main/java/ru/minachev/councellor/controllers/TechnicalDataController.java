package ru.minachev.councellor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.minachev.councellor.models.TechnicalData;
import ru.minachev.councellor.services.TechnicalDataService;

import java.util.List;

@Controller
@RequestMapping(value = "/collected_tech_data")
public class TechnicalDataController {

    @Autowired
    private TechnicalDataService technicalDataService;

    @GetMapping
    public String collectedTechDataPage(@RequestParam(value = "sort", required = false) Boolean sort,
                               @RequestParam(value = "by", required = false) String by,
                               @RequestParam(value = "desc", required = false) Boolean desc,
                               ModelMap model) {
        List<TechnicalData> collectedTechnicalData = technicalDataService.getTechnicalData(sort, by, desc);
        model.addAttribute("collectedTechnicalData", collectedTechnicalData);
        return "collected_tech_data";
    }

//    @GetMapping
//    public String collectedTechDataPage(ModelMap model) {
//        List<TechnicalData> collectedTechnicalData = technicalDataService.getTechnicalData(true, "date", true);
//        model.addAttribute("collectedTechnicalData", collectedTechnicalData);
//        return "collected_tech_data";
//    }
//
//
//    public String collectedTechnicalDataPage(ModelMap modelMap) {
//        List<TechnicalData> CollectedTechnicalData = technicalDataRepository.findAll();
//        modelMap.addAttribute("CollectedTechnicalData", CollectedTechnicalData);
//        return "CollectedTechData";
//    }
}
