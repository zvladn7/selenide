import com.codeborne.selenide.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class OkPageTest {

    public static String loginOfBot = "TechoBot8";
    public static String passwordOfBot = "TechnoPolis19";
    private static LoginPage loginPage;
    private static FeedPage feedPage;
    private static PostMaker postMaker;


    @BeforeAll
    public static void init() {
        loginPage = new LoginPage();
        loginPage.open();
        feedPage = new FeedPage();
        postMaker = new PostMaker();
    }

    @BeforeEach
    public void before() {
        if (!WebDriverRunner.url().equals("https://ok.ru/feed")) {
            loginPage.typeEmail(loginOfBot);
            loginPage.typePassword(passwordOfBot).pressEnter();
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"Сообщения", "Обсуждения", "Оповещения", "Друзья", "Гости", "События", "Видео", "Музыка"})
    public void checkToolbarContent(final String arg) {
        ElementsCollection toolbarActions = $$(By.className("toolbar_nav_i_tx-w"));
        Assertions.assertNotNull(toolbarActions);
        toolbarActions.shouldHaveSize(8);
        toolbarActions.shouldHave(texts(FeedPage.toolbarTexts));
        toolbarActions.shouldHave(itemWithText(arg));
        refresh();
    }

    @Test
    public void checkPhotoHover() {
        $(By.className("entity-avatar")).shouldBe(exist)
                .hover().shouldHave(text("Добавить фото"));
    }

    @Test
    public void makePost() {
        postMaker.makeText();
        ElementsCollection toolbarActions = $$(By.xpath(".//div[@class='posting_ac_i_w']"));
        toolbarActions.shouldHave(sizeGreaterThan(4));
        toolbarActions.shouldHave(sizeLessThan(7));
        toolbarActions.shouldHave(CollectionCondition.textsInAnyOrder(
                "Добавить фото",
                "Добавить видео",
                "Добавить музыку",
                "Добавить опрос",
                "Указать место"
        ));
        final String text = "New post from test";
        postMaker.type(text);
        postMaker.getPostingHandler().shouldHave(text(text));
        postMaker.selectDataEnable();
        postMaker.submit();
        SelenideElement post = $(By.xpath(".//div[@class='media-text_cnt_tx emoji-tx textWrap']"));
        post.shouldBe(exist).shouldHave(text(text));
        $(By.xpath(".//a[@data-l='t,removeTopic']")).click();
        refresh();
        post.shouldBe(not(exist));
        open("https://ok.ru/feed");
    }


    @AfterAll
    public static void deinit() throws InterruptedException {
        feedPage.openToolbarDropdownMenu();
        feedPage.logout().click();
        Thread.sleep(1000);
    }

}
