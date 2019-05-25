package ru.minachev.councellor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.minachev.councellor.Scheduler.Scheduler;

@SpringBootApplication
public class CouncellorApplication {

    public static void main(String[] args) {
        SpringApplication.run(CouncellorApplication.class, args);
    }
}
