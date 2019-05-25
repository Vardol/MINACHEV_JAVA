package ru.minachev.councellor.services;

import org.springframework.stereotype.Component;
import ru.minachev.councellor.models.TechnicalData;

import java.time.LocalDate;
import java.util.List;

@Component
public interface TechnicalDataService {
    List<TechnicalData> getTechnicalData(Boolean sort, String by, Boolean desc);
    List<TechnicalData> getTechnicalDataSearchByDataSource(String dataSource);
    List<TechnicalData> getTechnicalDataSearchByDate(LocalDate date);
    void saveTechnicalData(TechnicalData technicalData);
    void saveAllTechnicalData(List<TechnicalData> technicalData);
    void deleteTechnicalDataById(Long id);
    void deleteTechnicalData(TechnicalData data);
    void deleteDuplicates();
    boolean containsDate(LocalDate date);
}
