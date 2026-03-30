import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class Ticket {
    private final int bookingId;
    private final String movieTitle;
    private final LocalDateTime showTime;
    private final List<Seat> seats;

    public Ticket(int bookingId, String movieTitle, LocalDateTime showTime, List<Seat> seats) {
        this.bookingId = bookingId;
        this.movieTitle = movieTitle;
        this.showTime = showTime;
        this.seats = seats;
    }

    @Override
    public String toString() {
        String seatIds = seats.stream()
                .map(seat -> String.valueOf(seat.getId()))
                .collect(Collectors.joining(", "));
        return "Ticket{" +
                "bookingId=" + bookingId +
                ", movie='" + movieTitle + '\'' +
                ", showTime=" + showTime +
                ", seats=[" + seatIds + "]" +
                '}';
    }
}
