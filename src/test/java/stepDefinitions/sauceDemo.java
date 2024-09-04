package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.en.*;

public class sauceDemo {

    WebDriver driver = null;

    @Given("I am on the login page of Sauce Demo")
    public void user_is_on_instagram_page() throws InterruptedException {
        initializeWebDriver();
        driver.navigate().to("https://www.saucedemo.com/");
        Thread.sleep(5000);
    } 

    @When("I enter {username} and {password}")
    public void user_enters_username_password(String username, String password) throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        Thread.sleep(5000);
    }

    @And("Click on login button")
    public void hits_login_button() throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        Thread.sleep(5000);
    }

    @Then("the page should be redirected to inventory page")
    public void user_should_go_to_respective_page() throws InterruptedException {
        driver.getPageSource().contains("Products");
        Thread.sleep(2000);
    }


//	@Given("User is on google search page")
//	public void user_is_on_google_search_page() throws InterruptedException {
//		initializeWebDriver();
//	    driver.navigate().to("https://google.com");
//	    Thread.sleep(2000);
//	}
//
//	@When("^User enters (.*) in search box of google$")  // parameterization
//	public void user_enters_in_search_box(String query) throws InterruptedException {
//		driver.findElement(By.name("q")).sendKeys(query);
//		Thread.sleep(2000);
//	}
//
//	@And("hits enter button of google")
//	public void enter_button() throws InterruptedException {
//		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//	}
//
//	@Then("User should go to respective page of google")
//	public void user_should_go_respective_page() throws InterruptedException {
//		driver.getPageSource().contains("Online Courses");
//		Thread.sleep(2000);
//	}

    @After
    public void tearDown() {
        if (driver != null) {
        	driver.close();
            driver.quit();
        }
    }

    private void initializeWebDriver() throws InterruptedException {
        if (driver == null) {
        	String projectPath = System.getProperty("user.dir");
           	System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver.exe");
           	  driver = new ChromeDriver();
//            ChromeOptions options = new ChromeOptions();      This 3 lines of code will help run test without display
//            options.addArguments("--headless");
//            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            Thread.sleep(2000);
        }
    }
}
