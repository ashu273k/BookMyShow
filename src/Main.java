import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) {
        String cityName = "Patna";
        Movie movie = new Movie("Hum Aapke Hain Koun", 90, "Family");

        List<Seat> showSeats = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            showSeats.add(new Seat(SeatType.REGULAR, SeatStatus.AVAILABLE));
        }

        Show show = new Show(movie, LocalDateTime.now().plusHours(2), showSeats);

        Screen screen1 = new Screen();
        screen1.addShow(show);

        Theatre theatre = new Theatre("Cinepolis");
        theatre.addScreen(screen1);

        City city = new City(cityName);
        city.addTheatre(theatre);

        BookingService bookingService = new BookingService();
        bookingService.addCity(city);

        List<Movie> availableMovies = bookingService.searchMovie(cityName);
        System.out.println("Movies in city: " + availableMovies.size());

        List<Show> shows = bookingService.getShows(movie, cityName);
        if (shows.isEmpty()) {
            System.out.println("No shows available");
            return;
        }

        List<Seat> seatsToBook = shows.get(0).getAvailableSeat().subList(0, 2);
        Booking booking = bookingService.book(shows.get(0), seatsToBook);
        if (booking == null) {
            System.out.println("Booking failed");
            return;
        }

        boolean paymentStatus = booking.makingPayment(new UPI("user@upi"), 400.0);
        if (paymentStatus) {
            Ticket ticket = booking.generateTicket();
            System.out.println(ticket);
        }
    }
}