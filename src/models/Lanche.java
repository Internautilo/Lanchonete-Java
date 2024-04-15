package models;

import java.time.LocalDate;

public class Lanche extends Prato {
	public enum TipoPao implements IngredientEnum {
		BRIOCHE  ( 3.00 , 0.15 ),
		ARTESANAL( 5.75 , 0.25),
		INTEGRAL ( 4.98 , 0.20);
		
		private final double price;
		private final double weight;
		
		private TipoPao( double price, double weight ) {
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
		HAMBURGUER( 6.75 , 0.20 ),
		FRANGO    ( 5.45 , 0.25 ),
		BACON	  ( 7.80 , 0.20 );
		
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
	public enum Molho implements IngredientEnum {
		TOMATE  ( 2.00 , 0.10),
		BARBECUE( 3.25 , 0.12),
		ESPECIAL( 4.20 , 0.15);
		
		private final double price;
		private final double weight;
		
		private Molho( double price, double weight ) {
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
	}
	
	private TipoPao tipoPao;
	private Recheio recheio;
	private Molho molho;
	
	// Construct
	public Lanche( TipoPao tipoPao, Recheio recheio, Molho molho ) {
		this.recheio = recheio;
		this.molho = molho;
		this.tipoPao = tipoPao;
		CalcularPreco();
		CalcularPeso();
		CalcularValidade();
	}
	
	// Calculate the pizza price
	private void CalcularPreco() {
		double temp = this.recheio.getPrice();
		temp += this.molho.getPrice();
		temp += this.tipoPao.getPrice();
		this.price = temp;
	}
	
	// Calculate the ingredients weight in Kilograms
	private void CalcularPeso() {
		double peso = this.recheio.getWeight();
		peso += this.molho.getWeight();
		peso += this.tipoPao.getWeight();
		this.weight = peso;
	}
	
	// Calculate the product expiration date
	private void CalcularValidade() {
		this.expirationDate = LocalDate.now().plusDays(2);
	}
	
}
