import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import data.BotData;
import elements.PostingElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import pages.FeedPage;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.$;

public class BaseTest {
    protected static LoginPage loginPage;
    protected static FeedPage feedPage;
    protected static PostingElement postingElement;
    protected static BotData botData;
    protected SelenideElement backToMainPage = $(By.xpath(".//a[@id=\"toolbar_logo_id\"]"));

    @BeforeAll
    public static void init() {
        Configuration.startMaximized = true;
        loginPage = new LoginPage();
        loginPage.open();
        feedPage = new FeedPage();
        postingElement = new PostingElement();
        botData = new BotData("TechoBot8", "TechnoPolis19");
    }

    @BeforeEach
    public void before() {
        if (!WebDriverRunner.url().equals("https://ok.ru/feed")) {
            loginPage.typeEmail(botData.getLoginOfBot());
            loginPage.typePassword(botData.getPasswordOfBot()).pressEnter();
        }
    }

    @AfterEach
    public void deinit() throws InterruptedException {
        feedPage.openToolbarDropdownMenu();
        feedPage.logout().click();
    }
}
