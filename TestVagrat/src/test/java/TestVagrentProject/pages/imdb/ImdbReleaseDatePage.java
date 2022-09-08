package TestVagrentProject.pages.imdb;

import TestVagrentProject.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static java.lang.String.format;

public class ImdbReleaseDatePage extends BasePage {

    public ImdbReleaseDatePage(WebDriver driver) {
        super(driver);
    }
    private String COUNTY_RELEASE_DATE = "//a[contains(text(), '%s')]/parent::td/following-sibling::td";

    public ImdbReleaseDatePage getReleaseDate(String country) {
        String releaseDate = driver.findElement(By.xpath(format(COUNTY_RELEASE_DATE, country))).getText();
        dataStorage.rememberData("ImdbReleaseDate", releaseDate);
        return this;
    }
}
