import java.util.List;
import java.util.ArrayList;

public class BookingService {
    private final List<City> cities;

    public BookingService() {
        this.cities = new ArrayList<>();
    }

    public void addCity(City city) {
        cities.add(city);
    }

    public List<Movie> searchMovie(String cityName) {
        List<Movie> movies = new ArrayList<>();
        City city = findCity(cityName);
        if (city == null) {
            return movies;
        }

        for (Theatre theatre : city.getTheatres()) {
            for (Screen screen : theatre.getScreens()) {
                for (Show show : screen.getShows()) {
                    if (!containsMovie(movies, show.getMovie())) {
                        movies.add(show.getMovie());
                    }
                }
            }
        }

        return movies;
    }

    public List<Show> getShows(Movie movie, String cityName) {
        List<Show> shows = new ArrayList<>();
        City city = findCity(cityName);
        if (city == null) {
            return shows;
        }

        for (Theatre theatre : city.getTheatres()) {
            for (Screen screen : theatre.getScreens()) {
                for (Show show : screen.getShows()) {
                    if (show.getMovie().getId() == movie.getId()) {
                        shows.add(show);
                    }
                }
            }
        }

        return shows;
    }

    public Booking book(Show show, List<Seat> seats) {
        if (!show.bookSeat(seats)) {
            return null;
        }
        return new Booking(show, seats, java.time.LocalDateTime.now());
    }

    private City findCity(String cityName) {
        for (City city : cities) {
            if (city.getName().equalsIgnoreCase(cityName)) {
                return city;
            }
        }
        return null;
    }

    private boolean containsMovie(List<Movie> movies, Movie targetMovie) {
        for (Movie movie : movies) {
            if (movie.getId() == targetMovie.getId()) {
                return true;
            }
        }
        return false;
    }
}
