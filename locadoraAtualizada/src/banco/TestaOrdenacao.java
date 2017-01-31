/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author elyston
 */
public class TestaOrdenacao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<contapoupanca> CP = new LinkedList<>();
        CP.add(new contapoupanca(5,"ana",12));
        CP.add(new contapoupanca(6,"beatriz",43));
        CP.add(new contapoupanca(4,"flavio",5));
        for (contapoupanca object : CP) {
            System.out.println("id:"+object.getNumero()+"   nome: "+object.getTitular()+"    valor: "+object.getSaldo());
        }
        Collections.sort(CP);
        System.out.println("lista organizada");
        for (contapoupanca object : CP) {
            System.out.println("id:"+object.getNumero()+"   nome: "+object.getTitular()+"    valor: "+object.getSaldo());
        }
        
        System.out.println("lista inversa");
        Collections.reverse(CP);
        for (contapoupanca object : CP) {
            System.out.println("id:"+object.getNumero()+"   nome: "+object.getTitular()+"    valor: "+object.getSaldo());
        }
        
        System.out.println("lista embaralhada");
        Collections.shuffle(CP);
        for (contapoupanca object : CP) {
            System.out.println("id:"+object.getNumero()+"   nome: "+object.getTitular()+"    valor: "+object.getSaldo());
        }
        System.out.print("lista rotativa, necessário inserir quantidade: ");
        int V = input.nextInt();
        System.out.println();
        
        Collections.rotate(CP, V);
        for (contapoupanca object : CP) {
            System.out.println("id:"+object.getNumero()+"   nome: "+object.getTitular()+"    valor: "+object.getSaldo());
        }
        
        banco Banco = new banco();
        Banco.adiciona(new contapoupanca(1,"ana",10));
        Banco.adiciona(new contapoupanca(2,"flavia",40));
        Banco.adiciona(new contapoupanca(3,"silvio",40));
        System.out.print("entre com um nome: ");
        String n = input.next();
        try {
            if(n.equals(Banco.getMapa().get(n).getTitular())){
                System.out.println("procura por nome = "+Banco.BuscaNome(n).getTitular()+" | saldo: "+Banco.BuscaNome(n).getSaldo()+" | numero: "+Banco.BuscaNome(n).getNumero());
                
            }
        } catch (NullPointerException e) {
            System.err.println("nome nao encontrado");
        }
        System.out.println("MAP de CONTAS = "+Banco.getMapa()); 
        
        
        
        
    }
    
}
