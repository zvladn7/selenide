import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPageTest {

    @BeforeAll
    public static void init() {
        Selenide.open("https://ok.ru");
    }

    @Test
    public void openMainPage() {
        Assertions.assertTrue($(By.xpath(".//input[@data-l='t,sign_in']")).exists());
        Assertions.assertTrue($(By.xpath(".//input[@name='st.email']")).exists());
        Assertions.assertTrue($(By.xpath(".//input[@name='st.password']")).exists());
    }

}
