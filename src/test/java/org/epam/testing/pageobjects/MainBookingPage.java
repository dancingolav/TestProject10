package org.epam.testing.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.concurrent.TimeUnit;

/**
 * Created by AlexSh on 07.11.2016.
 */
public class MainBookingPage {

    private String mainBookingPageUrl = "http://www.booking.com";

    private WebDriver driverHere;

    @FindBy(xpath="//input[@id='ss'']")
    private WebElement searchField;

    @FindBy(xpath="//button[@class='sb-searchbox_button '][@type='submit']")
    private WebElement searchButton;

    @FindBy(xpath="*//li[@class=\'user_center_option uc_language js-uc-language \']/a[@id=\'b_tt_holder_2\']'")
    private WebElement changeLanguageMenu;

    @FindBy(xpath="*//span[@class='flag_16 sflag slang-ru']")
    private WebElement russianLanguageOption;

    @FindBy(xpath="//div[@class='sb-searchbox__error -visible'][@data-error-id='search-string-empty']")
    private WebElement searchStringEmpty;





    //Two constructors
    public MainBookingPage( WebDriver driver ) {
        this.driverHere = driver;
        this.mainBookingPageUrl = "http://www.booking.com";
    }
    public MainBookingPage ( WebDriver driver, String pageUrl) {
        this.driverHere = driver;
        this.mainBookingPageUrl = pageUrl;
    };



    public void open() {

        driverHere.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driverHere.get(mainBookingPageUrl);
        driverHere.manage().window().maximize();
    }

    public void open(String strUrl) {

        driverHere.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driverHere.get(strUrl);
        driverHere.manage().window().maximize();
    }


    public void close () {
        driverHere.close();
    }

    public WebElement getSearchField() {
        return searchField;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public  WebElement getChangeLanguageMenu()  { return changeLanguageMenu; }

    public WebElement getRussianLanguageOption() { return russianLanguageOption; }

    public WebElement getSearchStringEmpty() {return searchStringEmpty;}

    public SearchResults1Page getSearchResults1Page(WebDriver webDriver){ return new SearchResults1Page(webDriver);}


}
