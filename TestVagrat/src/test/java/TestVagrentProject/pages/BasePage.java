package TestVagrentProject.pages;


import TestVagrentProject.utilities.DataStorage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage{
    /***
     * This page is used as a base design for other POM classes
     */
    public WebDriver driver;
    public static DataStorage dataStorage = DataStorage.getInstance();
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void scrollToElement(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
