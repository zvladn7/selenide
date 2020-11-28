import com.codeborne.selenide.*;
import data.BotData;
import elements.FriendElement;
import elements.PostingElement;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import pages.FeedPage;
import pages.LoginPage;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class OkPageTest extends BaseTest {

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
        postingElement.makeText();
        ElementsCollection toolbarActions = $$(By.xpath(".//div[@class='posting_ac_i_w']"));
        toolbarActions.shouldHave(sizeGreaterThan(4));
        toolbarActions.shouldHave(sizeLessThan(7));
        toolbarActions.shouldHave(CollectionCondition.textsInAnyOrder(
                "Добавить фото",
                "Добавить видео",
                "Добавить музыку",
                "Добавить опрос",
                "Указать место",
                "Отметить друзей"
        ));
        final String text = "New post from test";
        postingElement.type(text);
        postingElement.getPostingHandler().shouldHave(text(text));
        postingElement.selectDataEnable();
        postingElement.submit();
        SelenideElement post = $(By.xpath(".//div[@class='media-text_cnt_tx emoji-tx textWrap']"));
        post.shouldBe(exist).shouldHave(text(text));
        $(By.xpath(".//a[@data-l='t,removeTopic']")).click();
        refresh();
        post.shouldBe(not(exist));
        open("https://ok.ru/feed");
    }

}
