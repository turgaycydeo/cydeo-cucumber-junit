package com.cydeo.step_definitions;

import com.cydeo.pages.GoogleSearchPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class GoogleStepDefinitions {

  GoogleSearchPage googleSearchPage= new GoogleSearchPage();

    @When("user types {string} then clicks enter")
    public void user_types_then_clicks_enter(String searchKeyword) {
        googleSearchPage.searchBox.sendKeys(searchKeyword+Keys.ENTER);
    }
    @Then("user sees {string} in the google title")
    public void user_sees_in_the_google_title(String string) {
        String expectedTitle=string+" - Google Search";
        String actualTitle=Driver.getDriver().getTitle();
        //Junit assertion accepts first expected title then actual title and the message comes first
        Assert.assertEquals("Title is not expected",expectedTitle,actualTitle);
    }


    @When("user is on Google search page")
    public void user_is_on_google_search_page() {
        Driver.getDriver().get("https://google.com");
        //Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      googleSearchPage.acceptCookies.click();
    }
    @Then("user should see title is Google")
    public void user_should_see_title_is_google() {

        String expectedTitle="Google";
        String actualTitle=Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);
       // Driver.getDriver().close();

    }


    @When("user types apple then clicks enter")
    public void user_types_apple_then_clicks_enter() {
    googleSearchPage.searchBox.sendKeys("apple"+Keys.ENTER);
    }
    @Then("user sees apple in the google title")
    public void user_sees_apple_in_the_google_title() {
        String expectedTitle="apple - Google Search";
        String actualTitle=Driver.getDriver().getTitle();
        //Junit assertion accepts first expected title then actual title and the message comes first
        Assert.assertEquals("Title is not expected",expectedTitle,actualTitle);

    }

}
