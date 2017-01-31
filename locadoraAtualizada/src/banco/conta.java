/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

/**
 *
 * @author elyston
 */
public abstract class conta {
    protected String titular;
    protected double saldo;
    protected int numero;
    public conta(int num, String nome, double saldo){
        this.setTitular(nome);
        this.setNumero(num);
        this.setSaldo(saldo);
    }
    public conta(){
        
    }
    /**
     * @return the numero
     */
    public abstract int getNumero();
    /**
     * @param numero the numero to set
     */
    public abstract void setNumero(int numero);
    public abstract double getSaldo();
    public abstract void setSaldo(double saldo);
    public abstract void atualiza(double taxa);
    public abstract String getTitular();
    public abstract void setTitular(String titular);
    
    public void deposita(double dinheiro) {
        this.saldo += dinheiro;
    }
    public void saca(double dinheiro){
        this.saldo -= dinheiro;
    }

    
    
    
}
