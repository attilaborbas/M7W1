package model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class DriverFactory {
    public static WebDriver getDriver(Browser browser) {
        switch (browser) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "/Users/attilaborbas/TestAutoMentoring2016/M7W1/src/main/resources/chromedriver");
                return new ChromeDriver();
            case FIREFOX:
                throw new NotImplementedException();
            case IE:
                throw new NotImplementedException();
            case PHANTOMJS:
                throw new NotImplementedException();
        }
        return new ChromeDriver();
    }
}
