package ru.minachev.councellor.collectors;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.minachev.councellor.Scheduler.TimeBound;
import ru.minachev.councellor.models.TechnicalData;
import ru.minachev.councellor.services.TechnicalDataService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Component
public class TechnicalDataCollectorFinanzRuImpl extends TechnicalDataCollector implements TimeBound {
    public static final String URL = "https://www.finanz.ru/valyuty/USD-RUB";

    @Autowired
    TechnicalDataService technicalDataServiceImpl;

    @Override
    public TechnicalData collectLast() {
        Document document = null;

        {
            try {
                document = Jsoup.connect(URL).get();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String documentString = document.toString();
        String table = documentString.substring(documentString.indexOf("news_table") + 221, documentString.indexOf("news_table") + 2378);

        TechnicalData technicalData = null;

        int dd = (table.charAt(table.indexOf("td")+3) - 48) * 10;
        dd += table.charAt(table.indexOf("td")+4) - 48;
        int mm = (table.charAt(table.indexOf("td")+6) - 48) * 10;
        mm += table.charAt(table.indexOf("td")+7) - 48;
        int yyyy = (table.charAt(table.indexOf("td")+9) -48) * 10;
        yyyy += table.charAt(table.indexOf("td")+10) - 48 + 2000;
        table = table.substring(table.indexOf("td")+16);

            double closeRate = (double)(table.charAt(table.indexOf("td")+10) -48) * 10;
            closeRate += (double)(table.charAt(table.indexOf("td")+11) -48);
            closeRate += (double)(table.charAt(table.indexOf("td")+13) -48) / 10;
            closeRate += (double)(table.charAt(table.indexOf("td")+14) -48) / 100;
            closeRate += (double)(table.charAt(table.indexOf("td")+15) -48) / 1000;
            closeRate += (double)(table.charAt(table.indexOf("td")+16) -48) / 10000;
            table = table.substring(table.indexOf("td")+29);


            double openRate = (double)(table.charAt(table.indexOf("td")+10) -48) * 10;
            openRate += (double)(table.charAt(table.indexOf("td")+11) -48);
            openRate += (double)(table.charAt(table.indexOf("td")+13) -48) / 10;
            openRate += (double)(table.charAt(table.indexOf("td")+14) -48) / 100;
            openRate += (double)(table.charAt(table.indexOf("td")+15) -48) / 1000;
            openRate += (double)(table.charAt(table.indexOf("td")+16) -48) / 10000;
            table = table.substring(table.indexOf("td")+29);

//            System.out.println("printing row #" + i + "." + rows[i]);

            double intradayMax = (table.charAt(table.indexOf("td")+10) -48) * 10;
            intradayMax += (double)(table.charAt(table.indexOf("td")+11) -48);
            intradayMax += (double)(table.charAt(table.indexOf("td")+13) -48) / 10;
            intradayMax += (double)(table.charAt(table.indexOf("td")+14) -48) / 100;
            intradayMax += (double)(table.charAt(table.indexOf("td")+15) -48) / 1000;
            intradayMax += (double)(table.charAt(table.indexOf("td")+16) -48) / 10000;
            table = table.substring(table.indexOf("td")+29);

//            System.out.println("printing row #" + i + "." + rows[i]);

            double intradayMin = (table.charAt(table.indexOf("td")+10) -48) * 10;
            intradayMin += (double)(table.charAt(table.indexOf("td")+11) -48);
            intradayMin += (double)(table.charAt(table.indexOf("td")+13) -48) / 10;
            intradayMin += (double)(table.charAt(table.indexOf("td")+14) -48) / 100;
            intradayMin += (double)(table.charAt(table.indexOf("td")+15) -48) / 1000;
            intradayMin += (double)(table.charAt(table.indexOf("td")+16) -48) / 10000;

//            System.out.println(dd + "." + mm + "." + yyyy + " open=" + openRate + " close=" + closeRate + " MAX=" + intradayMax + " MIN=" + intradayMin);
            technicalData = TechnicalData.builder().dataSource(URL).openRate(openRate)
                    .closeRate(closeRate).intradayMax(intradayMax).intradayMin(intradayMin).date(LocalDate.of(yyyy, mm, dd))
                    .build();
            System.out.println("");

        return technicalData;
    }

    @Override
    public List<TechnicalData> collectRange() {
        List<TechnicalData> result = new ArrayList<TechnicalData>();

        Document document = null;

        {
            try {
                document = Jsoup.connect(URL).get();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String documentString = document.toString();
        String table = documentString.substring(documentString.indexOf("news_table") + 221, documentString.indexOf("news_table") + 2378);

        String[] rows = new String[20];

        for (int i = 0; table.contains("tr"); i++) {
            rows[i] = table.substring(table.indexOf("tr"), table.indexOf("tr", table.indexOf("tr") + 2));
//            System.out.println("printing row #" + i + ". " + rows[i]);
            int dd = (rows[i].charAt(rows[i].indexOf("td")+3) - 48) * 10;
            dd += rows[i].charAt(rows[i].indexOf("td")+4) - 48;
            int mm = (rows[i].charAt(rows[i].indexOf("td")+6) - 48) * 10;
            mm += rows[i].charAt(rows[i].indexOf("td")+7) - 48;
            int yyyy = (rows[i].charAt(rows[i].indexOf("td")+9) -48) * 10;
            yyyy += rows[i].charAt(rows[i].indexOf("td")+10) - 48 + 2000;
            rows[i] = rows[i].substring(rows[i].indexOf("td")+16);

//            System.out.println("printing row #" + i + "." + rows[i]);

            double closeRate = (double)(rows[i].charAt(rows[i].indexOf("td")+10) -48) * 10;
            closeRate += (double)(rows[i].charAt(rows[i].indexOf("td")+11) -48);
            closeRate += (double)(rows[i].charAt(rows[i].indexOf("td")+13) -48) / 10;
            closeRate += (double)(rows[i].charAt(rows[i].indexOf("td")+14) -48) / 100;
            closeRate += (double)(rows[i].charAt(rows[i].indexOf("td")+15) -48) / 1000;
            closeRate += (double)(rows[i].charAt(rows[i].indexOf("td")+16) -48) / 10000;
            rows[i] = rows[i].substring(rows[i].indexOf("td")+29);

//            System.out.println("printing row #" + i + "." + rows[i]);

            double openRate = (double)(rows[i].charAt(rows[i].indexOf("td")+10) -48) * 10;
            openRate += (double)(rows[i].charAt(rows[i].indexOf("td")+11) -48);
            openRate += (double)(rows[i].charAt(rows[i].indexOf("td")+13) -48) / 10;
            openRate += (double)(rows[i].charAt(rows[i].indexOf("td")+14) -48) / 100;
            openRate += (double)(rows[i].charAt(rows[i].indexOf("td")+15) -48) / 1000;
            openRate += (double)(rows[i].charAt(rows[i].indexOf("td")+16) -48) / 10000;
            rows[i] = rows[i].substring(rows[i].indexOf("td")+29);

//            System.out.println("printing row #" + i + "." + rows[i]);

            double intradayMax = (rows[i].charAt(rows[i].indexOf("td")+10) -48) * 10;
            intradayMax += (double)(rows[i].charAt(rows[i].indexOf("td")+11) -48);
            intradayMax += (double)(rows[i].charAt(rows[i].indexOf("td")+13) -48) / 10;
            intradayMax += (double)(rows[i].charAt(rows[i].indexOf("td")+14) -48) / 100;
            intradayMax += (double)(rows[i].charAt(rows[i].indexOf("td")+15) -48) / 1000;
            intradayMax += (double)(rows[i].charAt(rows[i].indexOf("td")+16) -48) / 10000;
            rows[i] = rows[i].substring(rows[i].indexOf("td")+29);

//            System.out.println("printing row #" + i + "." + rows[i]);

            double intradayMin = (rows[i].charAt(rows[i].indexOf("td")+10) -48) * 10;
            intradayMin += (double)(rows[i].charAt(rows[i].indexOf("td")+11) -48);
            intradayMin += (double)(rows[i].charAt(rows[i].indexOf("td")+13) -48) / 10;
            intradayMin += (double)(rows[i].charAt(rows[i].indexOf("td")+14) -48) / 100;
            intradayMin += (double)(rows[i].charAt(rows[i].indexOf("td")+15) -48) / 1000;
            intradayMin += (double)(rows[i].charAt(rows[i].indexOf("td")+16) -48) / 10000;

//            System.out.println(dd + "." + mm + "." + yyyy + " open=" + openRate + " close=" + closeRate + " MAX=" + intradayMax + " MIN=" + intradayMin);
            TechnicalData technicalData = TechnicalData.builder().dataSource(URL).openRate(openRate)
                    .closeRate(closeRate).intradayMax(intradayMax).intradayMin(intradayMin).date(LocalDate.of(yyyy, mm, dd) )
                    .build();
            result.add(technicalData);
            table = table.substring(table.indexOf("tr", table.indexOf("tr") + 2) + 2);
            System.out.println("");

        }
    return result;
    }

    @Override
    public void runOnSchedule() {
        technicalDataServiceImpl.saveAllTechnicalData(this.collectRange());
    }
}
