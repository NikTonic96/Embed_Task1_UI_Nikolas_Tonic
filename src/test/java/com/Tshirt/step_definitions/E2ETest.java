package com.Tshirt.step_definitions;

import com.Tshirt.pages.TShirtWebPage;
import com.Tshirt.utility.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class E2ETest {


    TShirtWebPage webShopPage = new TShirtWebPage();

    @Given("the user is on the web page")
    public void theUserIsOnTheWebPage() {
        webShopPage.goToWebPage();
    }

    @And("the user selects size {string}")
    public void the_user_selects_size_option(String size) {
        webShopPage.getSize(size);
    }

    @And("the user adds the item into the cart")
    public void the_user_adds_the_item_into_the_cart() {
        webShopPage.secondListedShirt.click();
    }

    @When("the user clicks the checkout button")
    public void the_user_clicks_the_checkout_button() {
        webShopPage.checkoutButton.click();
    }

    @And("the user sees the notification")
    public void the_user_sees_the_notification() {
        String actualCost = Driver.getDriver().switchTo().alert().getText();
        System.out.println("actualCost.isEmpty() = " + actualCost.isEmpty());
    }

    @Then("the user clicks the ok button")
    public void the_user_clicks_the_ok_button() {
        Driver.getDriver().switchTo().alert().accept();
    }

    @And("the user click the open cart button")
    public void theUserClickTheOpenCartButton() {
        webShopPage.openCartBtn.click();
    }

    @And("the user sees the error message in the notification")
    public void theUserSeesTheErrorMessageInTheNotification() {
        String actualErrorMsg = Driver.getDriver().switchTo().alert().getText();
        String expectedErrorMsg = "Add some product in the cart!";
        Assert.assertEquals(expectedErrorMsg, actualErrorMsg);
    }

    @And("the user increases the quantity by 1")
    public void theUserIncreasesTheQuantityBy() {
        webShopPage.increaseQuantityBtn.click();
        String expected = "2";
        String actual = webShopPage.quantityInfo.getText();

        Assert.assertTrue(actual.contains(expected));

    }
}
