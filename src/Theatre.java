import java.util.ArrayList;
import java.util.List;

public class Theatre {
    private final String name;
    private final List<Screen> screens;

    public Theatre(String name) {
        this.name = name;
        this.screens = new ArrayList<>();
    }

    public void addScreen(Screen screen) {
        screens.add(screen);
    }

    public List<Screen> getScreens() {
        return new ArrayList<>(screens);
    }

    public String getName() {
        return name;
    }
}
