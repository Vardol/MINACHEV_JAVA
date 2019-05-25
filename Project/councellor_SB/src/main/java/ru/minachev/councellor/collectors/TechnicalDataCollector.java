package ru.minachev.councellor.collectors;

import org.springframework.stereotype.Component;
import ru.minachev.councellor.models.TechnicalData;

@Component
public abstract class TechnicalDataCollector implements Collector<TechnicalData> {
}
