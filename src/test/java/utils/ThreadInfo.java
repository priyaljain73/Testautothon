package utils;

import Driver.MyChromeDriver;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Map;

public class ThreadInfo {

    ArrayList<Thread> threadlist = new ArrayList<>();
    ArrayList<WebDriver> driverlist = new ArrayList<>();
    ArrayList<String> movielist  = new ArrayList<>();
    ArrayList<Do> Do  = new ArrayList<>();
    Method[] methods;
    Map<String, String> movieMap;
    Object classObject;


    public ThreadInfo(Map movieMap)
    {
        this.movieMap = movieMap;
    }

    public void startThreads() throws Exception {
        for(int i = 0; i  < movielist.size(); i++)
        {
            getThread(movielist.get(i)).start();
        }
    }


    void createThread(String moviename, WebDriver driver)
    {
        Do dos = new Do(driver);
        dos.doMethods(classObject, methods);
        threadlist.add(new Thread(dos));
        driverlist.add(driver);
        movielist.add(moviename);
        Do.add(dos);
    }

    void reinitThread(String moviename, WebDriver driver, Do dos)
    {
        dos.doMethods(classObject, methods);
        threadlist.add(new Thread(dos));
    }


    public Thread getThread(String moviename) throws Exception {

        for(int i = 0; i < movielist.size(); i++)
        {
            if(movielist.equals(moviename)) {
                return threadlist.get(i);
            }
        }
        System.out.println("Thread not found for movie : " + moviename);
        throw new Exception("Thread not found for movie : " + moviename);
    }

    public Do getDo(String moviename) throws Exception {

        for(int i = 0; i < movielist.size(); i++)
        {
            if(movielist.equals(moviename)) {
                return Do.get(i);
            }
        }
        System.out.println("Do not found for movie : " + moviename);
        throw new Exception("Do not found for movie : " + moviename);
    }

    public ThreadInfo doMethods(Object classObject, Method... methods)
    {
        this.methods = methods;
        this.classObject = classObject;
        ArrayList<String> movies = new ArrayList();
        movies.addAll(movieMap.keySet());
        for(int i = 0; i  < movies.size(); i++)
        {
            createThread(movies.get(i), new MyChromeDriver().newDriver());
        }
        return this;
    }

    public WebDriver getDriver(String moviename) throws Exception {
        for(int i = 0; i < movielist.size(); i++)
        {
            if(movielist.equals(moviename)) {
                return Do.get(i).getDriver();
            }
        }
        System.out.println("Driver not found for movie : " + moviename);
        throw new Exception("Driver not found for movie : " + moviename);
    }

    public ThreadInfo setNewMethods(Object classObject, Method... methods) throws Exception {
        threadlist = new ArrayList<>();
        this.methods = methods;
        this.classObject = classObject;
        ArrayList<String> movies = new ArrayList();
        movies.addAll(movieMap.keySet());
        for(int i = 0; i  < movies.size(); i++)
        {
            reinitThread(movies.get(i), getDriver(movies.get(i)), getDo(movies.get(i)));
        }
        return this;
    }
}
