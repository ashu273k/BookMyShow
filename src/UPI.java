public class UPI implements PaymentStrategy {
    private final String upiId;

    public UPI(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public boolean pay(double amount) {
        if (amount <= 0) {
            return false;
        }
        System.out.println("Paid " + amount + " using UPI: " + upiId);
        return true;
    }
}
