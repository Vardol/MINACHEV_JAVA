package ru.minachev.councellor.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.minachev.councellor.Scheduler.TimeBound;
import ru.minachev.councellor.models.TechnicalData;
import ru.minachev.councellor.repositories.TechnicalDataRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class TechnicalDataServiceImpl implements TechnicalDataService, TimeBound {

    @Autowired
    private TechnicalDataRepository technicalDataRepository;

    @Override
    public List<TechnicalData> getTechnicalData(Boolean sort, String by, Boolean desc) {
        if (sort == null || !sort) {
            return technicalDataRepository.findAll();
        } else {
            if (by != null) {
                switch (by) {
                    case "id":
                        if (desc != null && !desc) {
                            return technicalDataRepository.findAllByOrderById();
                        } else {
                            return technicalDataRepository.findAllByOrderByIdDesc();
                        }
                    case "date":
                        if (desc != null && !desc) {
                            return technicalDataRepository.findAllByOrderByDate();
                        } else {
                            return technicalDataRepository.findAllByOrderByDateDesc();
                        }
                    case "datasource":
                        if (desc != null && !desc) {
                            return technicalDataRepository.findAllByOrderByDataSource();
                        } else {
                            return technicalDataRepository.findAllByOrderByDataSourceDesc();
                        }
                }
            }
            return technicalDataRepository.findAllByOrderByDateDesc();
        }
    }

    @Override
    public List<TechnicalData> getTechnicalDataSearchByDataSource(String dataSource) {
        return technicalDataRepository.findAllByDataSourceContainsIgnoreCase(dataSource);
    }

    @Override
    public List<TechnicalData> getTechnicalDataSearchByDate(LocalDate date) {
        return technicalDataRepository.findAllByDateEquals(date);
    }

    @Override
    public void saveTechnicalData(TechnicalData technicalData) {
        if (!containsDate(technicalData.getDate())) {
            technicalDataRepository.save(technicalData);
        } else {
            List<TechnicalData> technicalDataOnDate = technicalDataRepository.findAllByDateEquals(technicalData.getDate());
            if (!technicalDataOnDate.contains(technicalData)) {
                technicalDataRepository.save(technicalData);
            }
        }
    }

    @Override
    public void saveAllTechnicalData(List<TechnicalData> technicalData) {
        for (int i = 0; i < technicalData.size(); i++) {
            if (containsDate(technicalData.get(i).getDate())) {
                technicalData.remove(i);
                i--;
            }
        }
        if (technicalData.size() > 0) {
            technicalDataRepository.saveAll(technicalData);
        }
    }

    @Override
    public void deleteTechnicalDataById(Long id) {
        technicalDataRepository.deleteTechnicalDataByIdEquals(id);
    }

    @Override
    public void deleteTechnicalData(TechnicalData data) {
        technicalDataRepository.deleteTechnicalDataByIdEquals(data.getId());
    }

    @Override
    public void deleteDuplicates() {
        List<TechnicalData> dataList = getTechnicalData(true, "date", true);
        int size = dataList.size();
        if (size > 0) {
            for (int i = 0; i < size - 1; i++) {
                if (dataList.get(i).equals(dataList.get(i + 1))) {
                    deleteTechnicalDataById(dataList.get(i).getId());
                }
            }
        }
    }

    @Override
    public boolean containsDate(LocalDate date) {
        return technicalDataRepository.countTechnicalDataByDateEquals(date) > 0;
    }

    @Override
    public void runOnSchedule() {
        deleteDuplicates();
    }
}
