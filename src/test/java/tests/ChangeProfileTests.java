package tests;

import dto.Board;
import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import utils.TestNGListener;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Listeners(TestNGListener.class)

public class ChangeProfileTests extends AppManager
{
    BoardsPage boardsPage;
    AtlassianProfilePage atlassianProfilePage;

    @BeforeMethod
    public void login(Method method)
    {
        User user = User.builder()
                .email("sevcovat416@gmail.com")
                .password("+Wx:7q:#UW2Csn%")
                .build();
        logger.info("START TEST ===> " + method.getName() + " WITH THE FOLLOWING DATA ===> " + user);
        new HomePage(getDriver()).clickBtnLogin();
        new LoginPage(getDriver()).login(user);
        boardsPage = new BoardsPage(getDriver());
        atlassianProfilePage = new AtlassianProfilePage(getDriver());
    }

    @Test
    public void changeProfilePhotoPositive()
    {
        boardsPage.openMyAccount();
        List<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        System.out.println(tabs);
        getDriver().switchTo().window(tabs.get(1));
        atlassianProfilePage.changeProfilePhoto("src/main/resources/5395436336867041068_121.jpg");
        Assert.assertTrue(atlassianProfilePage.validateMessage("We've uploaded your new avatar. It may take a few minutes to display everywhere."));
    }

    @Test
    public void ChangeProfilePhotoNegativeWrongFormatFile(){
        boardsPage.openMyAccount();
        List<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(1));
        atlassianProfilePage.changeProfilePhoto("src/main/resources/DPBoards.csv");
        Assert.assertTrue(atlassianProfilePage.
                validateMessageWrongFormatMessage("Upload a photo or select from some default options"));
    }
}
