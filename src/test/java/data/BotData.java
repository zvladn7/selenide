package data;

public class BotData {
    private final String loginOfBot;

    private final String passwordOfBot;

    public BotData(final String loginOfBot, final String passwordOfBot) {
        this.loginOfBot = loginOfBot;
        this.passwordOfBot = passwordOfBot;
    }

    public String getLoginOfBot() {
        return loginOfBot;
    }

    public String getPasswordOfBot() {
        return passwordOfBot;
    }
}

