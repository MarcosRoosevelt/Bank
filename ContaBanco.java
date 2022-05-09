package banco;

import java.util.Scanner;

public class ContaBanco extends Datar implements Banco {

    private String dono;
    private String tipo;
    private double saldo;
    private boolean status;

    public void status() {
        Random aleat = new Random();
        int numeroConta = aleat.nextInt(9999);
        System.out.println("--------------------------")
        System.out.println("Tipo: " + this.getTipo().toUpperCase());
        System.out.println("Dono: " + this.getDono().toUpperCase());
        System.out.println("Número da conta: " + numeroConta);
        System.out.println("Data em que foi aberta: " + formataData.format(datar));
        System.out.println("Horário em que foi aberta: " + hora.format(datar));
        System.out.println("Saldo: " + this.getSaldo());
        System.out.println("Status: " + this.getStatus());
    }

    public void entrada() {
        System.out.println("[1] - Abrir conta");
        System.out.println("[2] - Entrar na conta");
        System.out.println("[0] - Sair");
    }

    public void menu() {
        System.out.println("Procedimentos:");
        System.out.println("[1] - Fechar conta");
        System.out.println("[2] - Depositar");
        System.out.println("[3] - Sacar");
        System.out.println("[4] - Pagar mensalidade");
        System.out.println("[5] - Ver saldo");
        System.out.println("[0] - Sair");
    }

    @Override
    public void abrirConta() {
        this.setTipo(this.getTipo());
        this.setStatus(true);
        System.out.println("---------------");
        System.out.println("Conta aberta com sucesso");
    }

    @Override
    public void fecharConta() {
        if (this.getSaldo() > 0){
            System.err.println("Conta não pode ser fechada, pois ainda possui saldo");
        } else if (this.getSaldo() < 0) {
            system.err.println("Conta não pode ser fechada, pois está em débito");
        } else {
            this.setStatus(false);
            System.out.println("Conta fechada com sucesso");
        }
    }

    @Override
    public void depositar(double valor) {
        if (this.getStatus()) {
            this.setSaldo(this.getSaldo() + valor);
            System.out.println("Depósito realizado com sucesso na conta de " + this.getDono());
        } else {
            system.err.println("Impossível depositar");
        }
    }

    @Override
    public void sacar(double valor) {
        if (this.getStatus()) {
            if (this.getSaldo() >= valor) {
                this.setSaldo(this.getSaldo() - valor);
                System.out.println("Saque realizado na conta de " + this.getDono());
            } else {
                system.err.println("Saldo insuficiente");
            }
        } else {
            system.err.println("Impossível sacar");
        }
    }

    @Override
    public void pagarMensal() {
        int v = 0;
        if ("CC".equals(this.getTipo())) {
            v = 12;
        } else if ("CP".equals(this.getTipo())) {
            v = 20;
        }
        if (this.getStatus()) {
            this.setSaldo(this.getSaldo() - v);
            System.out.println("Mensalidade paga com sucesso por " + this.getDono());
        } else {
            system.err.println("Impossível pagar uma conta fechada");
        }
    }

    public ContaBanco() {
        this.setSaldo(0);
        this.setStatus(false);
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDono() {
        return this.dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public String getSaldo() {
        return this.saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}