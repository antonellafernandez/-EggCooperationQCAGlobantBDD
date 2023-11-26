package tests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.assertTrue;

public class StepDefinition {
    private WebDriver driver;

    @Given("I am on {string}")
    public void i_am_on(String url) {
        String path = System.getProperty("user.dir");
        System.out.println(path);
        
        System.setProperty("webdriver.chrome.driver", path + "\\drivers\\chromedriver.exe");
        
        driver = new ChromeDriver();
        
        driver.get(url);
    }

    @When("I navigate to the login page")
    public void i_navigate_to_the_login_page() {
        WebElement login = driver.findElement(By.id("login2"));
        login.click();
    }

    @When("I provide valid {string} and {string}")
    public void i_provide_valid_credentials(String username, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        
        WebElement userInput = driver.findElement(By.id("loginusername"));
        wait.until(ExpectedConditions.elementToBeClickable(userInput));
        userInput.sendKeys(username);
        
        WebElement passInput = driver.findElement(By.id("loginpassword"));
        wait.until(ExpectedConditions.elementToBeClickable(passInput));
        passInput.sendKeys(password);
    }
    
    @When ("I complete the login process")
    public void i_complete_the_login_process() {
        WebElement submit = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/button[2]"));
        submit.click();
    }
    
    @Then("I should be logged in successfully as {string}")
    public void i_should_be_logged_in_successfully(String username) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement welcome = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
        
        assertTrue(welcome.isDisplayed(), "The Login has been unsuccessful");
    }
}