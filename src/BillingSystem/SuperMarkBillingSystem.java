package BillingSystem;

import java.util.Scanner;

public class SuperMarkBillingSystem {
	
	private static Scanner scanner = new Scanner(System.in);
	private static ShoppingCart cart = new ShoppingCart();
	 
	// Entry point of the program
	public static void main(String[] args) {
	    showMenu();
	}
	// Display the main menu and handle user input
	private static void showMenu() {
	    int choice;
	   
	    do {
	        System.out.println("----------------------------------- Supermarket Billing System  -----------------------------------------------------------------");
	        System.out.println("1. Add item to cart");
	        System.out.println("2. Remove item from cart");
	        System.out.println("3. View cart");
	        System.out.println("4. Apply discount");
	        System.out.println("5. Generate invoice");
	        System.out.println("6. Download invoice");
	        System.out.println("7. Bill Paid(online/cash)");
	        System.out.println("8. Exit");
	        System.out.println("-------------------------------------------------------------------------------------------------------------");
	        System.out.print("Enter your choice: ");
	        choice = scanner.nextInt();
	        switch (choice) {
	            case 1:
	                addItemToCart();
	                break;
	            case 2:
	                removeItemFromCart();
	                break;
	            case 3:
	                viewCart();
	                break;
	            case 4:
	                applyDiscount();
	                break;
	            case 5:
	                generateInvoice();
	                break;
	            case 6:
	                downloadInvoice();
	                break;
	           
	            case 7:
	            	 System.out.println("Thank you for using the Supermarket Billing System by Dmart ..!");
		                break;
	            default:
	                System.out.println("Invalid choice. Please try again.");
	                break;
	        }
	    } while (choice != 8);
	}

	// Add an item to the cart based on user input
	private static void addItemToCart() {
	    System.out.print("Enter product name: ");
	    String name = scanner.next();
	    System.out.print("Enter price: ");
	    double price = scanner.nextDouble();
	    System.out.print("Enter quantity: ");
	    int quantity = scanner.nextInt();
	    Product product = new Product(name, price, quantity);
	    cart.addItem(product);
	    System.out.println("Item added to cart!");
	}
	// Remove an item from the cart based on user input
	private static void removeItemFromCart() {
	    System.out.print("Enter item number to remove: ");
	    int index = scanner.nextInt();
	    if (index >= 1 && index <= cart.getCartSize()) {
	        cart.removeItem(index - 1);
	        System.out.println("Item removed from cart!");
	    } else {
	        System.out.println("Invalid item number.");
	    }
	}
	// View the current items in the cart along with the total cost
	private static void viewCart() {
	    if (cart.getCartSize() > 0) {
	        System.out.println("------ Cart Items ------");
	        for (int i = 0; i < cart.getCartSize(); i++) {
	            Product item = cart.getItem(i);
	            System.out.println((i + 1) + ". " + item.getName() + "\t$" + item.getPrice() + "\tQty: " + item.getQuantity());
	        }
	        System.out.println("------------------------");
	        System.out.println("Total: Rs" + cart.calculateTotal());
	        System.out.println("------------------------");
	    } else {
	        System.out.println("Cart is empty.");
	    }
	}
	// Apply a discount to the total cost based on user input
	private static void applyDiscount() {
	    System.out.print("Enter discount amount: ");
	    double discount = scanner.nextDouble();
	    cart.setDiscount(discount);
	    System.out.println("Discount applied!");
	}
	// Generate an invoice for the current cart and clear the cart
	private static void generateInvoice() {
	    if (cart.getCartSize() > 0) {
	        cart.printInvoice();
	        cart = new ShoppingCart();  // Clear the cart after generating the invoice
	    } else {
	        System.out.println("Cart is empty. Cannot generate invoice.");
	    }
	}
	// Download the invoice as a file
	private static void downloadInvoice() {
	    if (cart.getCartSize() > 0) {
	        cart.saveInvoiceToFile();
	        cart = new ShoppingCart();  // Clear the cart after downloading the invoice
	    } else {
	        System.out.println("Cart is empty. Cannot download invoice.");
	    }
	}
}


