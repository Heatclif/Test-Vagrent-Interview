package TestVagrentProject.pages.imdb;

import TestVagrentProject.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static java.lang.String.format;

public class ImdbSearchResultPage extends BasePage {
    ImdbSearchResultPage(WebDriver driver) { super(driver); }
    private String MOVIE_TITLE = "//h3[contains(text(), 'Titles')]/following-sibling::table/descendant::a[contains(text(), '%s')]";

    public ImdbMovieDetailsPage selectMovieFromList(String movieStr) {
        driver.findElement(By.xpath(format(MOVIE_TITLE, movieStr))).click();
        return new ImdbMovieDetailsPage(this.driver);
    }
}
