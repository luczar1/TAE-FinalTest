import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class CheapticketsResultPage extends BasePage {

    @FindBy(how = How.CLASS_NAME, using = "section-header-main")
    private WebElement title;

    @FindBy(how = How.ID, using = "inpHotelNameMirror")
    private WebElement propName;

    @FindBy(how = How.ID, using = "hotelNameGoBtn")
    private WebElement btnGo;

    public CheapticketsResultPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getTitle() {
        return title;
    }

    public WebElement getPropName() {
        return propName;
    }

    public WebElement getBtnGo() {
        return btnGo;
    }

    public void searchHotel(String hotel) {
        propName.click();
        propName.sendKeys(hotel);
        propName.click();
        propName.sendKeys("n");

        if (getDriver().findElement(By.id("taHotelsResultsContainer")) != null) {
            getDriver().findElement(By.className("results-item")).click();
            System.out.println("Hotel found");
            btnGo.click();
        } else {
            System.out.println("No hotel found");
        }

    }

    public boolean checkLocation() {
        List<WebElement> results = getDriver().findElements(By.id("resultsContainer"));

        for (WebElement result : results) {

            String barrio = result.findElement(By.className("neighborhood")).getText();
            if (barrio.contains("Beach") || barrio.contains("Miami")) {
                System.out.println("Miami Beach found");
                return true;
            }
        }
        System.out.println("Miami Beach not found");
        return false;
    }

    public boolean checkQuantity() {
        String[] result = title.getText().split(" ");
        int q = Integer.valueOf(result[2]);

        if (q > 0) {
            return true;
        }

        return false;
    }

    public boolean checkFaena() {
        int results = getDriver().findElement(By.id("resultsContainer")).findElements(By.tagName("aticle")).size();

        if (results > 0){
            System.out.println("Faena Hotel found");
            return true;
        }

        System.out.println("Faena Hotel not found");
        return false;
    }
}
