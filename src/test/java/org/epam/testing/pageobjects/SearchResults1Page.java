package org.epam.testing.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

/**
 * Created by AlexSh on 07.11.2016.
 */
public class SearchResults1Page {

    private String mainResults1PageUrl;

    @FindBy(xpath="//h1/span[@class='sr-dest__type'][contains(.,'Регион')]")
    private WebElement hotelsFoundInRegion;

    @FindBy(xpath="//h1/span[@class='sr-dest__type'][contains(.,'Город')]")
    private WebElement hotelsFoundInTown;



    private WebDriver driverHere;


    public SearchResults1Page(WebDriver driver ) {
        this.driverHere = driver;
        this.mainResults1PageUrl = driver.getCurrentUrl();
    }


    public void open() {

        driverHere.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driverHere.manage().window().maximize();
    }

    public WebElement getHotelsFoundInRegion() { return hotelsFoundInRegion;}
    public WebElement getHotelsFoundInTown() { return hotelsFoundInTown;}

    public String getInfoString () {
        if (hotelsFoundInRegion != null) return hotelsFoundInRegion.getText();
        if (hotelsFoundInTown != null) return hotelsFoundInTown.getText();

        return "this is a wrong page";

    }

    public void close () {
        driverHere.close();
    }

}
