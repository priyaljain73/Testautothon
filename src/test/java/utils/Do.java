package utils;

import org.openqa.selenium.WebDriver;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Do implements Runnable {

    WebDriver driver;
    Method[] methods;
    Object classObject;


    Do(WebDriver driver)
    {
        this.driver = driver;
    }


    @Override
    public void run() {

        for(int i = 0; i < methods.length; i++)
        {
            try {
                methods[i].invoke(classObject, null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

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
