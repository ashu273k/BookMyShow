import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Screen {
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(1000);
    private final int id;
    private final List<Show> shows;

    public Screen() {
        this.id = ID_GENERATOR.getAndIncrement();
        shows = new ArrayList<>();
    }

    public void addShow(Show show) {
        shows.add(show);
    }

    public void deleteShow(int id) {
        shows.removeIf(show -> show.getId() == id);
    }

    public List<Show> getShows() {
        return new ArrayList<>(shows);
    }

    public int getId() {
        return this.id;
    }
}
