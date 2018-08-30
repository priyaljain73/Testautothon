package movies.stepImpl;

import com.google.gson.Gson;
import helpers.HttpHelper;
import org.json.simple.parser.JSONParser;
import model.ImdbData;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

import static movies.steps.DirectorNamesSteps.threadInfo;

public class DirectorNameStepsImpl {

  private static HttpHelper httpHelper = new HttpHelper();

  private static String IMDB_URL="https://www.omdbapi.com/?t=";

    public void extractDataFromImdb(String movie, String url){

      try {
        String imdburl = IMDB_URL+movie.replaceAll(" ","+")+"&plot=full&apikey=380de361";
        String response = httpHelper.doGetRequest(imdburl);
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(response);
        String director = (String) jsonObject.get("Director");
        threadInfo.getDo(movie).imdburl = imdburl;
        threadInfo.getDo(movie).imdbdirectornames = director.split(",");
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    public void extractDataFromWiki(String movie, String wikiUrl){

      try {
        StringBuffer stringBuffer = new StringBuffer();
        Document document = Jsoup.connect(wikiUrl).get();
        Elements table= document.select("table[class=infobox vevent]");
        Elements tr = table.select("tr:nth-child(3)");
        Elements td = tr.select("td");
/*        Elements div = td.select("div");
        if(div!=null){
          Elements ul = div.select("ul");
          for (Element li:ul
               ) {
            stringBuffer.append(li.text());
          }
          System.out.println("---td.text---"+stringBuffer.toString());
        }
        else{
          stringBuffer.append(td.text());
          System.out.println("---td.text--"+td.text());}*/
        threadInfo.getDo(movie).wikidirectornames = td.text().split(",");
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
}

