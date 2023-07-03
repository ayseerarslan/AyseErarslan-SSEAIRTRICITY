package com.sse.pages;

import com.sse.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Calculator_page {

    public Calculator_page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id=\"RootPlaceHolder_RootPlaceHolder_SubHeading\"]/span/a")
    public WebElement appliesToButton;

    @FindBy(xpath = "//*[@id=\"appliance\"]")
    public WebElement applianceDropdown;

    @FindBy(xpath = "//*[@id=\"hours\"]")
    public WebElement hours;

    @FindBy(xpath = "//*[@id=\"mins\"]")
    public WebElement minutes;

    @FindBy(xpath = "//*[@id=\"frequency\"]")
    public WebElement frequencyDropdown;

    @FindBy(xpath = "//*[@id=\"kwhcost\"]")
    public WebElement kWh;

    @FindBy(xpath = "//*[@id=\"submit\"]")
    public WebElement addToList;

    @FindBy(xpath = "//*[@id=\"cads-main-content\"]//div[2]/p[1]")
    public WebElement NorthernIrelandMessage;


    /**
     * This method used for select the country name
     * @param countryName String
     */
    public void selectCountry(String countryName){
        appliesToButton.click();
        WebElement element = Driver.getDriver().findElement(By.xpath("//a[.='"+countryName+"']"));
        element.click();
    }


    /**
     * This method is used for adding different appliances, usage time and average rate
     * @param applianceIndex integer
     * @param hr integer
     * @param min integer
     * @param averageRate integer
     */
    public void addAppliance(int applianceIndex, int hr, int min, int averageRate) {

        Select applianceSelectDropdown = new Select(applianceDropdown);
        Select frequencySelectDropdown = new Select(frequencyDropdown);

        applianceSelectDropdown.selectByIndex(applianceIndex);
        hours.sendKeys(Integer.toString(hr));
        minutes.sendKeys(Integer.toString(min));
        frequencySelectDropdown.selectByVisibleText("day");
        kWh.sendKeys(Integer.toString(averageRate));
        addToList.click();

    }


    /**
     * This is overloaded method of addAppliance
     * @param appIndex integer
     * @param hr integer
     * @param min integer
     */
    public void addAppliance(int appIndex, int hr, int min) {

        Select applianceSelectDropdown = new Select(applianceDropdown);
        Select frequencySelectDropdown = new Select(frequencyDropdown);

        hours.clear();
        minutes.clear();

        applianceSelectDropdown.selectByIndex(appIndex);
        hours.sendKeys(Integer.toString(hr));
        minutes.sendKeys(Integer.toString(min));
        frequencySelectDropdown.selectByVisibleText("day");

        addToList.click();

    }


    /**
     * This method is used for getting result table for usage costs by day, week, month, year
     * @param timeRange String
     * @return List<WebElement>
     */
    public List<WebElement> getResultTable(String timeRange){

        List<WebElement> elements = Driver.getDriver().findElements(By.xpath("//td[.='"+timeRange+"']/following-sibling::td"));

        return elements;
    }


    /**
     * This method is used for adding appliance names to result table
     * @param index integer
     * @return String
     */
    public String applianceName (int index){

        Select applianceSelectDropdown = new Select(applianceDropdown);

        return applianceSelectDropdown.getOptions().get(index).getText();
    }

}

