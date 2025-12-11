public class Customer {
  // attribute
  String name;
  private Order[] orders;
  
  // constructor
  public Customer() {
    this.name = "Default";
    this.orders = new Order[0];
  }

  public Customer(String name) {
    this.name = name;
    this.orders = new Order[0];
  }

  // method
  public double getOrderAmount(int targetOrderID) {
    return getOrder(targetOrderID).amount();
  }

  public Order getOrder(int targetOrderID) {
    for (Order order : orders) {
      if (order.getOrderID() == targetOrderID) {
        return order;
      }
    }
    return null;
  }

  public void add(Order newOrder) {
    Order[] newOrders = new Order[orders.length + 1];
    for (int i = 0; i < orders.length; i++) {
      newOrders[i] = this.orders[i];
    }
    newOrders[newOrders.length - 1] = newOrder;
    orders = newOrders;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Customer Name: " + name + "\n");
    builder.append("Order List:\n");
    for (int i = 0; i < orders.length; i++) {
      builder.append(orders[i].toString());
      if (i != orders.length - 1) {
        builder.append("\n");
      }
    }
    return builder.toString();
  }

  public String getName() {
    return name;
  }

  public Order[] getOrders() {
    return orders;
  }

  // test method
  public static void delay(int ms) {
    try {
      // Delay for ? ms
      Thread.sleep(ms); 
    } catch (InterruptedException e) {
      // Handle the InterruptedException if the thread is interrupted
      Thread.currentThread().interrupt(); // Restore the interrupted status
      System.err.println("Thread was interrupted during sleep.");
    }
  }

  // main method
  public static void main(String[] args) {
    // create customer John and his orders
    Customer john = new Customer("John");
    john.add(new Order());
    john.add(new Order(new Item(5, 3), new Item(1.5, 6), new Item(100.5, 3)));
    john.add(new Order(new Item(5, 3), new Item(1.5, 6)));
    System.out.println("\n" + john + "\n");

    // order lookup by order ID
    int targetOrderID = 1;
    Order order = john.getOrder(targetOrderID);
    if (order != null) {
      System.out.println("Order of index " + targetOrderID + " found! The order is:\n" + order);
    } else {
      System.out.println("Order not found!");
    }
    System.out.println();

    // Order.amount()
    // Customer.getOrderAmount(int orderID)
    double orderTotalAmount = john.getOrderAmount(targetOrderID);
    System.out.println("The total amount for order with index " + targetOrderID + " is: " + orderTotalAmount);





    
  }
}
