package org.epam.testing.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by AlexSh on 07.11.2016.
 */
public class SearchResults1Page {

    private String mainResults1PageUrl;

    @FindBy(xpath="*//h1[contains(normalize-space(.),'найден') and contains(normalize-space(.),'вариант')]")
    private WebElement hotelsFoundInRegionOrTown;


    private WebDriver driverHere;


    public SearchResults1Page(WebDriver driver ) {
        this.driverHere = driver;
        PageFactory.initElements(this.driverHere, this);
        this.mainResults1PageUrl = driver.getCurrentUrl();
        System.out.println(this.mainResults1PageUrl);
        driverHere.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driverHere.manage().window().maximize();

    }



    public WebElement getHotelsFoundInRegionOrTown() { return hotelsFoundInRegionOrTown;}


    public String getInfoString () {
        if (hotelsFoundInRegionOrTown != null) return hotelsFoundInRegionOrTown.getText();
           return " ";

    }

    public void close () {
        driverHere.close();
    }

}
