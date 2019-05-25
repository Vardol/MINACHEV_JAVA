package ru.minachev.councellor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.minachev.councellor.models.TechnicalData;
import ru.minachev.councellor.services.TechnicalDataService;

import java.util.List;

@Controller
@RequestMapping(value = "/")
public class SearchController {

    @Autowired
    private TechnicalDataService technicalDataService;

    @GetMapping
    public String getRoot() {
        return "redirect:/search";
    }

    @GetMapping("/search")
    public String getSearchPage() {
        return "search";
    }

    @GetMapping("/search.json")
    @ResponseBody
    public List<TechnicalData> getTechnicalDataByDate(@RequestParam("q") String query) {
        return technicalDataService.getTechnicalDataSearchByDataSource(query);
    }
}
