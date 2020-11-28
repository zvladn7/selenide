package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProfilePage {
    private final SelenideElement name = $(By.xpath(".//a[@class='profile-user-info_name']"));

    public static ProfilePage open() {
        return new ProfilePage();
    }

    public SelenideElement getName() {
        return this.name;
    }
}
