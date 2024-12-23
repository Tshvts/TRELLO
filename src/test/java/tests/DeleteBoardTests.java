package tests;

import dto.Board;
import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BoardsPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyBoardPage;

import static utils.RandomUtils.*;

public class DeleteBoardTests extends AppManager
{
    BoardsPage boardsPage;
    MyBoardPage myBoardPage;

    @BeforeMethod
    public void login()
    {
        User user = User.builder()
                .email("sevcovat416@gmail.com")
                .password("+Wx:7q:#UW2Csn%")
                .build();
        new HomePage(getDriver()).clickBtnLogin();
        new LoginPage(getDriver()).login(user);
        boardsPage = new BoardsPage(getDriver());
        Board board = Board.builder().boardTitle(generateString(6)).build();
        boardsPage.createNewBoard(board);
        myBoardPage = new MyBoardPage(getDriver());
    }

    @Test
    public void deleteFirstBoardPositive()
    {
        boardsPage.openFirstBoard();
        myBoardPage.deleteFirstBoard();
        Assert.assertTrue(boardsPage.validateConfirmMessage("Board deleted."));
    }
}
