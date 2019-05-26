package ru.minachev.councellor.collectors;

import org.springframework.stereotype.Component;
import ru.minachev.councellor.models.TechnicalData;

@Component
public interface TechnicalDataCollector extends Collector<TechnicalData> {
}
