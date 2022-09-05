package PageObjectModelTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestingPages {

    private static WebDriver myBrowserDriver;
    private static GovernmentHomePage governmentBgHomePage;
    private static CoronaHomePage coronaVirusBgHomePage;

    static final String covidPortalUrl = "https://coronavirus.bg/";

    @BeforeAll
    public static void setupBrowserAndPages() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setupTests(){
            myBrowserDriver = new ChromeDriver();
            governmentBgHomePage = new GovernmentHomePage(myBrowserDriver);
            coronaVirusBgHomePage = new CoronaHomePage(myBrowserDriver);
            myBrowserDriver.manage().window().maximize();
        }

     @Test
     void covidPortalLinkWorksCorrectly(){
        governmentBgHomePage.navigateToGovernmentBg();
        governmentBgHomePage.clickCovidInfoPortalIcon();
        governmentBgHomePage.switchToBrowserTabByIndex(1);
            Assertions.assertEquals(covidPortalUrl, myBrowserDriver.getCurrentUrl());
            Assertions.assertTrue(coronaVirusBgHomePage.infoPortalHeaderTitleIsDisplayed());

    }
    @AfterEach
    public void closeSession(){
        myBrowserDriver.quit();
    }



}
