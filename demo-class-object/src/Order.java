import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order {
  // attribute
  private static int nextID = 0;
  private int orderID = nextID++;
  private LocalDateTime orderDateTime = LocalDateTime.now();
  private String productName;
  private String boughtBy;
  private double price;

  // constructor
  public Order() {
    this.productName= "Test Order";
    this.boughtBy = "Unknown";
    this.price = 0;
  }

  public Order(String productName, double price, String boughtBy) {
    this.productName= productName;
    this.boughtBy = boughtBy;
    this.price = price;
  }

  // method
  @Override
  public String toString() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd (HH:mm:ss)");
    String formattedDateTime = orderDateTime.format(formatter);

    return String.format(
      "ID: %-3d | Order Time: %-22s | Product: %-15s | Price: %-10.2f | Bought By: %-20s",
      orderID, 
      formattedDateTime, 
      productName, 
      price, 
      boughtBy
    );
  }

  public int getOrderID() {
    return orderID;
  }
}
