package pages;

import dto.Board;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BoardsPage extends BasePage
{
    public BoardsPage(WebDriver driver)
    {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,10),this);
    }

    @FindBy(xpath = "//li[@data-testid='create-board-tile']")
    WebElement btnCreateNewBoard;

    @FindBy(xpath = "//input[@data-testid='create-board-title-input']")
    WebElement boardTitle;

    @FindBy(xpath = "//button[@data-testid='create-board-submit-button']")
    WebElement btnCreate;

    @FindBy(xpath = "//div[@class='board-tile-details is-badged']")
    WebElement firstBoard;

    @FindBy(xpath = "//span[@class='QMKgZFIlTLiEJN']")
    WebElement confirmMessage;

    public boolean validateUrl()
    {
      return new WebDriverWait(driver, 5).until(ExpectedConditions.urlContains("boards"));
    }


    public void createNewBoard(Board board)
    {
        btnCreateNewBoard.click();
        boardTitle.sendKeys(board.getBoardTitle());
        clickWait(btnCreate,5);
    }

    public void createNewBoardNegative(Board board)
    {
        btnCreateNewBoard.click();
        boardTitle.sendKeys(board.getBoardTitle());
    }

    public boolean buttonCreateIsNotClickable()
    {
       return new WebDriverWait(driver,5).until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(btnCreate)));
    }

    public void openFirstBoard()
    {
        firstBoard.click();
    }

    public boolean validateConfirmMessage(String text)
    {
        return validateTextElementWait(confirmMessage,text,3);
    }
}
