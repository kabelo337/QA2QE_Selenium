package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class homePageObject {

     private WebElement search;


    public void setSearchShirt(String ShopShirt)  throws InterruptedException
            //this is our code that will return what we have searched for.
    {

     search.clear();
     search.sendKeys(ShopShirt);
     search.sendKeys(Keys.RETURN);

    }




    }
