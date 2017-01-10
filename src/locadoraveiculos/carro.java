/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadoraveiculos;

import java.util.Scanner;

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
    public double PModelo;
    carro(String marca, int quantidade, String modelo, double Pmodelo){
        Scanner input = new Scanner(System.in);
        this.ano = new int[quantidade];
        this.PLocacao = new double[quantidade];
        this.marca = marca;
        this.modelo = modelo;
        this.quantidade = quantidade;
        this.PModelo = Pmodelo;
        for(int i = 0; i < quantidade; i++){
            System.out.println("    ano do carro "+modelo+": ");
            this.ano[i] = input.nextInt();
            System.out.println();
            System.out.print("  valor da alocação do carro: ");
            this.PLocacao[i] = input.nextDouble();
        }
    }
    carro(){
        System.out.println("obrigado pela preferencia, volte sempre");
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
    void exibirCarros(){
        System.out.println("marca: "+this.marca);
        System.out.println("modelo: "+this.modelo);
        for (int i = 0; i < ano.length; i++) {
            System.out.print("  ano: "+this.ano[i]);
            System.out.println();
        }
        System.out.println("quantidade: "+this.quantidade);
    }
}
