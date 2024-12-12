package pages;

import lombok.Setter;
import manager.AppManager;
import org.openqa.selenium.WebDriver;

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
}
