package main;

public class Inventory {
	private String name;
	private int id;
	private int quantity;
	private double price;
	
	public Inventory(String myName, int myQuantity, double myPrice, int myId) {
		this.name = myName;
		this.quantity = myQuantity;
		this.price = myPrice;
		this.id = myId;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int newQuantity) {
		this.quantity = newQuantity;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String newName) {
		this.name = newName;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double newPrice) {
		this.price = newPrice;
	}
	
	public double calculation() {
		return this.price * this.quantity;
	}
	
	public boolean search(int myId) {
		if (this.id == myId)
			return true;
		else
			return false;
	}
}
