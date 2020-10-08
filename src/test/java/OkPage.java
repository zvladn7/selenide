import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class OkPage {

    public static String loginOfSecondBot = "technopolisBot232";
    public static String passwordOfSecondBot = "technopolis16";

    @BeforeAll
    public static void init() {
        open("https://ok.ru");
    }

    @Test
    @Order(1)
    public void openMainPage() {
        LoginPage loginPage = new LoginPage();
        Assertions.assertTrue($(By.xpath(".//input[@data-l='t,sign_in']")).exists());
        Assertions.assertTrue($(By.xpath(".//input[@name='st.email']")).exists());
        Assertions.assertTrue($(By.xpath(".//input[@name='st.password']")).exists());
    }

    @Test
    @Order(2)
    public void login() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.typeEmail();
        loginPage.typePassword();
        $(By.xpath(".//input[@data-l='t,sign_in']")).click();
        Thread.sleep(1000);
    }

//    @Test
//    @Order(3)
//    public void logout() throws InterruptedException {
//        $(By.xpath(".//div[@class='ucard-mini toolbar_ucard js-toolbar-menu']")).click();
//        $(By.xpath("//a[@data-l='t,logoutCurrentUser']")).click();
//        Thread.sleep(1000);
//    }



    static class LoginPage {
        private SelenideElement label = $(".input-1");
        private SelenideElement login = $(By.name("st.email"));
        private SelenideElement pass = $(By.name("st.password"));


        public void typeEmail() {
            login.append(loginOfSecondBot);
        }
        public void typePassword() {
            pass.append(passwordOfSecondBot);
        }

    }
}
