/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadoraveiculos;

/**
 *
 * @author elyston
 */
public class carro {
    public String marca;
    public int ano, quantidade;;
    public String modelo;
    public double PLocacao;
    public double PModelo;
    
    void mostraquantidade(String nome){
        if(nome.equals(this.modelo)){
            System.out.println(this.quantidade);
        }
    }
    void inserequantidade(int qtde){
        this.quantidade = qtde;
    }
    int quantidadeLocado(carro[] c, String modelo){
        int cont = 0;
        for (carro c1 : c) {
            if (c1.modelo.equals(modelo)) {
                cont++;
            }
        }
        return cont;
    }
    
}
