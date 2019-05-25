package ru.minachev.councellor.models;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public abstract class Data {
    private LocalDate date;
    private String dataSource;
    private Long id;

    @Override
    public abstract boolean equals(Object o);
}
