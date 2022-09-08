package TestVagrent.scripts;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class BaseAutomationScript {
    public static WebDriver driver;

    public BaseAutomationScript() {
        System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
    }

    public static void timeoutManager() {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(20000));
    }
}
