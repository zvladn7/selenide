package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MessagesPage {
    private final SelenideElement name = $(By.tagName("msg-chat-title"));

    public static MessagesPage open() {
        return new MessagesPage();
    }

    public boolean checkName(final String name) {
        return this.name.getText().equals(name);
    }
}
