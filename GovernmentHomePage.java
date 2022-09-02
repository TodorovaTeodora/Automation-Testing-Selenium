package PageObjectModelTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class GovernmentHomePage {
    private final WebDriver myBrowserDriver;
    private final String governmentBgHomeUrl = "https://gov.bg";

    public GovernmentHomePage(WebDriver myBrowserDriver) {
        this.myBrowserDriver = myBrowserDriver;
        PageFactory.initElements(myBrowserDriver, this);
    }

    //Page elements
    @FindBy(css = ".covid19")
    WebElement covidInfoPortalIcon;

    //Page methods
    public void navigateToGovernmentBg() {
        myBrowserDriver.navigate().to(governmentBgHomeUrl);
    }
    public void clickCovidInfoPortalIcon(){
        covidInfoPortalIcon.click();
    }
    public void switchToBrowserTabByIndex(int tabIndex){
        ArrayList<String> browserTabs = new ArrayList<>(myBrowserDriver.getWindowHandles());
        myBrowserDriver.switchTo().window(browserTabs.get(tabIndex));
  }
}
