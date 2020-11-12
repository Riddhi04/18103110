import java.util.*;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import com.opencsv.CSVWriter;
public class Main {
    private static final List<String> word_faculty= new LinkedList<>();
    public static boolean related_links(String link) {
        for(String s : word_faculty)
        {
            if(link.contains(s) ) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        ArrayList < String > url_list = new ArrayList<>();
        Set < String > url_set = new HashSet<>();
        String url = "https://pec.ac.in/";
        url_list.add(url);
        url_set.add(url);
        String current_url;
        word_faculty.addAll(Arrays.asList(("faculty research programmes campus administration members committee institute department centres professor prof assistant teacher teaching engineer doctor scholar chairman qualification director phd ").split(" ")));

        CSVWriter csv_writer_url = new CSVWriter(new FileWriter(new File("faculty_urls.csv")));
        CSVWriter csv_writer_tag = new CSVWriter(new FileWriter(new File("faculty_txt.csv")));
        String[] url_header = { "TextForURL", "URL" };
        String[] tag_header = { "TypeOfTag", "TextEnclosed" };
        csv_writer_url.writeNext(url_header);
        csv_writer_tag.writeNext(tag_header);

        for (int i = 0; i < url_list.size(); i++) {
            try {
                current_url = url_list.get(i);
                Document document = Jsoup.connect(current_url).get();
                String title = document.title();
                if (current_url.contains("faculty")) {
                    csv_writer_tag.writeNext(new String[] {});
                    csv_writer_tag.writeNext(new String[] { "url: " + (i + 1), current_url });
                    csv_writer_tag.writeNext(new String[] { "titleTag", title });
                }
                Elements links = document.select("a[href]");
                for (Element link: links) {
                    String url_pg, url_txt;
                    url_pg = link.absUrl("href");
                    if(!url_pg.contains("http")) {
                        url_pg = "https://pec.ac.in" + url_pg;
                    }
                    url_txt = link.txt();
                    if ((!url_set.contains(url_pg)) && url_txt.length() > 0) {
                        if (related_links(url_pg)) {

                            if (current_url.contains("faculty")) {
                                csv_writer_url.writeNext(new String[] {});
                                csv_writer_url.writeNext(new String[]{url_txt, url_pg});
                            }
                            url_set.add(url_pg);
                            url_list.add(url_pg);
                        }
                    }
                }
                if (current_url.contains("faculty")) {
                    Elements para_tag = document.select("p");
                    for (Element p: para_tag) {
                        String txt;
                        txt = p.txt();
                        if (txt.length() > 2) {
                            csv_writer_tag.writeNext(new String[] { "p", txt });
                        }
                    }

                    Elements h1Tag = document.select("h1");
                    for (Element h: h1Tag) {
                        String txt;
                        txt = h.txt();
                        if (txt.length() > 0) {
                            csv_writer_tag.writeNext(new String[] { "h1", txt });
                        }
                    }
                    System.out.println("URL: " + current_url);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        csv_writer_tag.close();
        csv_writer_url.close();
    }
}
