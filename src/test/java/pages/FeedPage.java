package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class FeedPage {

    public static final String[] toolbarTexts = {
            "Сообщения", "Обсуждения", "Оповещения", "Друзья", "Гости", "События", "Видео", "Музыка"
    };

    private SelenideElement userIconToolbar =
            $(By.xpath(".//div[@class='ucard-mini toolbar_ucard js-toolbar-menu']"));

    private SelenideElement exitButton =
            $(By.xpath(".//a[@data-l='t,logoutCurrentUser']"));

    private SelenideElement confirmExit =
            $(By.xpath(".//input[@data-l='t,confirm']"));


    public void openToolbarDropdownMenu() {
        userIconToolbar.click();
    }

    public SelenideElement logout() {
        exitButton.click();
        return confirmExit;
    }

    public void confirm() {
        confirmExit.click();
    }

}