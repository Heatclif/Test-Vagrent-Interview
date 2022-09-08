package TestVagrent.pages.imdb;

import TestVagrent.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ImdbHomePage extends BasePage {
    public ImdbHomePage(WebDriver driver) {
        super(driver);
        driver.get("https://www.imdb.com/");
    }

    @FindBy(name = "q")
    private WebElement SEARCH_BAR;
    @FindBy(id = "suggestion-search-button")
    private WebElement SEARCH_BUTTON;

    public ImdbSearchResultPage searchMovie(String movieStr) {
        SEARCH_BAR.sendKeys(movieStr);
        SEARCH_BUTTON.click();
        return new ImdbSearchResultPage(this.driver);
    }
}
