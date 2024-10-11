package BillingSystem;

public class Product {
	
		private String name;
		private double price;
		private int quantity;
		// Constructor for the Product class
		public Product(String name, double price, int quantity) {
		    this.name = name;
		    this.price = price;
		    this.quantity = quantity;
		}
		// Getter for the product name
		public String getName() {
		    return name;
		}
		// Getter for the product price
		public double getPrice() {
		    return price;
		}
		// Getter for the product quantity
		public int getQuantity() {
		    return quantity;
		}
}



