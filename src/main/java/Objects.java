import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Objects {
    public static WebElement element = null;

    //--Authorization----------------------------------------------------------------------------

    public static  WebElement SingIn (WebDriver driver) {
        element = driver.findElement(By.id("sign-in-1"));
        return element;
    }

    public static  WebElement EmailAddress (WebDriver driver) {
        element = driver.findElement(By.id("email"));
        return element;
    }

    public static  WebElement Password (WebDriver driver) {
        element = driver.findElement(By.id("password"));
        return element;
    }

    public static  WebElement SingInButton (WebDriver driver) {
        element = driver.findElement(By.id("sign-in-2"));
        return element;
    }

    public static  WebElement Hubs (WebDriver driver) {
        element = driver.findElement(By.id("hubs"));
        return element;
    }

    public static  WebElement Documents (WebDriver driver) {
        element = driver.findElement(By.id("documents"));
        return element;
    }



    public static  WebElement searchHub (WebDriver driver) {
        element = driver.findElement(By.className("css-169w3oy"));
        return element;
    }

    public static  WebElement filesFromHub (WebDriver driver) {
        element = driver.findElement(By.xpath("//div[contains(@class,'hub-item')]/div/div[2]/div[2]/span"));
        return element;
    }

    public static  WebElement numberOfFilesDropDown (WebDriver driver) {
        element = driver.findElement(By.xpath("//div[@class='pagination-controls']/div/div"));
        return element;
    }

    public static  WebElement numberOfFiles100 (WebDriver driver) {
        element = driver.findElement(By.xpath("//div[contains(text(), '100') and @class='option-text']"));
        return element;
    }

    public static  WebElement downloadBtn (WebDriver driver) {
        element = driver.findElement(By.className("css-19dnden"));
        return element;
    }





}
