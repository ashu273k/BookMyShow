import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.time.LocalDateTime;

public class Booking {
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(1000);
    private final int id;
    private final Show show;
    private final List<Seat> seats;
    private final LocalDateTime bookingTime;

    Booking(Show show, List<Seat> seats, LocalDateTime bookingTime) {
        this.id = ID_GENERATOR.getAndIncrement();
        this.show = show;
        this.seats = seats;
        this.bookingTime = bookingTime;
    }

    public Ticket generateTicket() {
        return new Ticket(id, show.getMovie().getTitle(), show.getStartTime(), seats);
    }

    public boolean makingPayment(PaymentStrategy paymentStrategy, double amount) {
        Payment payment = new Payment(paymentStrategy);
        return payment.pay(amount);
    }

    public int getId() {
        return id;
    }

    public Show getShow() {
        return show;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }
}
