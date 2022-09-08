package TestVagrentProject.pages.imdb;

import TestVagrentProject.pages.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static java.lang.String.format;

public class ImdbMovieDetailsPage extends BasePage {
    public ImdbMovieDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(text(), 'Release date')]")
    private WebElement RELEASE_DATE;
    @FindBy(xpath = "//section[@data-testid='Details']")
    private WebElement DETAILS_SECTION;
    @FindBy(xpath = "//span[contains(text(), 'Country of origin')]/following-sibling::div//a")
    private WebElement COUNTRY_ORIGIN;
    public ImdbMovieDetailsPage getOriginCountry() {
        scrollToElement(DETAILS_SECTION);
        String originCountry = (COUNTRY_ORIGIN).getText();
        dataStorage.rememberData("ImdbOriginCountry", originCountry);
        return this;
    }

    public ImdbReleaseDatePage goToReleaseDatePage() {
        scrollToElement(DETAILS_SECTION);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", RELEASE_DATE);
        return new ImdbReleaseDatePage(driver);
    }
}
