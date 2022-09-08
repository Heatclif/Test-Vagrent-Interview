package TestVagrentProject.scripts.automationScripts;

import TestVagrentProject.pages.imdb.ImdbHomePage;
import TestVagrentProject.pages.wikipedia.WikiHomePage;
import TestVagrentProject.scripts.BaseAutomationScript;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import static java.lang.String.format;

public class ValidateMovieDataInWikiAndImdb extends BaseAutomationScript {
    @DataProvider
    private static Object[][] SearchData() {
           return new Object[][] {
                   {"Pushpa: The Rise"},
                   {"3 Idiots"},
                   {"Sholay"}
           };
    }
    @BeforeClass
    public static void setup() {
        driver = new ChromeDriver();
        timeoutManager();
        driver.manage().window().maximize();
    }

    @Test(dataProvider = "SearchData")
    public static void validateMovieReleaseDate(String movie) {
        getDataFromWikipedia(movie);
        getDataFromImdb(movie);
        compareData();
    }

    public static void getDataFromWikipedia(String movie) {
        new WikiHomePage(driver)
                .searchString(movie)
                .getMovieReleaseDate()
                .getMovieOrigin();
    }

    public static void getDataFromImdb(String movie) {
        new ImdbHomePage(driver)
                .searchMovie(movie)
                .selectMovieFromList(movie)
                .getOriginCountry()
                .goToReleaseDatePage()
                .getReleaseDate("India");
    }

    public static void compareData() {
        String wikiOriginCountry = dataStorage.getData("WikiOriginCountry");
        String imdbOriginCountry = dataStorage.getData("ImdbOriginCountry");
        String wikiReleaseDate = dataStorage.getData("WikiReleaseDate");
        String imdbReleaseDate = dataStorage.getData("ImdbReleaseDate");

        Assert.assertTrue(wikiOriginCountry.equals(imdbOriginCountry));
        Assert.assertTrue(wikiReleaseDate.contains(imdbReleaseDate) || imdbReleaseDate.contains(wikiReleaseDate));

        System.out.println("wikiOriginCountry: " + wikiOriginCountry);
        System.out.println("imdbOriginCountry: " + imdbOriginCountry);
        System.out.println("wikiReleaseDate: " + wikiReleaseDate);
        System.out.println("imdbReleaseDate: " + imdbReleaseDate);
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }
}
