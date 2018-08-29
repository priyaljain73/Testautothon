package utils;

import org.openqa.selenium.WebDriver;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
    public boolean isMobile;

    Do(WebDriver driver, String moviename, String wikirurls)
    {
        this.moviename = moviename;
        this.wikirurls = wikirurls;
        this.driver = driver;
    }


    @Override
    public void run() {

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

    }

    public void doMethods(boolean isMobile, Object classObject, Method... methods)
    {
        this.methods = methods;
        this.classObject = classObject;
        this.isMobile = isMobile;
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
