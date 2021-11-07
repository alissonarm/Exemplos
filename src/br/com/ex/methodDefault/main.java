package br.com.ex.methodDefault;

interface Veiculo {
	String getModelo();
	void acelerar();
	void desacelerar();
	
	default String ligarAlarme() {
		return "Ligando o alarme do veiculo";
	}
	
	default String desligarrAlarme() {
		return "Desligando o alarme do veiculo";
	}
	
	static int calcularCavalosDePotencia(int rpm, int torque) {
		return (rpm*torque)/100;
	}

}


interface Alarme {

	default String ligarAlarme() {
		return "Ligando o alarme !";
	}
	
	default String desligarrAlarme() {
		return "Desligando o alarme!";
	}

}

class Carro implements Veiculo , Alarme{
	
	private String modelo;
	
	public Carro(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public String getModelo() {
		return modelo;
	}

	@Override
	public void acelerar() {
		System.out.println("O carro esta acelerando!");
	}

	@Override
	public void desacelerar() {
		System.out.println("O carro esta Desacelerando!");
		
	}

	@Override
	public String ligarAlarme() {
		// TODO Auto-generated method stub
		return Alarme.super.ligarAlarme();
	}

	@Override
	public String desligarrAlarme() {
		// TODO Auto-generated method stub
		return Alarme.super.desligarrAlarme();
	} 
	
}

public class main {

	public static void main(String[] args) {
		Carro carro = new Carro("Argos");
		System.out.println(carro.getModelo());
		
		carro.acelerar();
		carro.desacelerar();
		
		System.out.println(carro.ligarAlarme());
		System.out.println(carro.desligarrAlarme());
		
		System.out.println(Veiculo.calcularCavalosDePotencia(10, 200));
	}

}
