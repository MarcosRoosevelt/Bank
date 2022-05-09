package banco;

import java.util.Scanner;

public class BancoPrincipal extends ValidarCPF{
    public static void main(String args[]){
        ContaBanco p = new ContaBanco();
        System.out.println();

        Scanner in = new Scanner(System.in);
        byte op = -1;
        String nome, tipoConta, cpf;
        double dep, sac;
        System.out.println("-----Banco-----");
        do {
            p.entrada();
            System.out.println("Opção: ");
            op = in.nextByte();
            switch (op) {
                case 1:
                    System.out.println("Informe seu nome: ");
                    nome = in.next();
                    System.out.println("Informe seu CPF: ");
                    cpf = in.next();
                    System.out.println("Informe o tipo de conta: Conta Corrente[CC] ou Conta Poupança[CP]");
                    tipoConta = in.next();
                    System.out.println("Informe o quanto deseja depositar para abrir sua conta: R$");
                    dep = in.nextDouble();
                    p.abrirConta();
                    p.setDono(nome);
                    p.setTipo(tipoConta);
                    if ("CC".equalsIgnoreCase(tipoConta)) {
                        p.setSaldo(dep + 50);
                    } else if ("CP".equalsIgnoreCase(tipoConta)) {
                        p.setSaldo(dep + 150);
                    } else {
                        System.out.println("Opção inválida, tente novamente. Informe o tipo de conta: Conta Corrente[CC] ou Conta Poupança[CP]")
                        tipoConta = in.next();

                        if ("CC".equalsIgnoreCase(tipoConta)) {
                            p.setSaldo(dep + 50);
                        } else if ("CP".equalsIgnoreCase(tipoConta)) {
                            p.setSaldo(dep + 150);
                    }
                }
                p.setTipo(tipoConta);
                p.status();

                if (ValidarCPF.getCPF(cpf) == true) 
                    System.out.println("\nCPF: " + ValidarCPF.imprimeCPF(cpf));
                else 
                    System.out.println("Erro. CPF inválido!!\n");
                System.out.println("---------------------------");

                break;

            case 2: 
                System.out.println("Primeiro abra sua conta");
                while (op != 3) {
                    p.entrada();
                    System.out.print("Opção: ");
					op = in.nextByte();
					System.out.println("Primeiro abra sua conta");
					if (op == 1) {
						System.out.println("Informe o seu nome");
						nome = in.next();
						System.out.println("Informe seu CPF");
						cpf = in.next();
						System.out.println("Informe o tipo de conta: Conta Corrente[CC] ou Conta Poupança[CP]");
						tipoconta = in.next();
						System.out.print("Informe o quanto tu quer depositar para abrir sua conta: R$");
						dep = in.nextDouble();
						p.abrirConta();
						p.setDono(nome);
						p.setTipo(tipoconta);
						if ("CC".equalsIgnoreCase(tipoconta)) {
							p.setSaldo(dep + 50);
						} else if ("CP".equalsIgnoreCase(tipoconta)) {
							p.setSaldo(dep + 150);
						} else {
							System.out.println(
									"Opção inválida, tente novamente. Informe o tipo da conta: Conta Corrente[CC] ou Conta Poupança[CP]");
							tipoconta = in.next();

							if ("CC".equalsIgnoreCase(tipoconta)) {
								p.setSaldo(dep + 50);
							} else if ("CP".equalsIgnoreCase(tipoconta)) {
								p.setSaldo(dep + 150);
							}
						}
						p.status();
						if (ValidarCPF.getCPF(cpf) == true)
							System.out.println("\nCPF: " + ValidarCPF.imprimeCPF(cpf));
						else
							System.out.println("Erro. CPF inválido!!\n");
						System.out.println("---------------------------");
						break;   
					}
                }
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.err.println("Opção inválida! Tente novamente");
                System.exit(0);
                break;       
            }
            break;
        } while (op != 0);

        do {
            p.menu();
            System.out.println("Opção: ");
            op = in.nextByte();

            switch (op) {
                
                case 1:
                    p.fecharConta();
                    System.exit(0);
                    break;

                case 2:
                    System.out.println("Quanto deseja depositar? R$ ");
                    dep = in.nextDouble();
                    System.out.println("---------------------------");
                    p.depositar(dep);
                    System.out.println("Saldo atual: R$ " + p.getSaldo());
                    System.out.println("---------------------------");
                    break;
                case 3: 
                    System.out.println("Quanto deseja sacar? R$ ");
                    sac = in.nextDouble();
                    System.out.println("---------------------------");
                    p.sacar(sac);
                    System.out.println("Saldo atual: R$\n " + p.getSaldo());
                    System.out.println("---------------------------");
                    break;

                case 4:
                    p.pagarMensal();
                    break;

                case 5: 
                    System.out.println("---------------------------");
                    System.out.println("Saldo atual: R$ " + p.getSaldo());
                    System.out.println("---------------------------");

                case 0:
                    System.exit(0);
                    break;

                default:
                    System.err.println("Opção inválida");
                    break;
            }
        } while (op != 0);
    }
}
    