import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import javax.swing.text.html.HTML;
import java.lang.String;
import java.io.IOException;

class Main {



    public static void main(String[] args) {
        String url = "https://www.finanz.ru/valyuty/USD-RUB";

        Document document = null;

        {
            try {
                document = Jsoup.connect(url).get();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        url = document.toString();
        String table = url.substring(url.indexOf("news_table") + 221, url.indexOf("news_table") + 2378);

        String[] rows = new String[20];

        for (int i = 0; table.contains("tr"); i++) {
            rows[i] = table.substring(table.indexOf("tr"), table.indexOf("tr", table.indexOf("tr") + 2));
            System.out.println("printing row #" + i + ". " + rows[i]);
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

            System.out.println(dd + "." + mm + "." + yyyy + " open=" + openRate + " close=" + closeRate + " MAX=" + intradayMax + " MIN=" + intradayMin);
            table = table.substring(table.indexOf("tr", table.indexOf("tr") + 2) + 2);
            System.out.println("");
        }





    }
}
