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
    public int[] ano; 
    public int quantidade;;
    public String modelo;
    public double[] PLocacao;
    public double[] PModelo;
    
    //o gerente insere a quantidade de carros disponiveis
    void inserequantidade(int qtde){
        this.quantidade = qtde;
    }
    //este método retorna pro método abaixo na sequencia quantos carros foram alocados
    int quantidadeDisponivel(int cont){
        this.quantidade =- cont;
        return cont;
    }
    //este método indica pro cliente quantos carros estão disponiveis
    void mostraquantidade(int cont){
        System.out.println("quantidade: "+this.quantidadeDisponivel(cont));
    }
}
