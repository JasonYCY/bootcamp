import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Customer {
  private List<Address> addresses;

  public Customer() {
    this.addresses = new LinkedList<>();
  }

  public List<Address> getAddresses() {
    return addresses;
  }

  public void add(Address address) {
    this.addresses.add(address);
  }

  @Override
  public String toString() {
    return "Customer{" + addresses + "}";
  }





  // main method
  public static void main(String[] args) {
    Customer c1 = new Customer();
    c1.add(new Address("abc", "def"));
    c1.add(new Address("xxx", "sss"));

    Customer c2 = new Customer();
    c2.add(new Address("bbb", "aaa"));
    c2.add(new Address("mmm", "nnn"));
    c2.add(new Address("ccc", "ddd"));

    List<Customer> customers = new ArrayList<>();
    customers.add(c1);
    customers.add(c2);
    // System.out.println(customers);

    // Find all addresses (stream)
    List<Address> addressList = customers.stream()
    .flatMap(customer -> customer.getAddresses().stream())
    .collect(Collectors.toList());
    System.out.println(addressList);
    
    // Find all addresses (for loop)
    addressList.clear();
    for (Customer customer : customers) {
      for (Address address : customer.getAddresses()) {
        addressList.add(address);
      }
    }
    System.out.println(addressList);




  }
}