package br.com.bytebank.banco.modelo;

import java.util.Comparator;

/**
 * Classe representa a moldura de uma conta
 * 
 * @author Nico Steppat
 *
 */
public abstract class Conta implements Comparable<Conta>{

    protected double saldo;
    private int agencia;
    private int numero;
    private Cliente titular;
    private static int total = 0;
    
    /**
     * Construtor para inicializar o objeto Conta a partir da agencia e numero.
     * 
     * @param agencia
     * @param numero
     */
    public Conta(int agencia, int numero){
        Conta.total++;
        //System.out.println("O total de contas é " + Conta.total);
        this.agencia = agencia;
        this.numero = numero;
        //this.saldo = 100;
        //System.out.println("Estou criando uma conta " + this.numero);
    }

    public abstract void deposita(double valor);

    /**
     * Valor precisa ser maior do que o saldo.
     * 
     * @param valor
     * @throws SaldoInsuficienteException
     */
    public void saca(double valor) throws SaldoInsuficienteException{
    	
        if(this.saldo < valor) {
            throw new SaldoInsuficienteException("Saldo: " + this.saldo + ", Valor: " + valor);
        } 
        
        this.saldo -= valor;       
    }

    public void transfere(double valor, Conta destino) throws SaldoInsuficienteException{
        this.saca(valor);
        destino.deposita(valor);
    }

    public double getSaldo(){
        return this.saldo;
    }

    public int getNumero(){
        return this.numero;
    }

    public void setNumero(int numero){
        if(numero <= 0) {
            System.out.println("Nao pode valor menor igual a 0");
            return;
        }
        this.numero = numero;
    }

    public int getAgencia(){
        return this.agencia;
    }

    public void setAgencia(int agencia){
       if(agencia <= 0) {
           System.out.println("Nao pode valor menor igual a 0");
           return;
       }
       this.agencia = agencia;
    }

    public void setTitular(Cliente titular){
        this.titular = titular;
    }

    public Cliente getTitular(){
        return this.titular;
    }

    public static int getTotal(){
        return Conta.total;
    }  

    /**
     * Veio de implements Comparable<Conta>
     * Define a ordem natural que sera utilizada em uma ordenação de uma lista de Contas
     * para ser utilizada listaDeContas.sort(null);
     * 
     * */
    @Override
    public int compareTo(Conta c1) {
    	return Integer.compare( this.agencia , c1.agencia );
    }
    
    @Override
    public boolean equals(Object ref) {
    	
    		Conta outra = (Conta) ref;
    		
    		if(this.agencia != outra.agencia) {
    			return false;
    		}
    		
    		if(this.numero != outra.numero) {
    			return false;
    		}
    		
    		return true;
    }
    
    @Override
	public String toString() {
		return "Numero: " + this.numero + ", Agencia: " + this.agencia;
	}

}
/**
 * @deprecated vai ser utilizado via classe anonima
 * */
class NumeroDaContaComparator implements Comparator<Conta> {

    @Override
    public int compare(Conta c1, Conta c2) {

            if(c1.getNumero() < c2.getNumero()) {
                return -1; //valor de maior importancia para a ordem(Deve ficar antes ), valores menor tem maior importancia
            }

            if(c1.getNumero() > c2.getNumero()) {
                return 1;//valor de menor importancia para a ordem, valores menor tem maior importancia
            }

        return 0;
        
        /*
         * Para utilização referencias as java.util.List, em alguma implementação
         * 
         * List<Conta> lista = new ArrayList<>();
         * lista.add(Conta); ...
         * NumeroDaContaComparator compareByNumeroConta = new NumeroDaContaComparator();
         * lista.sort(
         * 		// Aqui vai o criterio de ordenação
         * 		compareByNumeroConta);
         * */        
    }
}