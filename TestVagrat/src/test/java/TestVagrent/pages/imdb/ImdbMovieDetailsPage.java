package TestVagrent.pages.imdb;

import TestVagrent.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.String.format;

public class ImdbMovieDetailsPage extends BasePage {
    public ImdbMovieDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//section[@data-testid='Details']")
    private WebElement DETAILS_SECTION;
    @FindBy(xpath = "//a[contains(text(), 'Release date')]")
    private WebElement RELEASE_DATE;
    private String COUNTY_RELEASE_DATE = "//a[contains(text(), '%s')]/parent::td/following-sibling::td";

    public String getReleaseDate(String country) {
        scrollToElement(DETAILS_SECTION);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", RELEASE_DATE);
        return driver.findElement(By.xpath(format(COUNTY_RELEASE_DATE, country))).getText();
    }
}
