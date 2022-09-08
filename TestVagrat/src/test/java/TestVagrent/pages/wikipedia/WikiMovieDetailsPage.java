package TestVagrent.pages.wikipedia;

import TestVagrent.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WikiMovieDetailsPage extends BasePage {

    @FindBy(xpath = "//div[contains(text(), 'Release date')]/parent::th/following-sibling::td//li") private WebElement RELEASE_DATE;
    public WikiMovieDetailsPage(WebDriver driver) {
        super(driver);
    }

    public String getMovieReleaseDate(){
        scrollToElement(RELEASE_DATE);
        return RELEASE_DATE.getText();
    }

}
