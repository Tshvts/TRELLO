package tests;

import dto.User;
import manager.AppManager;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends AppManager
{
    @Test
    public void loginPositiveTest()
    {
        User user = User.builder()
                .email("sevcovat416@gmail.com")
                .password("+Wx:7q:#UW2Csn%")
                .build();
        new HomePage(getDriver()).clickBtnLogin();
        new LoginPage(getDriver()).login(user);
    }
}
