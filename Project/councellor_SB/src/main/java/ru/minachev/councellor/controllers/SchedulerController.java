package ru.minachev.councellor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.minachev.councellor.Scheduler.Scheduler;

@Controller
public class SchedulerController {

    @Autowired
    private Scheduler scheduler;

    @GetMapping("/scheduler")
    public String getSchedulerPage() {
        return "scheduler";
    }

    @GetMapping("/scheduler.json")
    @ResponseBody
    public void initialize() {
        scheduler.initialize();
    }
}
