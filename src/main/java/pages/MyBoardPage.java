package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class MyBoardPage extends BasePage
{
    public MyBoardPage(WebDriver driver)
    {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,10),this);
    }

    @FindBy(xpath = "//h1[@data-testid='board-name-display']")
    WebElement boardName;

    public boolean validateBoardName(String text, int time)
    {
        try {
            return validateTextElementWait(boardName,text,time);
        }
        catch (NoSuchElementException | TimeoutException exception)
        {
            System.out.println("Create exception" + exception.getMessage());
            return false;
        }

    }
}
