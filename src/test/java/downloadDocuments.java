import config.ServerConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import java.util.List;

public class downloadDocuments {

    public WebDriver driver;
    private Logger logger = LogManager.getLogger(downloadDocuments.class);
    private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        logger.info("Driver is up");
    }
    @Test
    public void CompareData() throws InterruptedException {
        driver.get(cfg.url());
        logger.info(String.format("Page is opened %s", cfg.url()));
        Objects.SingIn(driver).click();
        WaitElement.ToBeClickable(driver,Objects.EmailAddress(driver), 800);
        Objects.EmailAddress(driver).sendKeys("viorica-support@urchinsys.com");
        Objects.Password(driver).sendKeys("Feb2021!");
        Objects.SingInButton(driver).click();
        logger.info("Authorization passed");
        Thread.sleep(2000);

        //Select Client
       /* driver.findElement(By.xpath("//div[contains(@class, 'css-kb75qq')]")).click();
        Thread.sleep(300);
        WebElement Client = driver.findElement(By.xpath("//div[@titlr='Unemployment Tax Management Corp']"));

        JavascriptExecutor je = (JavascriptExecutor) driver;;
        je.executeScript("arguments[0].scrollIntoView(true);",Client);
        //page scroll move down too, so return it back to the top
        JavascriptExecutor je2 = (JavascriptExecutor) driver;
        je2.executeScript("arguments[0].scrollIntoView(true);",Client);
        // now checkbox can be selected
        Client.click();*/


        Objects.Hubs(driver).click();
        Thread.sleep(2000);
        Objects.searchHub(driver).click();
        Objects.searchHub(driver).sendKeys("CT BC Reimbursable");
        Thread.sleep(2000);
        Objects.filesFromHub(driver).click();
        Thread.sleep(300);
        Objects.numberOfFilesDropDown(driver).click();
        WaitElement.ToBeClickable(driver, Objects.numberOfFiles100(driver), 40);
        Objects.numberOfFiles100(driver).click();
        Thread.sleep(300);

        //Scroll page down
      //  JavascriptExecutor js = (JavascriptExecutor) driver;
       // js.executeScript("window.scrollBy(0,1000)");

        //Select page 2
    //    driver.findElement(By.xpath("//div[@class='pages']/span[2]")).click();
    //    Thread.sleep(1000);

        WebElement Files = driver.findElement(By.id("documents-grid"));
        List<WebElement> allFiles = Files.findElements(By.xpath("//div[@class='filename']"));
        for (WebElement file : allFiles) {
            file.click();
        WaitElement.ToBeClickable(driver, Objects.downloadBtn(driver), 40);
            Objects.downloadBtn(driver).click();
            Thread.sleep(100);
            WebElement svgObject = driver.findElement(By.xpath("//*[name()='svg']"));
            Actions builder = new Actions(driver);
            builder.click(svgObject).build().perform();
            Thread.sleep(100);
        }

    }
    @AfterTest
    public  void setDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
