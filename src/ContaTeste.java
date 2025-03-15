import java.util.ArrayList;
import java.util.Scanner;

public class ContaTeste {
    private ArrayList<Conta> contas = new ArrayList<>();
    private Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        ContaTeste gerenciador = new ContaTeste();
        gerenciador.exibirMenu();
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\nMenu Principal");
            System.out.println("1. Cadastrar Conta");
            System.out.println("2. Consultar Conta");
            System.out.println("3. Listar Todas as Contas");
            System.out.println("4. Depositar");
            System.out.println("5. Sacar");
            System.out.println("6. Excluir Conta");
            System.out.println("9. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = Integer.parseInt(input.nextLine());

            switch (opcao) {
                case 1: cadastrarConta(); break;
                case 2: consultarConta(); break;
                case 3: listarContas(); break;
                case 4: depositar(); break;
                case 5: sacar(); break;
                case 6: excluirConta(); break;
                case 9: System.out.println("Encerrando o programa..."); break;
                default: System.out.println("Opção inválida!");
            }
        } while (opcao != 9);
    }

    private void cadastrarConta() {
        Conta novaConta = new Conta();
        System.out.print("Digite o número da conta: ");
        novaConta.setConta(input.nextLine());
        System.out.print("Digite o nome da agência: ");
        novaConta.setAgencia(input.nextLine());
        System.out.print("Digite o nome do cliente: ");
        novaConta.setNomeCliente(input.nextLine());
        contas.add(novaConta);
        System.out.println("Conta cadastrada com sucesso!");
    }

    private void consultarConta() {
        System.out.print("Digite o número da conta: ");
        String numero = input.nextLine();
        for (Conta c : contas) {
            if (c.getConta().equals(numero)) {
                c.imprimir();
                return;
            }
        }
        System.out.println("Conta não encontrada.");
    }

    private void listarContas() {
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta cadastrada.");
        } else {
            for (Conta c : contas) {
                c.imprimir();
                System.out.println("---------------------------");
            }
        }
    }

    private void depositar() {
        System.out.print("Digite o número da conta: ");
        String numero = input.nextLine();
        for (Conta c : contas) {
            if (c.getConta().equals(numero)) {
                System.out.print("Digite o valor do depósito: ");
                double valor = Double.parseDouble(input.nextLine());
                c.depositar(valor);
                System.out.println("Depósito realizado com sucesso!");
                return;
            }
        }
        System.out.println("Conta não encontrada.");
    }

    private void sacar() {
        System.out.print("Digite o número da conta: ");
        String numero = input.nextLine();
        for (Conta c : contas) {
            if (c.getConta().equals(numero)) {
                System.out.print("Digite o valor do saque: ");
                double valor = Double.parseDouble(input.nextLine());
                if (c.sacar(valor) == 1) {
                    System.out.println("Saque realizado com sucesso!");
                } else {
                    System.out.println("Saldo insuficiente!");
                }
                return;
            }
        }
        System.out.println("Conta não encontrada.");
    }

    private void excluirConta() {
        System.out.print("Digite o número da conta: ");
        String numero = input.nextLine();
        for (Conta c : contas) {
            if (c.getConta().equals(numero)) {
                contas.remove(c);
                System.out.println("Conta excluída com sucesso!");
                return;
            }
        }
        System.out.println("Conta não encontrada.");
    }
}
