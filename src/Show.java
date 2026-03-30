import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.time.LocalDateTime;

public class Show {
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(1000);
    private final int id;
    private final Movie movie;
    private final LocalDateTime startTime;
    private final List<Seat> seats;
    
    public Show(Movie movie, LocalDateTime startTime, List<Seat> seats) {
        this.id = ID_GENERATOR.getAndIncrement();
        this.movie = movie;
        this.startTime = startTime;
        this.seats = new ArrayList<>(seats);
    }

    public List<Seat> getAvailableSeat() {
        List<Seat> available = new ArrayList<>();
        for (Seat seat : seats) {
            if (seat.isAvailable()) {
                available.add(seat);
            }
        }
        return available;
    }

    public boolean bookSeat(List<Seat> requestedSeats) {
        for (Seat requestedSeat : requestedSeats) {
            Seat seatInShow = findSeatById(requestedSeat.getId());
            if (seatInShow == null || !seatInShow.isAvailable()) {
                return false;
            }
        }

        for (Seat requestedSeat : requestedSeats) {
            Seat seatInShow = findSeatById(requestedSeat.getId());
            seatInShow.markBooked();
        }

        return true;
    }

    private Seat findSeatById(int seatId) {
        for (Seat seat : seats) {
            if (seat.getId() == seatId) {
                return seat;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public Movie getMovie() {
        return movie;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public List<Seat> getSeats() {
        return seats;
    }
}
