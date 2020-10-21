import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.CollectionCondition.sizeLessThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class PostMaker {

    private SelenideElement textHere =
            $(By.xpath(".//a[@class='pf-head_itx_a']"));

    private SelenideElement postingHandler =
            $(By.xpath(".//div[@class='posting_itx emoji-tx h-mod js-ok-e js-posting-itx ok-posting-handler']"));

    private SelenideElement postDateEnable =
            $(By.className("posting_s"));

    private SelenideElement submitButton =
            $(By.xpath(".//div[@class='posting_submit button-pro']"));

    public SelenideElement getPostingHandler() {
        return postingHandler;
    }

    public void makeText() {
        textHere.click();
    }

    public void type(final String postText) {
        postingHandler.setValue(postText);
    }

    public void selectDataEnable() {
        postDateEnable.click();
    }

    public void submit() {
        submitButton.click();
    }

}
