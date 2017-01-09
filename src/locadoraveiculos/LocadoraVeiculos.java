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
public class LocadoraVeiculos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner entre = new Scanner(System.in);
        int cont = 0;
        String nome = "julia", car, decide;
        
        cliente c = new cliente();
        cliente[] cl = new cliente[5];
        login p = new cliente();
        login g = new gerente();
        gerente ge = new gerente();
//  CLIENTE
//        carro[] q = new carro[5];
//        carro[] r = new carro[5];
//        carro[] l = new carro[5];
//        c.setNome(nome);
//        for(int i = 0; i < q.length; i++){
//            q[i] = new carro();
//            r[i] = new carro();
//            l[i] = new carro();
//        }
//        q[0].modelo = "KA"; 
//        q[1].modelo = "civic";
//        q[2].modelo = "gol";
//        q[3].modelo = "lancer";
//        q[4].modelo = "clio";
//        do{
//            p.mostraCarros(q);
//            System.out.println("escolha o carro que deseja reservar?");
//            car = entre.next();
//            System.out.println("deseja reservar este carro? s/n");
//            decide = entre.next();
//            if("s".equals(decide)) {
//                r[cont] = p.reserva(q, cont, car, c);
//                cont++;
//            }
//        }while(!"n".equals(decide));
//        System.out.println("lista de carros reservados");  
//        p.consultaReserva(r, cont);
// GERENTE
        for(int i = 0; i < cl.length; i++){
            cl[i] = new cliente();
        }
        for(int i = 0; i < 5; i++){
            System.out.println("entre com nome do cliente");
            nome = entre.next();
            cl[i].setNome(nome); 
            System.out.println("entre com o cpf");
            String CPF = entre.next();
            cl[i].setCPF(CPF);
        }
        ge.clientesRegistrados(cl);
        
    }
    
}
