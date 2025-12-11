import java.math.BigDecimal;

public class Order {
  // attribute
  private static int nextID = 0;
  private int orderID = nextID++;
  private Item[] items;

  // constructor
  public Order() {
    items = new Item[0];
  }

  public Order(Item item) {
    items = new Item[] {item};
  }

  public Order(Item... items) {
    this.items = new Item[items.length];
    for (int i = 0; i < items.length; i++) {
      this.items[i] = items[i];
    }
  }

  // method
  public void add(Item newItem) {
    Item[] newItems = new Item[items.length + 1];
    for (int i = 0; i < items.length; i++) {
      newItems[i] = this.items[i];
    }
    newItems[newItems.length - 1] = newItem;
    items = newItems;
  }

  public double amount() {
    BigDecimal totalAmount = BigDecimal.valueOf(0);
    for (Item item : items) {
      totalAmount = totalAmount.add(BigDecimal.valueOf(item.totalPrice()));
    }
    return totalAmount.doubleValue();
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append(String.format("ID: %-3d | ", orderID));
    
    if (items == null || items.length == 0) {
      builder.append("Not found! Order contains 0 item!");
    } else {
      for (int i = 0; i < items.length; i++) {
        if (items[i] != null) {
          builder.append("Item ").append(i).append(" ");
          builder.append(items[i].toString());
          if (i < items.length - 1) {
            builder.append(", ");
          }
        }
      }
    }

    return builder.toString();
  }

  public int getOrderID() {
    return orderID;
  }
}
