import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Exercise_1 {

    private WebDriver driver;
    private String url = "https://www.cheaptickets.com/";
    private CheapticketsHomePage cheapT;
    private WebDriverWait wait;
    private CheapticketsSearchPage searchPage;
    private String destino = "Miami Beach";
    private CheapticketsResultPage resultPage;
    private String hotelSearch = "fae";

    @BeforeClass
    public void testSetUp() {
        driver = new FirefoxDriver();
        cheapT = new CheapticketsHomePage(driver);
        wait = cheapT.getWait();
    }

    @Test
    public void hotelSearch() throws InterruptedException {
        driver.navigate().to(url);
        cheapT.getHotel().click();
        searchPage = new CheapticketsSearchPage(driver);
        searchPage.getDestiny().sendKeys(destino);
        searchPage.getStartDate().sendKeys("08/22/2019");
        WebElement endDate = searchPage.getEndDate();
        endDate.sendKeys("09/10/2019");
        searchPage.setAdults("4");
        searchPage.setChild("1");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("hotel-1-age-select-1-hlp"))));
        searchPage.setAge("7");
        searchPage.getSearch().click();
        driver.manage().window().maximize();
        //need to wait for the modal to appear, ask why the wait.until doesnt work
        Thread.sleep(32000);
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("modal-body"))));
        driver.findElement(By.id("modalCloseButton")).click();
        resultPage = new CheapticketsResultPage(driver);
        System.out.println(resultPage.getTitle().getText());

        /* Assert quantity */
        takeScreensShot(driver, "quantity.png");
        Assert.assertTrue(resultPage.checkQuantity());

        /*Assert location */
        takeScreensShot(driver, "location.png");
        Assert.assertTrue(resultPage.checkLocation());

        /*Assert Faena Hotel search*/
        resultPage.searchHotel(hotelSearch);
        Thread.sleep(3000);
        takeScreensShot(driver, "faenaHotel.png");
        Assert.assertTrue(resultPage.checkFaena());


    }

    @AfterTest
    public void tearDown(){

        driver.quit();

    }

    private void takeScreensShot (WebDriver driver, String name){
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src,new File("/media/lucas/DATA/Globant/Final test/img/"+name));
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

}


