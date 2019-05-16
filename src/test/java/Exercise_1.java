import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Exercise_1 {

    private WebDriver driver;
    private String url = "https://www.cheaptickets.com/";
    private CheapticketsHomePage cheapT;
    private WebDriverWait wait;

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
    }

}


