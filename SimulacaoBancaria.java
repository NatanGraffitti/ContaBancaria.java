import java.util.Scanner;
import java.text.DecimalFormat;

public class SimulacaoBancaria {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");
        double saldo = 0;
        boolean continuar = true;

        System.out.println("----- Simulação Bancária -----");

        while (continuar) {

            System.out.println("\nEscolha uma opção:");
            System.out.println("1- Depositar");
            System.out.println("2- Sacar");
            System.out.println("3- Consultar Saldo");
            System.out.println("0- Encerrar");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor a ser depositado: R$ ");
                    while (!scanner.hasNextDouble()) {
                        System.out.print("Valor inválido. Digite um valor numérico: R$ ");
                        scanner.next(); // Ignora entrada inválida
                    }
                    double deposito = scanner.nextDouble();
                    if (deposito > 0) {
                        saldo += deposito;
                        System.out.println("Saldo atualizado: R$ " + df.format(saldo));
                    } else {
                        System.out.println("Valor de depósito inválido. Digite um valor positivo.");
                    }
                    break;
                case 2:
                    System.out.print("Digite o valor a ser sacado: R$ ");
                    while (!scanner.hasNextDouble()) {
                        System.out.print("Valor inválido. Digite um valor numérico: R$ ");
                        scanner.next(); // Ignora entrada inválida
                    }
                    double saque = scanner.nextDouble();
                    if (saque > 0 && saque <= saldo) {
                        saldo -= saque;
                        System.out.println("Saldo atualizado: R$ " + df.format(saldo));
                    } else {
                        System.out.println("Saldo insuficiente para o valor de saque solicitado.");
                    }
                    break;
                case 3:
                    System.out.println("Saldo atual: R$ " + df.format(saldo));
                    break;
                case 0:
                    System.out.println("Programa encerrado.");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}
