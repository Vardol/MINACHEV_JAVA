package Services;

import lombok.Getter;
import lombok.Setter;
import models.TechnicalData;
import repositories.TechnicalDataRepository;
import schedulers.CollectorScheduler;

import java.util.List;

@Getter
@Setter
public class TechnicalDataCollectorServiceImpl implements TechnicalDataCollectorService {

    private TechnicalDataRepository dataRepository;
    private CollectorScheduler scheduler;
    private List<TechnicalData> collectedData;


    public TechnicalDataCollectorServiceImpl(TechnicalDataRepository dataRepository, CollectorScheduler scheduler) {
        this.dataRepository = dataRepository;
        this.scheduler = scheduler;
        this.scheduler.add(this);
    }

    public List<TechnicalData> collect() {
        return null;
    }

    public void deployData(List<TechnicalData> collectedData) {
        while (collectedData.iterator().hasNext()) {
            this.dataRepository.save(collectedData.iterator().next());
        }
    }
}
