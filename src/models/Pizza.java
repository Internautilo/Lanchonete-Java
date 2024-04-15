package models;

import java.time.LocalDate;

public class Pizza extends Prato {
	
	public enum Recheio implements IngredientEnum {
		MUSSARELA( 15.0  , 1.05 ),
		CALABRESA( 12.50 , 0.90 ),
		FRANGO	 ( 18.90 , 1.00 ),
		TOSCANA  ( 22.75 , 1.20 );

		private final double price;
		private final double weight;
		
		Recheio( double price , double weight ) {
			this.price = price;
			this.weight = weight;
		}
		
		public double getPrice() {
			return this.price;
		}
		
		public double getWeight() {
			return this.weight;
		}
	};
	public enum Molho implements IngredientEnum {
		TOMATE 	  ( 5.0  , 0.50 ),
		PARISIENSE( 8.0  , 0.60 ),
		PICANTE	  ( 6.75 , 0.50 );
		
		private final double price;
		private final double weight;
		
		Molho ( double price, double weight ) {
			this.price = price;
			this.weight = weight;
		}
		
		public double getPrice() {
			return this.price;
		}
		
		public double getWeight() {
			return this.weight;
		}
	};
	
	public enum Borda implements IngredientEnum {
		PADRAO	( 8.00  , 0.50 ),
		CATUPIRY( 12.45 , 0.65 ),
		CHEDDAR ( 10.50 , 0.65 );
		
		private final double price;
		private final double weight;
		
		Borda ( double price, double weight ) {
			this.price = price;
			this.weight = weight;
		}
		
		public double getPrice() {
			return this.price;
		}
		
		public double getWeight() { 
			return this.weight;
		}
	};
	
	private Recheio recheio;
	private Molho molho;
	private Borda borda;
	
	// Construct
	public Pizza( Recheio recheio, Molho molho, Borda borda ) {
		this.recheio = recheio;
		this.molho = molho;
		this.borda = borda;
		CalcularPreco();
		CalcularPeso();
		CalcularValidade();
	}
	
	// Calculate the pizza price
	private void CalcularPreco() {
		double temp = this.recheio.getPrice();
		temp += this.molho.getPrice();
		temp += this.borda.getPrice();
		this.price = temp;
	}
	
	// Calculate the ingredients weight in Kilograms
	private void CalcularPeso() {
		double peso = this.recheio.getWeight();
		peso += this.molho.getWeight();
		peso += this.borda.getWeight();
		this.weight = peso;
	}
	
	// Calculate the product expiration date
	private void CalcularValidade() {
		this.expirationDate = LocalDate.now().plusDays(2);
	}
	
}
