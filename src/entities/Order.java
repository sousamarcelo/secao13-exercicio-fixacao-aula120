package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private static SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");

	private Date moment = new Date();
	private OrderStatus status;

	private Client client;
	private List<OrderItem> items = new ArrayList<OrderItem>();

	public Order() {
	}

	public Order(OrderStatus status, Client client) {
		
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void addOrderItems(OrderItem item) {
		items.add(item);
	}

	public void removeOrderItems(OrderItem item) {
		items.remove(item);
	}
	
	public Double total() {
		double sum = 0;
		for(OrderItem oi : items) {
			sum += oi.subTotal();
		}
		return sum;
	}
	
	

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMMARY: \n");
		sb.append("Order moment: " + sdf.format(moment)  + "\n");
		sb.append("Order status: " + getStatus() + "\n");
		sb.append("Client: " + getClient().getName() + " (" + sdf2.format(getClient().getBirthDate())  + ") " + " - " + getClient().getEmail() + "\n");
		sb.append("Order Items:\n");
		for (OrderItem oi : items) {
			sb.append(oi.getProduct().getName());
			sb.append(", $" + String.format("%.2f", oi.getPrice()) );
			sb.append(", Quantity: " + oi.getQuantity());
			sb.append(", Subtotal: " + String.format("%.2f", oi.subTotal()) + "\n");
		}
		sb.append("Total price: " + String.format("%.2f", total()));
		
		return sb.toString();
	}

}
