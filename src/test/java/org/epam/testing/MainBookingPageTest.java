package org.epam.testing;

import org.epam.testing.components.FailureListener;
import org.epam.testing.components.WebDriverFactory;
import org.epam.testing.pageobjects.MainBookingPage;
import org.epam.testing.pageobjects.SearchResults1Page;
import org.epam.testing.testdata.SearchHotelData;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import ru.yandex.qatools.allure.annotations.Step;

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


    /*
    in testng.xml
    f.e. browser: "firefox","chrome","ie", "opera"
    f.e. pathToDriver: "D:\\PersonalDrivers\\geckodriver.exe",
     */

    @BeforeSuite
    @Parameters({"browser", "pathToDriver","loginPageUrl"})
    public void beforeSuite(@Optional("phantom") String browser,
                            @Optional("D:/PersonalDrivers/phantomjs-2.1.1-windows/bin/phantomjs.exe") String pathToDriver,
                            @Optional("http://www.booking.com") String loginPageUrl) {

        myPersonalDriver= new WebDriverFactory().getWebDriver(browser, pathToDriver);

        //At a "very beginning" we open fist page. This is really door to eternity
        mainBookingPage = new MainBookingPage(myPersonalDriver);
        mainBookingPage.open(loginPageUrl);

        System.out.println(browser + " " + pathToDriver);

        //At a "very beginning" we open fist page. This is really door to eternity

        mainBookingPage = new MainBookingPage(myPersonalDriver);
        mainBookingPage.open();

        //Set a Russian Language since we are not gangsters we are Russians (c)


    }



    @Step("SEACH HOTEL TEST")
    @Test(dataProviderClass=SearchHotelData.class, dataProvider="dataforsearch")
    public void tryLogin(boolean testType, String country, String town) {
        System.out.println("search hotel");

        String countryTown = country +" "+town;

        mainBookingPage.getSearchField().sendKeys(countryTown);
        mainBookingPage.getSearchButton().click();
        searchResults1Page = new SearchResults1Page(myPersonalDriver);

 /*
        //Check for results we are waiting
        if (! testType)
            //Has been smth found? It has to be...


            assertTrue();
        else {
            //Error message? It has to be...
            assertTrue();
        }
*/
    }


    @AfterSuite
    public void afterSuite() {
        //Close the driver
        myPersonalDriver.close();
        myPersonalDriver.quit();

    }



}
