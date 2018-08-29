package utils;

import movies.steps.DirectorNamesSteps;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class JSONObjects {

    public void createJSON()
    {
        JSONObject jo = new JSONObject();
        JSONArray data = new JSONArray();

        for(int i = 0; i < DirectorNamesSteps.threadInfo.getDo().size(); i++)
        {
            JSONObject moviesData = new JSONObject();
            Do dos = DirectorNamesSteps.threadInfo.getDo().get(i);

            moviesData.put("movieID", (i+1));
            moviesData.put("movieName", dos.moviename);
            moviesData.put("wikipediaUrl", dos.wikirurls);
            moviesData.put("wikipediaSnapshot", "null");
            moviesData.put("wikipediaDirector", getDirectorsName(dos.wikidirectornames));
            moviesData.put("imdbUrl", dos.imdburl);
            moviesData.put("imdbSnapshot", (i+1));
            moviesData.put("imdbDirector", getDirectorsName(dos.imdbdirectornames));
            moviesData.put("difference", getNotFound(dos.notFound));
            moviesData.put("threadID", dos.threadID);
            moviesData.put("platformName", dos.threadID);
            moviesData.put("startTime",dos.startTime );
            moviesData.put("endTime",dos.endTime );
            if(getNotFound(dos.notFound).equals("NA"))
            {
                moviesData.put("status", "Pass");
            }
            else
            {
                moviesData.put("status", "Fail");
            }
            data.add(moviesData);
        }
        jo.put("Data", data);
        System.out.println(jo.toJSONString());
    }



    private String getDirectorsName(String arr[])
    {
        String director="";
        for(int j = 0; j < arr.length; j++)
        {
            if(j == 0)
            {
                director = director + arr[j];
            }
            else
            {
                director = director + "," + arr[j];
            }
        }
        return director;
    }


    private String getNotFound(ArrayList<String> arr)
    {
        String director = "NA";
        for(int j = 0; j < arr.size(); j++)
        {
            if(j == 0)
            {
                director = director + arr.get(j);
            }
            else
            {
                director = director + "," + arr.get(j);
            }
        }
        return director;
    }


}