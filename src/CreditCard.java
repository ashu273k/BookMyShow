public class CreditCard implements PaymentStrategy {
    private final String cardNumber;

    public CreditCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean pay(double amount) {
        if (amount <= 0) {
            return false;
        }
        String masked = cardNumber.length() > 4
                ? "****" + cardNumber.substring(cardNumber.length() - 4)
                : cardNumber;
        System.out.println("Paid " + amount + " using Credit Card: " + masked);
        return true;
    }
}
