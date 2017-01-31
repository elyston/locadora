/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programalocadora;



/**
 *
 * @author elyston
 */
public class carro {
    public String marca;
    public int ano, codigo; 
    public String modelo;
    public double PModelo;
    
    carro(String marca, int ano, String modelo, double Pmodelo, int codigo){
        this.ano = ano;
        this.marca = marca;
        this.modelo = modelo;
        this.PModelo = Pmodelo;
        this.codigo = codigo;
    }
}
