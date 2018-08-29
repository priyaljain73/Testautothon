package utils;

import org.openqa.selenium.WebDriver;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

public class Do implements Runnable {

    public WebDriver driver;
    public Method[] methods;
    public Object classObject;
    public String moviename;
    public String wikirurls;
    public String[] wikidirectornames;
    public String imdburl;
    public String[] imdbdirectornames;
    public HashMap<String, Object> anyvalue;
    public long threadID = 0;
    public long startTime = 0;
    public long endTime = 0;
    boolean isFirstCall = true;
    public ArrayList<String> notFound;

    Do(WebDriver driver, String moviename, String wikirurls)
    {
        this.moviename = moviename;
        this.wikirurls = wikirurls;
        this.driver = driver;
    }


    @Override
    public void run() {

        if(isFirstCall)
        {
            startTime = System.currentTimeMillis();
            isFirstCall = false;
        }
        for(int i = 0; i < methods.length; i++)
        {
            try {
                methods[i].invoke(classObject, moviename, wikirurls);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        endTime = System.currentTimeMillis();

    }

    public void doMethods(Object classObject, Method... methods)
    {
        this.methods = methods;
        this.classObject = classObject;
    }

    public WebDriver getDriver() {

        return driver;
    }
}
