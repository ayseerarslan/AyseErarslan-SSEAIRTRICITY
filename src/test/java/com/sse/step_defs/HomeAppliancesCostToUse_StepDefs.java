package com.sse.step_defs;

import com.sse.pages.Calculator_page;
import com.sse.utilities.BrowserUtils;
import com.sse.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomeAppliancesCostToUse_StepDefs {

    int averageRate = 0;

    Calculator_page calculatorPage = new Calculator_page();

    @Given("I am a resident from {string}")
    public void i_am_a_resident_from(String countryName) {

        calculatorPage.selectCountry(countryName);

        averageRate = BrowserUtils.averageRate(countryName);
    }

    @When("I add the list appliances \\(add at least {int} appliances) and its average usage and average rate")
    public void iAddTheListAppliancesAddAtLeastAppliancesAndItsAverageUsageAndAverageRate(int applianceCount) {

        calculatorPage.addAppliance(1, 1,30,averageRate);

        for (int i = 2; i <= applianceCount; i++) {
            calculatorPage.addAppliance(i, 2,30);
        }
    }

    @Then("I should get the results table with daily, weekly, monthly, and yearly cost.")
    public void i_should_get_the_results_table_with_daily_weekly_monthly_and_yearly_cost() {
        var daily = calculatorPage.getResultTable("Daily");
        var weekly = calculatorPage.getResultTable("Weekly");
        var monthly = calculatorPage.getResultTable("Monthly");
        var yearly = calculatorPage.getResultTable("Yearly");

        System.out.println("\n***************************************");
        for (int i = 0; i < daily.size(); i++) {
            System.out.println("Appliance name\t = \t" + calculatorPage.applianceName(i + 1));
            System.out.println("Daily\t = \t" + daily.get(i).getText());
            System.out.println("Weekly\t = \t" + weekly.get(i).getText());
            System.out.println("Monthly\t = \t" + monthly.get(i).getText());
            System.out.println("Yearly\t = \t" + yearly.get(i).getText());
            System.out.println("\n***************************************");

        }
    }

    @When("I select This advice applies to {string}")
    public void iSelectThisAdviceAppliesTo(String countryName) {

        String actual = Driver.getDriver().getTitle();
        Assert.assertTrue(actual.contains(countryName));
    }

    @Then("I should get the results message as {string}")
    public void iShouldGetTheResultsMessageAs(String message) {

        String actual = calculatorPage.NorthernIrelandMessage.getText();
        Assert.assertTrue(actual.contains(message));

    }

}
