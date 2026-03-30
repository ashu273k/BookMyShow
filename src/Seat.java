import java.util.concurrent.atomic.AtomicInteger;

public class Seat {
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(1000);
    private final int id;
    private final SeatType seatType;
    private SeatStatus seatStatus;

    public Seat(SeatType type, SeatStatus status) {
        this.id = ID_GENERATOR.getAndIncrement();
        this.seatType = type;
        this.seatStatus = status;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public int getId() {
        return id;
    }

    public SeatStatus getSeatStatus() {
        return seatStatus;
    }

    public boolean isAvailable() {
        return seatStatus == SeatStatus.AVAILABLE;
    }

    public void markBooked() {
        this.seatStatus = SeatStatus.BOOKED;
    }

    public void markAvailable() {
        this.seatStatus = SeatStatus.AVAILABLE;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "id=" + id +
                ", type=" + seatType +
                ", status=" + seatStatus +
                '}';
    }
}
