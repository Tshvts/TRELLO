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

    @FindBy(xpath = "//button[@class='GDunJzzgFqQY_3 frrHNIWnTojsww bxgKMAm3lq5BpA HAVwIqCeMHpVKh SEj5vUdI3VvxDc']")
    WebElement btnMenu;

    @FindBy(xpath = "//div[text()='Close board']")
    WebElement btnCloseBoard;

    @FindBy(xpath = "//button[text()='Close']")
    WebElement btnClose;

    @FindBy(xpath = "//button[@data-testid='close-board-delete-board-button']")
    WebElement btnDeleteBoard;

    @FindBy(xpath = "//button[@data-testid='close-board-delete-board-confirm-button']")
    WebElement btnDeleteConfirm;

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

    public void deleteFirstBoard()
    {
        clickWait(btnMenu,3);
        clickWait(btnCloseBoard,3);
        clickWait(btnClose,3);
        clickWait(btnDeleteBoard,3);
        clickWait(btnDeleteConfirm,3);
    }
}
