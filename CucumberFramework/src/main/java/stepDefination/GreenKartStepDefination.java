package stepDefination;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class GreenKartStepDefination {
    WebDriver driver = null;
    String offerPageProductName = "";
    String landingPageProductName = "";

    @Given("user is on GreenCart Landing Page")
    public void user_is_on_green_cart_landing_page() {
        // Write code here that turns the phrase above into concrete actions
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.setProperty("webdriver.chrome.driver", "/Users/anupamlalit/Downloads/seleniumGrid/chromedriver");
        driver.navigate().to("https://rahulshettyacademy.com/seleniumPractise/#/");

    }

    @When("when user with search with first {int} character {string} and fetch the exact product")
    public void when_user_with_search_with_first_character_and_fetch_the_exact_product(Integer int1, String string) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys(string);
        Thread.sleep(2000);
        String text = driver.findElement(By.cssSelector("h4.product-name")).getText();
        String[] split = text.split("-");
        landingPageProductName = split[0].trim();
        System.out.println(landingPageProductName + "  is extracted from home page");
    }

    @Then("user search with short name {string} in offer page")
    public void user_search_with_short_name_in_offer_page(String string) throws InterruptedException {
        driver.findElement(By.linkText("Top Deals")).click();
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();

        String ParentWindow = iterator.next();
        String childWindow = iterator.next();

        driver.switchTo().window(childWindow);

        driver.findElement(By.xpath("//input[@type='search']")).sendKeys(string);
        Thread.sleep(2000);
        offerPageProductName = driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();

    }

    @And("validate product name in offer page matches with landing page")
    public void validate_product_name_in_offer_page_matches_with_landing_page() {

        Assert.assertEquals(offerPageProductName, landingPageProductName);

    }

}
