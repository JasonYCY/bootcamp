import java.math.BigDecimal;

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
  public boolean isVip() {
    return getTotalOrderAmount() >= 100_000;
  }

  public double getTotalOrderAmount() {
    BigDecimal totalAmount = BigDecimal.ZERO;
    for (Order order : orders) {
      totalAmount = totalAmount.add(BigDecimal.valueOf(order.amount()));
    }

    return totalAmount.doubleValue();
  }

  public double getOrderAmount(int targetOrderID) {
    Order targetOrder = getOrder(targetOrderID);
    if (targetOrder != null) return targetOrder.amount();
    return 0;
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



  // main method
  public static void main(String[] args) {
    // 1. Create a customer named John
    Customer john = new Customer("John");
    System.out.println("=== Creating Customer: John ===");
    System.out.println("Customer Name: " + john.getName());
    System.out.println();
    
    // 2. Create Dinner Order with various food items
    System.out.println("=== Creating Dinner Order ===");
    Order dinner = new Order();
    // Food items: price per unit, quantity
    dinner.add(new Item(12.99, 1));   // Fried Rice
    dinner.add(new Item(16.75, 1));   // Beef with Broccoli
    dinner.add(new Item(3.50, 3));    // Coca Cola (3 bottles)
    
    System.out.println("Dinner Order Details:");
    System.out.println(dinner);
    System.out.printf("Dinner Order Total: $%.2f\n", dinner.amount());
    System.out.println();
    
    // 3. Create Grocery Order using constructor with multiple items
    System.out.println("=== Creating Grocery Order ===");
    // Using constructor with multiple items
    Order groceries = new Order(
        new Item(4.99, 2),   // Milk (2 gallons)
        new Item(5.99, 1),   // Eggs (1 dozen)
        new Item(3.49, 1),   // Bread (1 loaf)
        new Item(6.99, 3)    // Apples (3 pounds)
    );
    
    System.out.println("Grocery Order Details:");
    System.out.println(groceries);
    System.out.printf("Grocery Order Total: $%.2f\n", groceries.amount());
    System.out.println();
    
    // 4. Create Electronics Order
    System.out.println("=== Creating Electronics Order ===");
    Order electronics = new Order();
    electronics.add(new Item(89.99, 1));   // Wireless Headphones
    electronics.add(new Item(19.99, 2));   // Phone Cases (2)
    electronics.add(new Item(12.99, 3));   // USB Cables (3)
    
    System.out.println("Electronics Order Details:");
    System.out.println(electronics);
    System.out.printf("Electronics Order Total: $%.2f\n", electronics.amount());
    System.out.println();
    
    // 5. Create a small order using single-item constructor
    System.out.println("=== Creating Coffee Order ===");
    Order coffee = new Order(new Item(4.50, 1));  // Single coffee
    System.out.println("Coffee Order Details:");
    System.out.println(coffee);
    System.out.printf("Coffee Order Total: $%.2f\n", coffee.amount());
    System.out.println();
    
    // 6. Add all orders to John
    System.out.println("=== Adding Orders to John ===");
    john.add(dinner);
    john.add(groceries);
    john.add(electronics);
    john.add(coffee);
    System.out.println();
    
    // 7. Display John's complete order history
    System.out.println("=== John's Complete Order History ===");
    System.out.println(john + "\n");
    
    // 8. Display John's total spending and VIP status
    System.out.println("=== Customer Summary ===");
    System.out.println("Customer: " + john.getName());
    System.out.println("Total Orders: " + john.getOrders().length);
    System.out.printf("Total Amount Spent: $%.2f\n", john.getTotalOrderAmount());
    System.out.println("VIP Status: " + (john.isVip() ? "Yes" : "No"));
    System.out.println();
    
    // 9. Demonstrate looking up specific orders
    System.out.println("=== Order Lookup Examples ===");
    
    // Look for dinner order (get its ID)
    Order[] johnsOrders = john.getOrders();
    if (johnsOrders.length > 0) {
        int dinnerOrderID = johnsOrders[0].getOrderID(); // First order is dinner
        Order foundOrder = john.getOrder(dinnerOrderID);
        if (foundOrder != null) {
            System.out.println("Found Dinner Order (ID: " + dinnerOrderID + "):");
            System.out.println("Total Amount: $" + john.getOrderAmount(dinnerOrderID));
        }
    }
    
    // 10. Try to find a non-existent order
    System.out.println("\n=== Testing Non-Existent Order ===");
    Order nonExistent = john.getOrder(999);
    if (nonExistent == null) {
        System.out.println("Order ID 999 not found (as expected)");
    }
    
    System.out.println();
    
    // 11. Add a big order to make John a VIP
    System.out.println("=== Making John a VIP ===");
    Order vipOrder = new Order();
    vipOrder.add(new Item(1200.00, 1));   // Laptop
    vipOrder.add(new Item(350.00, 10000));    // Monitors (10000)
    
    john.add(vipOrder);
    
    System.out.println("Added VIP Order:");
    System.out.println(vipOrder);
    System.out.printf("VIP Order Total: $%.2f\n", vipOrder.amount());
    System.out.println();
    
    // 12. Show updated status
    System.out.println("=== Updated Customer Summary ===");
    System.out.println("Customer: " + john.getName());
    System.out.println("Total Orders: " + john.getOrders().length);
    System.out.printf("Total Amount Spent: $%.2f\n", john.getTotalOrderAmount());
    System.out.println("VIP Status: " + (john.isVip() ? "Yes - Now a VIP!" : "No"));
    
    // 13. Show all order IDs for reference
    System.out.println("\n=== All Order IDs and Totals ===");
    for (Order order : john.getOrders()) {
        System.out.printf("Order ID: %d - Total: $%.2f\n", 
                        order.getOrderID(), order.amount());
    }
  }
}
