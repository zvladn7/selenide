import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import pages.FeedPage;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.CollectionCondition.sizeLessThan;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.refresh;

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
