package elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class PostingElement {

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
