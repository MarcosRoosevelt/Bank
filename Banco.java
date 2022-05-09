package banco;

public interface Banco {
    public void abrirConta();

    public void fecharConta();

    public void sacar(double valor);

    public void depositar(double valor);

    public void pagarMensal();
}