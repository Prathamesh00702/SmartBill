package BillingSystem;

import java.io.FileWriter;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
public class ShoppingCart {
	private List<Product> items;
	private double discount;
	
	// Constructor for the ShoppingCart class
	public ShoppingCart() {
	    items = new ArrayList<>();
	    discount = 0.0;
	}
	// Add a product to the cart
	public void addItem(Product product) {
	    items.add(product);
	}
	// Remove a product from the cart based on the index
	public void removeItem(int index) {
	    items.remove(index);
	}
	// Calculate the total cost of all items in the cart after applying the discount
	public double calculateTotal() {
	    double total = 0;
	    for (Product item : items) {
	        total += item.getPrice() * item.getQuantity();
	    }
	    total -= discount;
	    return total;
	}
	// Set the discount amount
	public void setDiscount(double discount) {
	    this.discount = discount;
	}
	// Print the invoice with details of all items, the total cost, and the applied discount
	public void printInvoice() {
		System.out.print("\t\t\t****-----------Welcome to DMART MULUND---------****");
		System.out.println("\n-----------------------------------------------------------------------------------------");
		System.out.println("\t\t\t\t DMART_MULUND ");
		System.out.println("\t\t\t Mulund Goregaon link Road");
		System.out.println("\t\t\t Near Nirmal Nagar mulund(w)");
		System.out.println("\t\t\t Phone: 022-309XXXX");
		System.out.println("----------------------------------------------------------------------------------------------");
	    System.out.println("----------- INVOICE -----------");
	    System.out.println("Bill No: "+Random4DigitGenerator()+"\t\tCashier:PG/11");
	    System.out.println("Bill Dt :"+getTodayDate() +        "\tTime : "+getCurrentTime());
	    System.out.println("----------------------------------------------------------------------------------------------------------------"); 
	    for (int i = 0; i < items.size(); i++) {
	        Product item = items.get(i);
	        System.out.println((i + 1) + ". " + item.getName() + "\t$" + item.getPrice() + "\tQty: " + item.getQuantity());
	    }
	    System.out.println("-------------------------------");
	    System.out.println("Total: $" + calculateTotal());
	    System.out.println("Discount: $" + discount);
	    System.out.println("-------------------------------");
	    System.out.println("Final Bill with (GST)");
	    System.out.println("----------------------------------------------------------------------------------------------------------------");
	    System.out.println("\t\t<-- Amount Recd From Customer -->");
	    System.out.println("------------------------------------------------------------------------------------------------------------------");
	    System.out.println("Cash Recevied :");
	    System.out.println("Bil Paid by cashed : ");
	    System.out.println("====================================================================================================================");
	    System.out.println("Above price are inclusive of all taxes.This  is Computer generated  invoice and hence no signature is reqired ");
	    System.out.println("Saved  Rs "+discount +" on MRP");
	    System.out.println("==========================================================================================================================");  

	}
	public int  Random4DigitGenerator() {
	    
        Random random = new Random();
        int randomNumber = 1000 + random.nextInt(9000); // Generates a number between 1000 and 9999
        return randomNumber;
   
}

private LocalDate getTodayDate() {
        return LocalDate.now();
    }

public static String getCurrentTime() {
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    return now.format(formatter);
}	

	
	public int getCartSize() {
	    return items.size();
	}
	public Product getItem(int i) {
	    return items.get(i);
	}
	
	// Save the invoice to a file
	public void saveInvoiceToFile() {
	    try (FileWriter writer = new FileWriter("C:\\Users\\prath\\Downloads\\samartBilling\\invoice.xlsx")) {
	    		writer.write("----------- INVOICE -----------\n");
	        for (int i = 0; i < items.size(); i++) {
	            Product item = items.get(i);
	            writer.write((i + 1) + ". " + item.getName() + "\t$" + item.getPrice() + "\tQty: " + item.getQuantity() + "\n");}
	        
	        writer.write("-------------------------------\n");
	        writer.write("Total: $" + calculateTotal() + "\n");
	        writer.write("Discount: $" + discount + "\n");
	        writer.write("-------------------------------\n");
	        System.out.println("Invoice saved to file.");
	    } catch (IOException e) {
	        System.out.println("Failed to save invoice to file: " + e.getMessage());
	    }
	}
	}



