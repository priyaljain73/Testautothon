package utils;

import configPackage.Config;
import driver.MyChromeDriver;
import driver.MyGridDriver;
import driver.MyMobileDriver;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Map;

public class ThreadInfo {

    static int countmobiledrivers = 0;
    static int countapis = 0;
    ArrayList<Thread> threadlist = new ArrayList<>();
    ArrayList<WebDriver> driverlist = new ArrayList<>();
    ArrayList<String> movielist = new ArrayList<>();
    ArrayList<Do> Do = new ArrayList<>();
    Method[] methods;
    Map<String, String> movieMap;
    Object classObject;


    public ThreadInfo(Map movieMap) {
        this.movieMap = movieMap;
        countmobiledrivers = new Config().getMobileThreadCount();
        countapis = new Config().getHTTPThreadCount();
    }

    public void startThreads() throws Exception {
        for (int i = 0; i < movielist.size(); i++) {
            getThread(movielist.get(i)).start();
        }
    }


    void createThread(String moviename, WebDriver driver, boolean isMobile, boolean isHTTP, boolean isWeb) throws Exception {

        Do dos = new Do(driver, moviename, movieMap.get(moviename));
        dos.doMethods(isWeb, isHTTP, isMobile, classObject, methods);
        threadlist.add(new Thread(dos));
        driverlist.add(driver);
        movielist.add(moviename);
        Do.add(dos);
        dos.threadID = getThread(moviename).getId();
    }

    void reinitThread(String moviename, WebDriver driver, Do dos) {
        dos.doMethods(classObject, methods);
        threadlist.add(new Thread(dos));
    }


    public Thread getThread(String moviename) throws Exception {

        for (int i = 0; i < movielist.size(); i++) {
            if (movielist.get(i).equals(moviename)) {
                return threadlist.get(i);
            }
        }
        System.out.println("Thread not found for movie : " + moviename);
        throw new Exception("Thread not found for movie : " + moviename);
    }

    public Do getDo(String moviename) throws Exception {

        for (int i = 0; i < movielist.size(); i++) {
            if (movielist.get(i).equals(moviename)) {
                return Do.get(i);
            }
        }
        System.out.println("Do not found for movie : " + moviename);
        throw new Exception("Do not found for movie : " + moviename);
    }

    public ArrayList<Do> getDo() {
        return Do;
    }


    public ThreadInfo doMethods(Object classObject, Method... methods) throws Exception {

        this.methods = methods;
        this.classObject = classObject;
        ArrayList<String> movies = new ArrayList();
        movies.addAll(movieMap.keySet());

        if(Config.runmode.equals("api"))
        {
            for (int i = 0; i < movies.size(); i++) {
                createThread(movies.get(i), null, false, true, false);
            }
            return this;
        }
        else if(Config.runmode.equals("hybrid"))
        {
            for (int i = 0; i < movies.size(); i++) {
                if (countmobiledrivers > 0) {
                    createThread(movies.get(i), new MyMobileDriver().newMobileDriver(), true, false, false);
                    countmobiledrivers--;
                }
                else if (countapis > 0) {
                    createThread(movies.get(i), null, false, true, false);
                    countapis--;
                }
                else {
                    createThread(movies.get(i), new MyChromeDriver().newDriver(), false, false, true);
                }
            }
            return this;
        }
        else
        {
            for (int i = 0; i < movies.size(); i++) {
                if (countmobiledrivers > 0) {
                    createThread(movies.get(i), new MyMobileDriver().newMobileDriver(), true, false, false);
                    countmobiledrivers--;
                } else {
                    createThread(movies.get(i), new MyChromeDriver().newDriver(), false, false, true);
                }
            }
            return this;
        }
    }

    public WebDriver getDriver(String moviename) throws Exception {
        for (int i = 0; i < movielist.size(); i++) {
            if (movielist.get(i).equals(moviename)) {
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
        for (int i = 0; i < movies.size(); i++) {
            reinitThread(movies.get(i), getDriver(movies.get(i)), getDo(movies.get(i)));
        }
        return this;
    }

    public void waitForThreadsToComplete() {
        int count = threadlist.size();
        int finished = 0;
        do {
            finished = 0;
            for (int i = 0; i < threadlist.size(); i++) {
                if (!threadlist.get(i).isAlive()) {
                    finished = finished + 1;
                }
            }
        } while (count != finished);
    }

    public void quitAllDrivers() {
        for (int i = 0; i < driverlist.size(); i++) {
            if(driverlist.get(i) != null)
            {
                driverlist.get(i).quit();
            }
        }
    }


}
