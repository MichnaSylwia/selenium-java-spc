package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends SeleniumPage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a.user-profile")
    private WebElement userProfile;

    @FindBy(css = "a[href*=Logout]")
    private WebElement logoutLnk;

    @FindBy(css = ".profile_info>h2")
    public WebElement welcomeElm;

    @FindBy(css = ".menu-home")
    private WebElement homeNav;

    @FindBy(linkText = "Dashboard")
    private WebElement dashboardMenu;

    @FindBy(css = ".menu-workspace")
    private WebElement workspaceNav;

    @FindBy(css = "a[href$=Projects]")
    private WebElement processesMenu;

    @FindBy(css = "a[href$=Characteristics]")
    private WebElement characteristicsMenu;

    public LoginPage logout() {
        userProfile.click();
        logoutLnk.click();

        return new LoginPage(driver);
    }


}
