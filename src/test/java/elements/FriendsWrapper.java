package elements;

import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class FriendsWrapper {
    private final List<FriendElement> friendElements;

    private final int amount;

    public FriendsWrapper() {
        friendElements = new ArrayList<>();
        amount = provideAmount();
        for (int i = 1; i <= amount; i++) {
            friendElements.add(new FriendElement(i));
        }
    }

    private int provideAmount() {
        return $$(By.xpath(".//a[@data-l='t,user_photo']")).size();
    }

    public FriendElement getByIndex(final int index) {
        return friendElements.get(index);
    }

    public List<FriendElement> getAll() {
        return friendElements;
    }

}
