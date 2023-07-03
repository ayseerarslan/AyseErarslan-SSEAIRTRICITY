package com.sse.step_defs;

import com.sse.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class Hooks {

    @Before
    public void setupMethod(){
        System.out.println("--> @Before: RUNNING BEFORE EACH SCENARIO");
        Driver.getDriver().get("https://www.citizensadvice.org.uk/consumer/energy/energy-supply/get-help-paying-your-bills/check-how-much-your-electrical-appliances-cost-to-use/");

    }

    @After
    public void tearDownMethod(Scenario scenario){

        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        System.out.println("--> @After: RUNNING AFTER EACH SCENARIO");
        //Driver.closeDriver();
    }

}
