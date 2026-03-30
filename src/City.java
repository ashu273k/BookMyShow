import java.util.ArrayList;
import java.util.List;

public class City {
    private final String name;
    private final List<Theatre> theatres;

    City(String name) {
        this.name = name;
        this.theatres = new ArrayList<>();
    }

    public void addTheatre(Theatre theatre) {
        theatres.add(theatre);
    }

    public List<Theatre> getTheatres() {
        return new ArrayList<>(theatres);
    }

    public String getName() {
        return name;
    }

}
