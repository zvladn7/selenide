package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    public LoginPage open() {
        Selenide.open("https://ok.ru");
        return this;
    }

    private SelenideElement login = $(By.name("st.email"));
    private SelenideElement pass = $(By.name("st.password"));

    public void typeEmail(final String email) {
        login.append(email);
    }

    public SelenideElement typePassword(final String password) {
        return pass.append(password);
    }

}
