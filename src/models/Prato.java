package models;

import java.time.LocalDate;

public class Prato {
	protected double price;
	protected LocalDate expirationDate;
	protected double weight;
	
	public double getPrice() {
		return this.price;
	}
	
	public double getWeight() {
		return this.weight;
	}
	
	public LocalDate getExpirationDate() {
		return this.expirationDate;
	}
}
