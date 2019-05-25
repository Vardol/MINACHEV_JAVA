package ru.minachev.councellor.Scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import ru.minachev.councellor.collectors.TechnicalDataCollectorFinanzRuImpl;


import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableScheduling
public class Scheduler {

    private List<TimeBound> tasks = new ArrayList<>();
    private boolean initialized = false;

    @Autowired
    @Qualifier("technicalDataCollectorFinanzRuImpl")
    private TimeBound technicalDataCollectorFinanzRuImpl;

    @Autowired
    @Qualifier("technicalDataServiceImpl")
    private TimeBound technicalDataService;

    public void initialize() {
        if (!initialized) {
            this.tasks.add(technicalDataCollectorFinanzRuImpl);
            this.tasks.add(technicalDataService);
            this.initialized = true;
        }
    }

    @Scheduled(cron = "*/10 * * * * *")
    @Transactional
    public void runTasksOnSchedule() {
        if (tasks != null) {
            for (TimeBound task : tasks) {
                task.runOnSchedule();
            }
        }
    }
}
