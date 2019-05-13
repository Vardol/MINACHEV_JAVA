package models;


import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public abstract class Data {
    private Date date;
    private String dataSource;
    private Long id;

    @Override
    public abstract boolean equals(Object o);
}
