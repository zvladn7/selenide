package elements;

import java.util.ArrayList;
import java.util.List;

public class FriendsWrapper {
    private final List<FriendElement> friendElements;

    public FriendsWrapper(final int amount) {
        friendElements = new ArrayList<>();
        for (int i = 1; i <= amount; i++) {
            friendElements.add(new FriendElement(i));
        }
    }

    public FriendElement getByIndex(final int index) {
        return friendElements.get(index);
    }

    public List<FriendElement> getAll() {
        return friendElements;
    }

}
