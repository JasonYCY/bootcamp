import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public record AccountEntry(Action action, Currency currency, double amount) {
  // inner enum definition
  public enum Action {
    DEBIT,
    CREDIT;
  }
  public enum Currency {
    HKD,
    USD,
    CNY;
  }

  /*
   * Record auto generates these boilerplate codes for you
   */
  // // attribute
  // // Action action, Currency currency, double amount
  // private Action action;
  // private Currency currency;
  // private double amount;

  // // constructor
  // public AccountEntry(Action action, Currency currency, double amount) {
  //   this.action = action;
  //   this.currency = currency;
  //   this.amount = amount;
  // }

  public AccountEntry {
    if (amount < 0) throw new IllegalArgumentException("amount must be positive!");
  }

  // // getter
  // public Action getAction() {
  //   return action;
  // }

  // public Currency getCurrency() {
  //   return currency;
  // }

  // public double getAmount() {
  //   return amount;
  // }


  // main method
  public static void main(String[] args) {
    // AccountEntry entry = new AccountEntry(Action.CREDIT, Currency.USD, 100);
    // System.out.println(entry);
    // System.out.println(entry.action());
    // System.out.println(entry.currency());
    // System.out.println(entry.amount());

    List<AccountEntry> entries = new ArrayList<>(
      List.of(
        new AccountEntry(Action.CREDIT, Currency.USD, 100),
        new AccountEntry(Action.CREDIT, Currency.USD, 666),

        new AccountEntry(Action.DEBIT, Currency.USD, 90),
        new AccountEntry(Action.DEBIT, Currency.USD, 70)
      )
    );
    entries.forEach(System.out::println);
    System.out.println();

    Map<String, List<AccountEntry>> test = entries.stream()
      .collect(Collectors.groupingBy(entry -> entry.action().name()));

    test.forEach((key, value) -> {
      System.out.print("Key:");
      System.out.println("\t" + key);

      System.out.print("Value:");
      value.forEach(entry -> System.out.println("\t" + entry));
    });





  }
}