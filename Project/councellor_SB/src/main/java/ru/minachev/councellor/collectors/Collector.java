package ru.minachev.councellor.collectors;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface Collector<T> {
    T collectLast();
    List<T> collectRange();
}
