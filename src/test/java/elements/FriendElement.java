package elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.MessagesPage;
import pages.ProfilePage;

import static com.codeborne.selenide.Selenide.$;

public class FriendElement {
    private final SelenideElement nameXpath;
    private final SelenideElement messageXpath;

    public FriendElement(final int index) {
        nameXpath = $(By.xpath("(.//div[@class='ucard-v __xxxs __h __rounded online-fr_card ']//a[@class='o online-fr_o'])[" + index + "]"));
        messageXpath = $(By.xpath("(.//div[@class='ucard-v __xxxs __h __rounded online-fr_card ']//a[@class='button-pro __sec online-fr_msg'])[" + index + "]"));
    }

    public ProfilePage nameClick() {
        nameXpath.click();
        return ProfilePage.open();
    }

    public MessagesPage messageClick() {
        messageXpath.click();
        return MessagesPage.open();
    }

    public String getName() {
        return nameXpath.getText();
    }
}
