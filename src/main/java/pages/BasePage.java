package pages;

import lombok.Setter;
import manager.AppManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends AppManager
{
    @Setter
    static WebDriver driver;

    public void pause(int time)
    {
        try {
            Thread.sleep(time* 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickWait(WebElement element, int time)
    {
        new WebDriverWait(driver,time).until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public boolean validateTextElementWait(WebElement element, String text, int time)
    {
      return new WebDriverWait(driver,time).until(ExpectedConditions.textToBePresentInElement(element,text));
    }
}
