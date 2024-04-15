package models;

import java.time.LocalDate;

public class Salgado extends Prato{
	public enum Tipo implements IngredientEnum {
		ASSADO( 0.50 , 0.00 ),
		FRITO ( 0.60 , 0.01);
		
		private final double price;
		private final double weight;
		
		private Tipo( double price, double weight ) {
			this.price = price;
			this.weight = weight;
		}

		@Override
		public double getPrice() {
			return this.price;
		}

		@Override
		public double getWeight() {
			return this.weight;
		}
	};
	public enum Massa implements IngredientEnum {
		TRIGO      ( 1.00 , 0.05 ),
		QUEIJO     ( 1.50 , 0.09 ),
		KIBE       ( 1.00 , 0.07 );
		
		private final double price;
		private final double weight;
		
		private Massa( double price, double weight ) {
			this.price = price;
			this.weight = weight;
		}

		@Override
		public double getPrice() {
			return this.price;
		}

		@Override
		public double getWeight() {
			return this.weight;
		}
		
	};
	public enum Recheio implements IngredientEnum {
		FRANGO  ( 1.50 , 0.11 ),
		SALSICHA( 1.45 , 0.15 ),
		QUEIJO  ( 2.20 , 0.18 ),
		CARNE   ( 1.78 , 0.16 );
		
		
		private final double price;
		private final double weight;
		
		private Recheio( double price, double weight ) {
			this.price = price;
			this.weight = weight;
		}

		@Override
		public double getPrice() {
			return this.price;
		}

		@Override
		public double getWeight() {
			return this.weight;
		}
	};
	
	private Tipo tipo;
	private Massa massa;
	private Recheio recheio;
	
	// Construct
	public Salgado( Tipo tipo, Massa massa, Recheio recheio ) {
		this.massa = massa;
		this.tipo = tipo;
		this.recheio = recheio;
		CalcularPreco();
		CalcularPeso();
		CalcularValidade();
	}
	
	// Calculate the pizza price
	private void CalcularPreco() {
		double temp = this.recheio.getPrice();
		temp += this.massa.getPrice();
		temp += this.tipo.getPrice();
		this.price = temp;
	}
	
	// Calculate the ingredients weight in Kilograms
	private void CalcularPeso() {
		double peso = this.recheio.getWeight();
		peso += this.massa.getWeight();
		peso += this.tipo.getWeight();
		this.weight = peso;
	}
	
	// Calculate the product expiration date
	private void CalcularValidade() {
		this.expirationDate = LocalDate.now().plusDays(2);
	}
	
}
