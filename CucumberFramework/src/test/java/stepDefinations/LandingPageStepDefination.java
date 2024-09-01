package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.TestContextSetup;

import java.time.Duration;

public class LandingPageStepDefination {
    TestContextSetup testContextSetup ;


    public LandingPageStepDefination(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Given("user is on GreenCart Landing Page")
    public void user_is_on_green_cart_landing_page() {
        // Write code here that turns the phrase above into concrete actions
        testContextSetup.driver = new ChromeDriver(); // driver gets the life here

        testContextSetup.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.setProperty("webdriver.chrome.driver", "/Users/anupamlalit/Downloads/seleniumGrid/chromedriver");
        testContextSetup.driver.navigate().to("https://rahulshettyacademy.com/seleniumPractise/#/");

    }

    @When("when user with search with first 3 character {string} and fetch the exact product")
    public void when_user_with_search_with_first_character_and_fetch_the_exact_product(String string) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(string);
        Thread.sleep(2000);
        String text = testContextSetup.driver.findElement(By.cssSelector("h4.product-name")).getText();
        String[] split = text.split("-");
        String landingPageProductName = split[0].trim();
        testContextSetup.landingPageProductName = landingPageProductName;
        System.out.println(landingPageProductName + "  is extracted from home page");
    }


}


