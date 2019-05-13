package repositories;

import models.TechnicalData;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface TechnicalDataRepository extends DataRepository<TechnicalData> {
    Optional<TechnicalData> findByDate(Date date);
    List<TechnicalData> findAllBySource(String source);
}
