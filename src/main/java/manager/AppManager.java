package manager;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.WDListener;

import java.lang.reflect.Method;

public class AppManager
{
    @Getter
    private EventFiringWebDriver driver;
    public Logger logger = LoggerFactory.getLogger(AppManager.class);

    @BeforeMethod()
    public void setUp(Method method)
    {
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.manage().window().maximize();
        driver.register(new WDListener());
    }

    @AfterMethod
    public void tearDown()
    {
//        if(driver!=null)
//            driver.quit();
    }
}
