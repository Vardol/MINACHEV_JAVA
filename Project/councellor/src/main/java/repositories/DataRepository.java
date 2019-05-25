package repositories;

import models.Data;
import models.TechnicalData;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface DataRepository<T> extends CrudRepository<T> {
    Optional<T> findByDate(Date date);
    List<T> findAllBySource(String source);
}
