package applicatin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Order order = null;
		
		
		System.out.println("Enter cliente data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birth = sdf.parse(sc.next()) ;
		Client client = new Client(name, email, birth);		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		String status = sc.next();
		order = new Order(OrderStatus.valueOf(status) , client);
		
		
		
		System.out.print("How many items to this order?: ");
		int Qdadeitms = sc.nextInt();
		for (int i = 1; i <= Qdadeitms; i++) {
			System.out.println("Enter #" + i + " item data:");
			sc.nextLine();
			System.out.print("Product name: ");
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			Double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			Integer productQuantity = sc.nextInt();
			OrderItem orderItem = new OrderItem(productQuantity, productPrice, new Product(productName, productPrice));
			order.addOrderItems(orderItem);
		}
		
		System.out.println();
		System.out.println(order);		
		
		sc.close();

	}

}
