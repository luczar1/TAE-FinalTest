import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Exercise_1 {

    private WebDriver driver;
    private String url = "https://www.cheaptickets.com/";
    private CheapticketsHomePage cheapT;
    private WebDriverWait wait;
    private CheapticketsSearchPage searchPage;
    private String destino = "Miami Beach";

    @BeforeClass
    public void testSetUp() {
        driver = new FirefoxDriver();
        cheapT = new CheapticketsHomePage(driver);
        wait = cheapT.getWait();
    }

    @Test
    public void hotelSearch(){
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


    }

}


