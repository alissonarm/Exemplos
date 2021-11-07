package br.com.ex.lambda;


// O lambda sempre esta atrelada a uma interface funcional. 
// Exigindo um unico método abstrato


interface Taxi {
	double reservar(String origem);
}


//class TaxiImple implements Taxi {
//
//	@Override
//	public void reservar() {
//		System.out.println("Taxi reservado");
//		
//	}
//	
//}

public class main {

	public static void main(String[] args) {
		
		//  TaxiImple tx = new TaxiImple();
		//	tx.reservar();	
		
		
		// classe anonimas
//		Taxi tx2 = new Taxi() {
//			@Override
//			public void reservar() {
//				System.out.println("Taxi reservado");
//			}
//			
//		};
//		tx2.reservar();	

		// via lambda
		Taxi tx3 = (origem) ->  {
			System.out.println("Taxi reservado" + origem);
			return 10.50;
		};
		double d = tx3.reservar("Brasilia");
		System.out.println(d);
		
	}

}
