import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionSummary {

    // Inner class for Transaction
    static class Transaction {
        private LocalDate date;
        private double amount;

        public Transaction(LocalDate date, double amount) {
            this.date = date;
            this.amount = amount;
        }

        public LocalDate getDate() {
            return date;
        }

        public double getAmount() {
            return amount;
        }
    }
    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
                new Transaction(LocalDate.of(2025, 8, 30), 100.50),
                new Transaction(LocalDate.of(2025, 8, 30), 200.75),
                new Transaction(LocalDate.of(2025, 8, 31), 50.00),
                new Transaction(LocalDate.of(2025, 8, 31), 75.25),
                new Transaction(LocalDate.of(2025, 9, 1), 500.00)
        );

        transactions.stream().collect(Collectors.groupingBy(Transaction::getDate, LinkedHashMap::new,Collectors.summingDouble(Transaction::getAmount))
        ).entrySet().stream().forEach(res->System.out.println(res.getKey() +" "+res.getValue()));
    }
}
