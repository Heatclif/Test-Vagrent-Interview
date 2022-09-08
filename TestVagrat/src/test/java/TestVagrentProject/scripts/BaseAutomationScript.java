package TestVagrentProject.scripts;

import TestVagrentProject.utilities.DataStorage;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class BaseAutomationScript {

    /***
     * This page is used as a base design for all automation classes.
     */
    public static WebDriver driver;
    public static DataStorage dataStorage = DataStorage.getInstance();

    public BaseAutomationScript() {
        System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
    }

    public static void timeoutManager() {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(20000));
    }
}
