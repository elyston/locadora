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
public class contapoupanca extends conta implements Comparable<contapoupanca>{
    public contapoupanca(int num, String nome, double saldo) {
        super(num, nome, saldo);
    }
    public contapoupanca(){
        
    }
    @Override
    public double getSaldo() {
        return saldo;
    }

    @Override
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public void deposita(double dinheiro) {
        super.deposita(dinheiro);
    }

    @Override
    public void saca(double dinheiro) {
        super.saca(dinheiro);
    }
    
    @Override
    public void atualiza(double taxa) {
        this.saldo += (this.saldo * 3 * taxa);
    }

    @Override
    public int compareTo(contapoupanca outra) {
        return this.getNumero()-outra.getNumero();
    }
    
    @Override
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    @Override
    public void setNumero(int numero) {
        this.numero = numero;
    }
    /**
     * @return the titular
     */
    @Override
    public String getTitular() {
        return titular;
    }

    /**
     * @param titular the titular to set
     */
    @Override
    public void setTitular(String titular) {
        this.titular = titular;
    }
}
