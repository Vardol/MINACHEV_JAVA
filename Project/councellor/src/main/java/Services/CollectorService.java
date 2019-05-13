package Services;

import lombok.Getter;
import models.Data;

import java.util.List;

public interface CollectorService<T> {

    List<T> collect();
    void deployData(List<T> collectedData);
}
