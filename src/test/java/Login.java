import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

    private WebDriver driver;
    private String url = "https://opensource-demo.orangehrmlive.com/";

    @Given("I am in the Orange HRM main page")
    public void i_am_in_the_orange_hrm_main_page() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

    @When("I enter valid credentials")
    public void i_enter_valid_credentials() {
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.id("btnLogin")).click();
    }

    @Then("I get to the Dashboard page")
    public void i_get_to_the_dashboard_page() {
        String pageName = driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals("Page name is wrong", "Dashboard", pageName);
        driver.quit();
    }
}
