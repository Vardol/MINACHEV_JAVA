package repositories;

import models.TechnicalData;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public class TechnicalDataRepositoryJdbcTemplateImpl implements TechnicalDataRepository{

    //language=SQL
    private final static String SQL_SELECT_BY_ID = "select * from technical_data where id = ?";

    //language=SQL
    private final static String SQL_SELECT_BY_DATE = "select * from technical_data where data_date = ?";

    //language=SQL
    private final static String SQL_SELECT_ALL = "select * from technical_data";

    //language=SQL
    private final static String SQL_SELECT_ALL_BY_SOURCE = "select * from technical_data " +
            "where data_source = ?";

    //language=SQL
    private final static String SQL_INSERT = "insert into technical_data(open_rate, close_rate, data_date, intraday_max, intraday_min, intraday_volume) " +
            "values (?, ?, ?, ?, ?, ?)";

    private JdbcTemplate jdbcTemplate;

    private RowMapper<TechnicalData> technicalDataRowMapper = (row, rowNumber) ->
            TechnicalData.builder().id(row.getLong("id"))
                    .date(row.getDate("data_date"))
                    .openRate(row.getInt("open_rate"))
                    .closeRate(row.getInt("close_rate"))
                    .intradayVolume(row.getInt("intraday_volume"))
                    .intradayMax(row.getInt("intraday_max"))
                    .intradayMin(row.getInt("intraday_min"))
                    .dataSource(row.getString("data_source"))
                    .build();

    public TechnicalDataRepositoryJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(TechnicalData model) {
        jdbcTemplate.update(SQL_INSERT, model.getOpenRate(), model.getCloseRate(), model.getDate(),
                model.getIntradayMax(), model.getIntradayMin(), model.getIntradayVolume());
    }

    @Override
    public TechnicalData find(Long id) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, technicalDataRowMapper, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<TechnicalData> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL, technicalDataRowMapper);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Optional<TechnicalData> findByDate(Date date) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(SQL_SELECT_BY_DATE, technicalDataRowMapper, date));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<TechnicalData> findAllBySource (String source) {
        return jdbcTemplate.query(SQL_SELECT_ALL_BY_SOURCE, technicalDataRowMapper, source);
    }
}
