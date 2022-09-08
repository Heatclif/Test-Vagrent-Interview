package TestVagrentProject.pages.wikipedia;

import TestVagrentProject.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WikiMovieDetailsPage extends BasePage {

    @FindBy(xpath = "//div[contains(text(), 'Release date')]/parent::th/following-sibling::td//li")
    private WebElement RELEASE_DATE;
    @FindBy(xpath = "//th[contains(text(), 'Country')]/following-sibling::td")
    private WebElement ORIGIN_COUNTRY;

    public WikiMovieDetailsPage(WebDriver driver) {
        super(driver);
    }

    public WikiMovieDetailsPage getMovieReleaseDate(){
        scrollToElement(RELEASE_DATE);
        String releaseDate = RELEASE_DATE.getText();
        dataStorage.rememberData("WikiReleaseDate", releaseDate);
        return this;
    }

    public WikiMovieDetailsPage getMovieOrigin(){
        scrollToElement(ORIGIN_COUNTRY);
        String originCountry = ORIGIN_COUNTRY.getText();
        dataStorage.rememberData("WikiOriginCountry", originCountry);
        return this;
    }

}
