package movies.stepImpl;

import helpers.HttpHelper;
import model.ImdbData;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class DirectorNameStepsImpl {

  private static HttpHelper httpHelper = new HttpHelper();

  private static String IMDB_URL="https://www.omdbapi.com/?t=";

    public String returnDirectorFromImdb(String movie , String url){

      try {
        ImdbData imdbData = (ImdbData) httpHelper.doGetRequest(IMDB_URL+movie+"&plot=full&apikey=380de361", ImdbData.class);
        return imdbData.getDirector();
      } catch (IOException e) {
        e.printStackTrace();
      }
      return null;
    }

    public String returnDirectorFromWiki(String movie , String wikiUrl){

      try {
        Document document = Jsoup.connect(wikiUrl).get();
        Elements table= document.select("table[class=infobox vevent]");
        Elements tr = table.select("tr:nth-child(3)");
        Elements td = tr.select("td");
       return td.text();
      } catch (IOException e) {
        e.printStackTrace();
      }
      return null;
    }

}

