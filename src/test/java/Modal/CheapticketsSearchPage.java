package Modal;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class CheapticketsSearchPage extends BasePage {

    @FindBy (how = How.NAME, using = "destination")
    private WebElement destiny;

    @FindBy (how = How.NAME, using = "startDate")
    private WebElement startDate;

    @FindBy (how = How.NAME, using = "endDate")
    private WebElement endDate;

    @FindBy (how = How.ID, using = "hotel-1-adults-hlp")
    private Select adults;

    @FindBy (how = How.ID, using = "hotel-1-children-hlp")
    private Select child;

    @FindBy (how = How.ID, using = "hotel-1-age-select-1-hlp")
    private Select age;

    @FindBy (how = How.CLASS_NAME, using = "gcw-submit")
    private WebElement search;


    public CheapticketsSearchPage(WebDriver driver){
        super(driver);
    }

    public WebElement getDestiny(){
        return destiny;
    }

    public WebElement getStartDate(){
        return startDate;
    }

    public WebElement getEndDate(){
        int i = 10;

        do{
            endDate.sendKeys(Keys.BACK_SPACE);
            i--;
        }while (i!=0);

        return endDate;
    }

    public WebElement getSearch(){
        return search;
    }

    public void setAdults(String n){

        adults = new Select(getDriver().findElement(By.id("hotel-1-adults-hlp")));
        adults.selectByVisibleText(n);

    }

    public void setChild(String n){

        child = new Select(getDriver().findElement(By.id("hotel-1-children-hlp")));
        child.selectByVisibleText(n);

    }

    public void setAge(String n){

        age = new Select(getDriver().findElement(By.id("hotel-1-age-select-1-hlp")));
        age.selectByVisibleText(n);

    }

}
