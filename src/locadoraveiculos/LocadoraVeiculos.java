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
        String nome, senha , car, decide;
        gerente ge = new gerente();
        cliente[] cl = new cliente[5];
        carro[] q = new carro[100];
        carro[] r = new carro[100];
        carro[] l = new carro[100];
        ge.setNome("elyston");
        ge.setSenha("123");
        System.out.println("login:");
        System.out.print("nome: ");        nome = entre.next();
        System.out.println();
        System.out.print("senha: ");        senha = entre.next();
        if(nome.equals(ge.getNome()) && senha.equals(ge.getSenha())){
            String nCarro, mCarro; 
            int ano, qt;
            double pLoca, pModelo;
            login p = new gerente();
            
            do{
                System.out.println("o que deseja fazer?");
                System.out.println("1 - cadastrar carros");
                System.out.println("2 - cadastrar clientes");
                System.out.println("3 - consultar veiculos disponiveis");
                System.out.println("4 - sair");
                decide = entre.next();
                switch(decide){
                    case "1":
                                System.out.println("quantos carros deseja cadastrar?");
                                qt = entre.nextInt();
                                for (int i = 0; i < qt; i++) {
                                    
                                    System.out.print("entre com o modelo do carro: ");      nCarro = entre.next();
                                    System.out.println();
                                    System.out.print("entre com o marca do carro: ");      mCarro = entre.next();
                                    System.out.println();
                                    System.out.print("entre com o preço por modelo: ");      pModelo = entre.nextDouble();
                                    System.out.println();
                                    q[i] = new carro(mCarro, qt, nCarro, pModelo);
                                }
                                for (int i = 0; i < qt; i++) {
                                    q[i].exibirCarros();
                                }
                                break;
                    case "2":
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
                                break;
                    case "3":   
                                
                }
            }while(!"4".equals(decide));
            
        }else{
            for(int i = 0; i < cl.length; i++){
                if(nome.equals(cl[i].getNome()) && senha.equals(cl[i].getSenha())){
                login p = new cliente();
                
                System.out.println();
                q[0].modelo = "KA"; 
                q[1].modelo = "civic";
                q[2].modelo = "gol";
                q[3].modelo = "lancer";
                q[4].modelo = "clio";
                do{
                    p.mostraCarros(q);
                    System.out.println("escolha o carro que deseja reservar?");
                    car = entre.next();
                    System.out.println("deseja reservar este carro? s/n");
                    decide = entre.next();
                    if("s".equals(decide)) {
                        r[cont] = p.reserva(q, cont, car, cl[i]);
                        cont++;
                    }
                }while(!"n".equals(decide));
                System.out.println("lista de carros reservados");  
                p.consultar(r, cont);
            }else{
                System.out.println("usuario nao cadastrado");
            }
            
            }
        }
        
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
//        for(int i = 0; i < cl.length; i++){
//            cl[i] = new cliente();
//        }
//        for(int i = 0; i < 5; i++){
//            System.out.println("entre com nome do cliente");
//            nome = entre.next();
//            cl[i].setNome(nome); 
//            System.out.println("entre com o cpf");
//            String CPF = entre.next();
//            cl[i].setCPF(CPF);
//        }
//        ge.clientesRegistrados(cl);
        
    }
    
}
