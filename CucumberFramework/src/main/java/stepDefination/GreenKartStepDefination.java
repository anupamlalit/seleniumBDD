package stepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class GreenKartStepDefination {
    WebDriver driver = null;

    @Given("user is on GreenCart Landing Page")
    public void user_is_on_green_cart_landing_page() {
        // Write code here that turns the phrase above into concrete actions
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.setProperty("webdriver.chrome.driver", "/Users/anupamlalit/Downloads/seleniumGrid/chromedriver");
        driver.navigate().to("https://rahulshettyacademy.com/seleniByumPractise/#/");

    }

    @When("when user with search with first {int} character {string} and fetch the exact product")
    public void when_user_with_search_with_first_character_and_fetch_the_exact_product(Integer int1, String string) {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys(string);
        String text = driver.findElement(By.cssSelector("h4.product-name")).getText();
        String[] split = text.split("-");
        String productName = split[0].trim();
        System.out.println(productName +"  is extracted from home page");
    }

    @Then("user search with short name {string} in offer page and verify product should exist")
    public void user_search_with_short_name_in_offer_page_and_verify_product_should_exist(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
