package TestVagrentProject.pages.wikipedia;

import TestVagrentProject.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WikiHomePage extends BasePage {
    public WikiHomePage(WebDriver driver) {
        super(driver);
        driver.get("https://www.wikipedia.org/");
    }

    @FindBy(id = "searchInput")
    private WebElement SEARCH_BAR;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement SEARCH_BUTTON;

    public WikiMovieDetailsPage searchString(String str) {
        SEARCH_BAR.sendKeys(str);
        SEARCH_BUTTON.click();
        return new WikiMovieDetailsPage(this.driver);
    }
}
