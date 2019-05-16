import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CheapticketsHomePage extends BasePage {

    @FindBy (how = How.ID, using = "primary-header-hotel")
    private WebElement hotel;

    public CheapticketsHomePage(WebDriver driver){
        super(driver);
    }

    public WebElement getHotel(){
        return hotel;
    }
}
