import java.math.BigDecimal;

public class Item {
  // attribute
  private double price;
  private double quantity;

  // constructor
  public Item(double price, double quantity) {
    this.price = price;
    this.quantity = quantity;
  }

  // method
  public double totalPrice() {
    return BigDecimal.valueOf(price).multiply(BigDecimal.valueOf(quantity)).doubleValue();
  }

  @Override
  public String toString() {
    return String.format("(price: %.2f, quantity: %.2f)", price, quantity);
  }
}