package com.assignment.mani;


import java.util.Map;

public class Calculator {

	public static double rounding(double value) {
		return  (value * 100) / 100.00;
	}

	/**
	 * receives a collection of orders. For each order, iterates on the order lines and calculate the total price which
	 * is the item's price * quantity * taxes.
	 * 
	 * For each order, print the total Sales Tax paid and Total price without taxes for this order
	 */
	public double calculate(Map<String, Order> o) {

		double grandTotal = 0;

		// Iterate through the orders
		for (Map.Entry<String, Order> entry : o.entrySet()) {
			System.out.println("*******" + entry.getKey() + "*******");
			//grandtotal = 0;

			Order r = entry.getValue();

			double totalTax = 0;
			double total = 0;
			
			// Iterate through the items in the order
			for (int i = 0; i < r.size(); i++) {

				// Calculate the taxes
				double tax = 0;

				
				// Calculate the total price
				double totalprice = r.get(i).getItem().getPrice() + (tax);
				// Print out the item's total price
				totalprice = Math.round(totalprice*100)/100.00;
				System.out.println(r.get(i).getQuantity()+" "+r.get(i).getItem().getDescription() + ": " + totalprice);

				// Keep a running total
				totalTax += tax;
				total += totalprice;
			}

			// Print out the total taxes
			//System.out.println("totalTax:"+totalTax+" roundedTotalTax:"+Math.round(totalTax*100)/100.00);
			totalTax = Math.round(totalTax*100)/100.00;
			System.out.println("Sales Tax: " + totalTax);
			total = total - totalTax;

			// Print out the total amount
			total = Math.round(total * 100) / 100.00;
			System.out.println("Total: " + total);
			grandTotal += total;
		}
		grandTotal = Math.floor(grandTotal * 100) / 100;
		System.out.println("Sum of orders: " + grandTotal);
		return grandTotal;
	}
}

