package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.TestContextSetup;

import java.util.Iterator;
import java.util.Set;

public class OfferPageStepDefination {
    TestContextSetup testContextSetup;
    String offerPageProductName = "";

    public OfferPageStepDefination(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Then("user search with short name {string} in offer page")
    public void user_search_with_short_name_in_offer_page(String string) throws InterruptedException {
        testContextSetup.driver.findElement(By.linkText("Top Deals")).click();
        Set<String> windowHandles = testContextSetup.driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();

        String ParentWindow = iterator.next();
        String childWindow = iterator.next();

        testContextSetup.driver.switchTo().window(childWindow);

        testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(string);
        Thread.sleep(2000);
        offerPageProductName = testContextSetup.driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();

    }

    @And("validate product name in offer page matches with landing page")
    public void validate_product_name_in_offer_page_matches_with_landing_page() {

        Assert.assertEquals(offerPageProductName, testContextSetup.landingPageProductName);

    }
}
