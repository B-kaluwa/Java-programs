import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CustomerServiceSystemDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerServiceSystem system = new CustomerServiceSystem();

        System.out.println("Welcome to the Customer Service System");
        System.out.println("=====================================");

        while (true) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Add a customer");
            System.out.println("2. Display all customers");
            System.out.println("3. Quit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                    System.out.println("\nEnter customer details:");
                    System.out.print("Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    System.out.print("Issue: ");
                    String issue = scanner.nextLine();

                    Customer customer = new Customer(name, email, issue);
                    system.addCustomer(customer);
                    break;

                case 2:
                    system.displayCustomers();
                    break;

                case 3:
                    System.out.println("Exiting the program...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

class Customer {
	
    private String name;
    private String email;
    private String issue;

    public Customer(String name, String email, String issue) {
        this.name = name;
        this.email = email;
        this.issue = issue;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getIssue() {
        return issue;
    }

}

class CustomerServiceSystem {
	
    private List<Customer> customers;

    public CustomerServiceSystem() {
        customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
        System.out.println("Customer added to the system.");
    }

    public void displayCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers in the system.");
        } else {
            System.out.println("Customers in the system:");
            for (Customer customer : customers) {
                System.out.println("Name: " + customer.getName());
                System.out.println("Email: " + customer.getEmail());
                System.out.println("Issue: " + customer.getIssue());
                System.out.println("---------------------------");
            }
        }
    }

}

