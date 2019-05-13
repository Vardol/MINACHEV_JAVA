package repositories;

import java.util.List;

public interface CrudRepository<T> {
    void save(T model);
    T find(Long id);
    List<T> findAll();
    void delete(Long id);
}