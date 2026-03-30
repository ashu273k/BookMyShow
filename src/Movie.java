import java.util.concurrent.atomic.AtomicInteger;

public class Movie {
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(1000);
    private final int id;
    private String title;
    private int duration;
    private String genres;

    public Movie(String title, int duration, String genres) {
        id = ID_GENERATOR.getAndIncrement();
        this.title = title;
        this.duration = duration;
        this.genres = genres;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public String getGenres() {
        return genres;
    }
}
