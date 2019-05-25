package ru.minachev.councellor.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Builder
@Getter
@Setter
@ToString
@Entity
@Table(name = "technical_data")
@AllArgsConstructor
@NoArgsConstructor
public class TechnicalData extends Data {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private double openRate;
    private double closeRate;
    private Integer intradayVolume;
    private double intradayMax;
    private double intradayMin;
    private String dataSource;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TechnicalData that = (TechnicalData) o;
        return Double.compare(that.openRate, openRate) == 0 &&
                Double.compare(that.closeRate, closeRate) == 0 &&
                Double.compare(that.intradayMax, intradayMax) == 0 &&
                Double.compare(that.intradayMin, intradayMin) == 0 &&
                date.equals(that.date);// &&
//                intradayVolume.equals(that.intradayVolume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, openRate, closeRate, intradayVolume, intradayMax, intradayMin);
    }
}
