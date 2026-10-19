package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Carro;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("========== Alguel de Carro ===========");
		System.out.println("Qual o modelo do carro: ");
		String modelo = sc.nextLine();
		System.out.println("Qual a placa do carro: ");
		String placa = sc.nextLine();
		System.out.println("Qual o preço da diária desse veículo: ");
		double diaria = sc.nextDouble();

		Carro carro = new Carro(modelo, placa, diaria);

		int escolha = 0; 
		while (escolha != 4) {
			
			System.out.println("\nOpção 1 - Exibir Detalhes \nOpção 2 - Simular Aluguel \nOpção 3 - Confirmar Locação \nOpção 4 - Sair do programa");
			System.out.print("Escolha uma opção: ");
			escolha = sc.nextInt();
			sc.nextLine();

			switch (escolha) {
				case 1:
					System.out.println(carro);
					break;
					
				case 2:
					System.out.println("Quantos dias a pessoa quer alugar? ");
					int dias = sc.nextInt();
					sc.nextLine();
					
					double valorTotal = carro.calcularAluguel(dias);
					System.out.printf("Valor total do aluguel: R$ %.2f%n", valorTotal);
					break;
					
				case 3:
					if(carro.alugarCarro() == true) {
						System.out.println("✅ Carro alugado com sucesso!");
					}else{
						System.out.println("❌ Este carro já está alugado!");
					};
					break;
					
				case 4:
					System.out.println("Saindo do sistema...");
					break;
					
				default:
					System.out.println("❌ Opção inválida!");
					break;
			}
		}


		sc.close();

	}

}
