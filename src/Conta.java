public class Conta {
    //1. Atributos (encapsulados)
    private String conta;
    private String agencia;
    private double saldo;
    private String nomeCliente;

    //2. Gerar Getters and Setters (Alt + Insert)
    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    //3. Métodos
    public int sacar(double valor){
        if(valor <= saldo){
            saldo -= valor;
            return 1; //OK Sacou
        }
        return 0; //Nao OK
    }
    public void depositar(double valor){
        saldo += valor;
    }
    public void imprimir(){
        System.out.println("Dados do Conta:");
        System.out.println("Num. Conta: " + conta);
        System.out.println("Agencia: " + agencia);
        System.out.println("Nome Cliente: " + nomeCliente);
        System.out.println("Saldo R$: " + saldo);
    }
}