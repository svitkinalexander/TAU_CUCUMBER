import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class PageChoice {

    private WebDriver driver;
    private String url = "https://opensource-demo.orangehrmlive.com/";

    @Before() // Hooks
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Given("I am in the Orange HRM dashboard page")
    public void i_am_in_the_orange_hrm_dashboard_page() {
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.id("btnLogin")).click();
    }

    @When("I click {string}")
    public void i_click(String pageLink) {
        driver.findElement(By.linkText(pageLink)).click();
    }

    @Then("I get {string} page name")
    public void i_get_page_name(String pageName) {
        String pageText = driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals("Page name is wrong", pageName, pageText);
    }

    @After()
    public void tearDown() {
        driver.quit();
    }
}
