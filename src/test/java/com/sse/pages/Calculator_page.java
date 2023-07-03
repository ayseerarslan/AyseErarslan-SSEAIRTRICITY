package com.sse.pages;

import com.sse.utilities.BrowserUtils;
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

    public List<WebElement> method(String timeRange){

        List<WebElement> elements = Driver.getDriver().findElements(By.xpath("//td[.='"+timeRange+"']/following-sibling::td"));

        return elements;
    }

    public String applianceName (int index){

        Select applianceSelectDropdown = new Select(applianceDropdown);

        return applianceSelectDropdown.getOptions().get(index).getText();
    }


}

