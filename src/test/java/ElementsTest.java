import elements.FriendsWrapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.FriendsPage;

import static com.codeborne.selenide.Selenide.open;

public class ElementsTest extends BaseTest {
    private int amount;

    @BeforeEach
    @Override
    public void before() {
        super.before();
        amount = FriendsPage.open().getAmount();
    }

    @Test
    public void friendsTest() {
        final FriendsWrapper friendElementList = new FriendsWrapper(amount);

        friendElementList.getByIndex(1).nameClick();
        open("https://ok.ru/feed");
        friendElementList.getByIndex(0).messageClick();
    }


}
