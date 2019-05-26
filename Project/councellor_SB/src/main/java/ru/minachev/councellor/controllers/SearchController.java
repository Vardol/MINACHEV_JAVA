package ru.minachev.councellor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.minachev.councellor.models.TechnicalData;
import ru.minachev.councellor.services.TechnicalDataService;

import java.time.LocalDate;
import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private TechnicalDataService technicalDataService;

    @GetMapping("/search")
    public String getSearchPage() {
        return "search";
    }

    @GetMapping("/search.json")
    @ResponseBody
    public List<TechnicalData> getTechnicalDataByDate(@RequestParam("q") String query,
                                                      @RequestParam("type") String type) {
        if (type.equals("string")) {
            return technicalDataService.getTechnicalDataSearchByDataSource(query);
        }
        if (type.equals("date")) {
            LocalDate queryDate = LocalDate.parse(query);
            return technicalDataService.getTechnicalDataSearchByDate(queryDate);
        }
        return null;
    }
}
