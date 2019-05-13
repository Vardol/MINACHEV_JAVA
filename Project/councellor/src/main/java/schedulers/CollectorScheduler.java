package schedulers;

import Services.CollectorService;
import models.Data;

import java.util.List;

public class CollectorScheduler {
    private CollectorService[] collectors = new CollectorService[10];
    private int quantity;

    public void startCollecting() {
        for (int i = 0; i < collectors.length; i++) {
            collectors[i].deployData(collectors[i].collect());
        }
    }

    public void add(CollectorService newCollectorService) {
        this.collectors[quantity] = newCollectorService;
    }
}
