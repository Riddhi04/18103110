import java.io.IOException;
import java.util.*;
import java.io.File;
import java.io.FileWriter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import com.opencsv.CSVWriter;
public class Main {
    static boolean GetChar(String str) {
        int count = 0;
        for(int i=0; i < str.length(); ++i) {
            if(str.charAt(i)=='/') {
                if(count++ > 7) return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        ArrayList < String > List_URL = new ArrayList<>();
        Set < String > Set_URL = new HashSet<>();
        Set < String > Set_PDF = new HashSet<>();
        String url = "https://pec.ac.in";
        List_URL.add(url);
        Set_URL.add(url);
        String current_url;

        CSVWriter csv_writer_pdf = new CSVWriter(new FileWriter(new File("pdf.csv")));
        String[] pdf_header = { "pdfURL" };
        csv_writer_pdf.writeNext(pdf_header);

        for (int i = 0; i < List_URL.size(); i++) {
            try {
                current_url = List_URL.get(i);
                Document doc = Jsoup.connect(current_url).get();
                Elements links = doc.select("a[href]");
                for (Element link: links) {
                    String url_pg = link.absUrl("href");
                    if(!url_pg.contains("http")) {
                        url_pg = "https://pec.ac.in" + url_pg;
                    }
                    if ((!Set_URL.contains(url_pg)) && url_pg.contains("https://pec.ac.in/") && GetChar(url_pg)) {
                        if (url_pg.endsWith(".pdf") && !Set_PDF.contains(url_pg)) {
                            csv_writer_pdf.writeNext(new String[] { url_pg });
                            Set_PDF.add(url_pg);
                        } else {
                            List_URL.add(url_pg);
                            Set_URL.add(url_pg);
                        }
                    }
                }
                Elements iframe = doc.select("iframe");
                for (Element frame: iframe) {
                    String url_pg = frame.attr("data-src");

                    if (!Set_URL.contains(url_pg) && url_pg.contains("https://pec.ac.in/") && url_pg.endsWith(".pdf") && !Set_PDF.contains(url_pg) && GetChar(url_pg)) {
                        csv_writer_pdf.writeNext(new String[] { url_pg });
                        Set_PDF.add(url_pg);
                    }
                }
                System.out.println("URL: " + current_url);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        csv_writer_pdf.close();
    }
}
