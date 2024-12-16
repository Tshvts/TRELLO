package tests;

import dto.Board;
import dto.User;
import manager.AppManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BoardsPage;
import pages.HomePage;
import pages.LoginPage;
import utils.RandomUtils;

public class BoardsTest extends AppManager
{
    BoardsPage boardsPage;

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
    }

    @Test
    public void createNewBoard()
    {
        Board board = Board.builder()
                .boardTitle(RandomUtils.generateString(7))
                .build();
        boardsPage.createNewBoard(board);
    }
}
