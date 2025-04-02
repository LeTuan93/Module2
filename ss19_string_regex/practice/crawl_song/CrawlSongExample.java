package practice.crawl_song;

import java.net.URL;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CrawlSongExample {
    public static void main(String[] args) {
        try{
            URL url = new URL("https://www.nhaccuatui.com/bai-hat/nhac-tre-moi.html");
            // open the stream and put it into BufferedReader
            Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
            scanner.useDelimiter("\\Z");
            String content = scanner.next();

            content = content.replaceAll("\\n+", "");

            // regex
            Pattern p = Pattern.compile("name_song\">(.*?)</a>");
            Matcher m = p.matcher(content);
            while (m.find()) {
                System.out.println(m.group(1));
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
