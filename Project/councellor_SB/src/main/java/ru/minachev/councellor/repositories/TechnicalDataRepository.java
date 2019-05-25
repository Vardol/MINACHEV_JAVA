package ru.minachev.councellor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.minachev.councellor.models.TechnicalData;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface TechnicalDataRepository extends JpaRepository<TechnicalData, Long> {
    void deleteTechnicalDataByIdEquals(Long id);
    int countTechnicalDataByDateEquals(LocalDate date);
    Optional<TechnicalData> findFirstById(Long id);
    List<TechnicalData> findAllByDataSourceContainsIgnoreCase(String dataSource);
    List<TechnicalData> findAllByDateEquals(LocalDate date);
    List<TechnicalData> findAllByOrderByDate();
    List<TechnicalData> findAllByOrderByDateDesc();
    List<TechnicalData> findAllByOrderById();
    List<TechnicalData> findAllByOrderByIdDesc();
    List<TechnicalData> findAllByOrderByDataSource();
    List<TechnicalData> findAllByOrderByDataSourceDesc();

    static boolean validDate(String dateString) {
        char[] dateCharArray;
        try {
            dateCharArray = dateString.toCharArray();
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Incorrect date format. Use yyyy-mm-dd.");
        }
        return dateCharArray[0] > 47 && dateCharArray[0] <58 &&
                dateCharArray[1] > 47 && dateCharArray[1] <58 &&
                dateCharArray[2] > 47 && dateCharArray[2] <58 &&
                dateCharArray[3] > 47 && dateCharArray[3] <58 &&
                dateCharArray[4] == 45 &&
                dateCharArray[5] > 47 && dateCharArray[5] <58 &&
                dateCharArray[6] > 47 && dateCharArray[6] <58 &&
                dateCharArray[7] == 45 &&
                dateCharArray[8] > 47 && dateCharArray[8] <58 &&
                dateCharArray[9] > 47 && dateCharArray[9] <58;
    }
}
