package org.epam.testing;


import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.epam.testing.components.FailureListener;
import org.epam.testing.components.WebDriverFactory;
import org.epam.testing.pageobjects.MainBookingPage;
import org.epam.testing.pageobjects.SearchResults1Page;
import org.epam.testing.testdata.SearchHotelData;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import ru.yandex.qatools.allure.annotations.Step;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by AlexSh on 07.11.2016.
 */

@Listeners({ FailureListener.class })
public class MainBookingPageTest {

    //it is static & public. It is for all. Love it or leave it.
    public static WebDriver myPersonalDriver;
    private MainBookingPage mainBookingPage;
    private SearchResults1Page searchResults1Page;
    private String mainPageUrl;


    /*
    in testng.xml
    f.e. browser: "firefox","chrome","ie", "opera"
    f.e. pathToDriver: "D:\\PersonalDrivers\\geckodriver.exe",
     */

    @BeforeSuite
    @Parameters({"browser", "pathToDriver","loginPageUrl"})
    public void beforeSuite(@Optional("phantom") String browser,
                            @Optional("D:/PersonalDrivers/phantomjs-2.1.1-windows/bin/phantomjs.exe") String pathToDriver,
                            @Optional("https://www.booking.com") String mainPageUrl) {

        myPersonalDriver= new WebDriverFactory().getWebDriver(browser, pathToDriver);

        //At a "very beginning" we open fist page. This is really door to eternity
        //mainBookingPage = PageFactory.initElements(myPersonalDriver, MainBookingPage.class);

        System.out.println(browser + " " + pathToDriver);



        //Set a Russian Language since we are not gangsters we are Russians (c)


    }

    @Step("SEACH HOTEL TEST")
    @Test(dataProviderClass=SearchHotelData.class, dataProvider="dataforsearch")
    public void trySearch(boolean testType, String country, String town) {

        mainBookingPage = PageFactory.initElements(myPersonalDriver, MainBookingPage.class);
        System.out.println("looking for hotel");

        String countryTown = country +" "+town;

        System.out.println(countryTown);

        mainBookingPage.getSearchField().clear();
        mainBookingPage.getSearchField().sendKeys(countryTown);
        mainBookingPage.getSearchButton().click();



//Check for results we are waiting
        if (testType) {

            searchResults1Page = new SearchResults1Page(myPersonalDriver);
            System.out.println(searchResults1Page.getInfoString());


            //Do we have any search results?
            boolean hasSearchResults = searchResults1Page.getHotelsFoundInRegionOrTown() != null;
            boolean doesSearchInfoContain = searchResults1Page.getInfoString().contains(country) ||
                    searchResults1Page.getInfoString().contains(town);


            System.out.println(searchResults1Page.getInfoString().contains(country));
            System.out.println(searchResults1Page.getInfoString().contains(town));
            System.out.println("Найдено: " + doesSearchInfoContain + " Тип теста: " + testType);


            //Did it try to find? It has to be...
            assertTrue(doesSearchInfoContain, "Data is correct or partly correct. There are some search results");
        }
        else {

             boolean hasErrorMessageContain = mainBookingPage.getErrorMessage().contains("начать поиск") ||
                                              mainBookingPage.getErrorMessage().contains("не известно");

             System.out.println(mainBookingPage.getErrorMessage());


             //Error message? It has to be...
             assertTrue( hasErrorMessageContain,"Data is not correct. There are not any search results. But is's OK");
        }


    }

    @AfterTest
    public void returnToMainPage(){
        //mainBookingPage = PageFactory.initElements(myPersonalDriver, MainBookingPage.class);
        //myPersonalDriver.get(mainPageUrl);

    }

    @AfterSuite
    public void afterSuite() {
      /*  //Close the driver
        myPersonalDriver.close();
        myPersonalDriver.quit();*/

    }



}
