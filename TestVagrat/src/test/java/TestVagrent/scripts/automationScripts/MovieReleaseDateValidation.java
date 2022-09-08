package TestVagrent.scripts.automationScripts;

import TestVagrent.pages.imdb.ImdbHomePage;
import TestVagrent.pages.wikipedia.WikiHomePage;
import TestVagrent.scripts.BaseAutomationScript;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import static java.lang.String.format;

public class MovieReleaseDateValidation extends BaseAutomationScript {
    private static String WikiReleaseDate;
    private static String ImdbReleaseDate;

    @DataProvider
    private static Object[][] SearchData() {
           return new Object[][] {
                   {"Pushpa: The Rise"},
                   {"3 Idiots"},
                   {"Sholay"}
           };
    }
    @BeforeClass
    public static void setupDriver() {
        driver = new ChromeDriver();
        timeoutManager();
        driver.manage().window().maximize();
    }

    @Test(dataProvider = "SearchData")
    public static void validateMovieReleaseDate(String movie) {
        getDateFromWikipedia(movie);
        getDateFromImdb(movie);
        matchDate();
    }

    public static void getDateFromWikipedia(String movie) {
        WikiReleaseDate = new WikiHomePage(driver)
                .searchString(movie)
                .getMovieReleaseDate();
    }

    public static void getDateFromImdb(String movie) {
        ImdbReleaseDate = new ImdbHomePage(driver)
                .searchMovie(movie)
                .selectMovieFromList(movie)
                .getReleaseDate("India");
    }

    public static void matchDate() {
        Boolean isDateMatching = WikiReleaseDate.contains(ImdbReleaseDate) || ImdbReleaseDate.contains(WikiReleaseDate) ? true : false;
        Assert.assertTrue(isDateMatching, format("WikiReleaseDate: %s\nImdbReleaseDate: %s", WikiReleaseDate, ImdbReleaseDate));
    }

    @AfterClass
    public static void closeDriver() {
        driver.close();
    }
}
