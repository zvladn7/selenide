package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class FriendsPage {
    private SelenideElement amountXpath = $(By.xpath(".//a[@hrefattrs='st.cmd=userFriend&st._aid=UserFriend_ViewAll']//span[@class='lstp-t']"));

    public static FriendsPage open() {
        SelenideElement friendPage = $(By.xpath("(.//div[@class='toolbar_nav_i_tx-w usel-off'])[4]"));
        friendPage.click();
        return new FriendsPage();
    }

    public int getAmount() {
        return Integer.parseInt(amountXpath.getText());
    }
}
