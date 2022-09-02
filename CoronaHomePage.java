package PageObjectModelTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoronaHomePage {
    public CoronaHomePage(WebDriver myBrowserDriver){
        PageFactory.initElements(myBrowserDriver,this);
    }

    @FindBy(xpath = "//a[@class='header-title']//h1[contains(text(),'Единен информационен портал')]")
    public WebElement infoPortalHeaderTitle;
    public boolean infoPortalHeaderTitleIsDisplayed(){
    return infoPortalHeaderTitle.isDisplayed();
    }
}