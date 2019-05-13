package models;

import lombok.*;

import java.sql.Date;
import java.util.Objects;

@Builder
@Getter
@Setter
@ToString
public class TechnicalData extends Data {
    private Long id;
    private Date date;
    private Integer openRate;
    private Integer closeRate;
    private Integer intradayVolume;
    private Integer intradayMax;
    private Integer intradayMin;
    private String dataSource;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TechnicalData)) return false;
        TechnicalData that = (TechnicalData) o;
        return getOpenRate().equals(that.getOpenRate()) &&
                getCloseRate().equals(that.getCloseRate()) &&
                getIntradayVolume().equals(that.getIntradayVolume()) &&
                getIntradayMax().equals(that.getIntradayMax()) &&
                getIntradayMin().equals(that.getIntradayMin()) &&
                getDate().equals(that.getDate()) &&
                getDataSource().equals(that.getDataSource());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOpenRate(), getCloseRate(), getIntradayVolume(), getDate(), getDataSource());
    }
}
