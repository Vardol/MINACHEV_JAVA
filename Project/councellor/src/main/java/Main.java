import Services.TechnicalDataCollectorServiceImpl;
import models.TechnicalData;
import repositories.TechnicalDataRepositoryJdbcTemplateImpl;
import schedulers.CollectorScheduler;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

class Main{
    public static void main(String[]args){
        TechnicalDataRepositoryJdbcTemplateImpl repository = new TechnicalDataRepositoryJdbcTemplateImpl();
        CollectorScheduler scheduler = new CollectorScheduler();
        TechnicalDataCollectorServiceImpl collector = new TechnicalDataCollectorServiceImpl(repository, scheduler);

        List<TechnicalData> list = new ArrayList<TechnicalData>();
        Date date = java.sql.Date.valueOf("2019-5-13");
        TechnicalData data = TechnicalData.builder().dataSource("TEST").closeRate(100).openRate(50).intradayMax(150).intradayMin(25).
                intradayVolume(100000).date(date).build();
        list.add(data);

        collector.deployData(list);
    }
}