package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.homePageObject;

public class selectproductstepdefinitions {
    // Below is the code that launches the magento Homepage It consists of the magento url that takes us straight to the website.
    //the is also the code to the path were my fire fox is located


    WebDriver driver;
    private By shirtSelectLocater = By.linkText("Proteus Fitness Jackshirt");

    @Given("that the customer is on the Home page")
    public void that_the_customer_is_on_the_Home_page() {
        // Write code here that turns the phrase above into concrete actions


        System.setProperty("webdriver.gecko.driver",
                "C:\\Users\\mokoenek\\Desktop\\IntelliJ\\Drivers\\geckodriver.exe");

        driver = new FirefoxDriver();
        driver.get("https://magento.abox.co.za");

        WebElement body = driver.findElement(By.tagName("body"));
        String bodyText = body.getText();
        Assert.assertTrue("Does not contain the text 'page'",bodyText.contains("Hot Sellers"));
    }



    @When("the customer searches a product")
    //the below code is for when we get to the home page, thats were we enter on the search field
    // the product that we are looking for
    //we can also turn this code into a negative test by simply changing the text inside the selectShirt.setSearchShirt...
    // to "Boots" in oder to search for what does not exist "Shirt"
    //We have a code that tells the program to wait while we are searching on the Homepage
    public void the_customer_searches_a_products() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        homePageObject selectShirt = PageFactory.initElements(driver, homePageObject.class);
        selectShirt.setSearchShirt("Shirt");
        WebDriverWait wait = new WebDriverWait(driver, 400);
        wait.until(ExpectedConditions.visibilityOfElementLocated(shirtSelectLocater));





    }

    @Then("allow the customer to select  a product")
    //Below is the code that lets us select our product after we search it and also the is the wait until code
    //that tells the program to wait until the product is found before it is selected
    // I also placed the assert code to look for the add to cart button after selecting product
    public void allow_the_customer_to_select_a_product() {
        // Write code here that turns the phrase above into concrete actions
        WebDriverWait wait = new WebDriverWait(driver, 500);
        wait.until(ExpectedConditions.visibilityOfElementLocated(shirtSelectLocater));
        driver.findElement(shirtSelectLocater).click();
        WebElement body = driver.findElement(By.tagName("body"));
        String bodyText = body.getText();
        Assert.assertTrue("Does not contain the text 'page'",bodyText.contains("Add to Cart"));

    }



}
