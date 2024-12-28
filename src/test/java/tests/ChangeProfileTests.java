package tests;

import dto.Board;
import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import java.util.ArrayList;
import java.util.List;

import static utils.RandomUtils.generateString;

public class ChangeProfileTests extends AppManager
{
    BoardsPage boardsPage;
    AtlassianProfilePage atlassianProfilePage;

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
}
