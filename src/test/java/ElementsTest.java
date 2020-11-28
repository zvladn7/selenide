import com.codeborne.selenide.Condition;
import elements.FriendElement;
import elements.FriendsWrapper;
import org.junit.jupiter.api.Test;

public class ElementsTest extends BaseTest {

    @Test
    public void profileTest() {
        final FriendsWrapper friendElementList = new FriendsWrapper();
        for (final FriendElement friendElement : friendElementList.getAll()) {
            friendElement.nameClick().getName().shouldHave(Condition.text(friendElement.getName()));
            backToMainPage.click();
        }
    }
}
