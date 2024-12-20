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
import utils.RandomUtils;

public class BoardsTest extends AppManager
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
        myBoardPage = new MyBoardPage(getDriver());
    }

    @Test
    public void createNewBoardPositiveTest()
    {
        Board board = Board.builder()
                .boardTitle(RandomUtils.generateString(7))
                .build();
        boardsPage.createNewBoard(board);
        Assert.assertTrue(myBoardPage.validateBoardName(board.getBoardTitle(),5));
    }

    @Test
    public void createNewBoardNegativeTest()
    {
        Board board = Board.builder()
                .boardTitle("")
                .build();
        boardsPage.createNewBoardNegative(board);
        Assert.assertTrue(boardsPage.buttonCreateIsNotClickable());
    }
}
