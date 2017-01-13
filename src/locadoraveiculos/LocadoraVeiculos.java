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
//        int cont = 0, c = 0;
        String nome, senha,dec,CL = null;
        double juros = 0.12;
        gerente Q = new gerente("elyston", "788 476 212-91", "200 737", "99121 2861", "al. dos bambus", "###", "123 456", "123", 32, 0, "12 746 12 - RR");
        cliente[] C = new cliente[100];
        carro[] Carro = new carro[5];
        carro[] reserva = new carro[5];
        int cont1 = 0, cont2 = 0, cont3 = 0;
        login P1;
        System.out.println("login:");
        System.out.print("nome: ");        nome = entre.next();
        System.out.println();
        System.out.print("senha: ");        senha = entre.next();
        //área do administrador
        if(nome.equals(Q.getNome()) && senha.equals(Q.getSenha())){
//            Q.gerente();
              P1 = Q;
              
              do{
                  System.out.print("entre com a marca do carro: ");     String M = entre.next();    System.out.println();
                  System.out.print("entre com a quantidade do carro: ");  int quant = entre.nextInt();   System.out.println();
                  System.out.print("entre com o modelo do carro: ");   String N = entre.next(); System.out.println();
                  System.out.print("entre com o valor do modelo: ");    double Valor = entre.nextDouble(); System.out.println();
                  Carro[cont1] = new carro(M, quant, N, Valor);
                  System.out.print("deseja cadastrar outro modelo de carro s/n: "); dec = entre.next(); 
                  cont1++;
              }while(cont1 < Carro.length && "s".equals(dec));
              for (int i = 0; i < cont1; i++) {
                  Carro[i].consulta();
              }
              do{
                  System.out.print("nome: ");     String N = entre.next();    System.out.println();
                  System.out.print("endereço: ");  String End = entre.next();   System.out.println();
                  System.out.print("rg: ");   String rg = entre.next(); System.out.println();
                  System.out.print("CPF: ");    String cpf = entre.next(); System.out.println();
                  System.out.print("CNH: ");     String cnh = entre.next();    System.out.println();
                  System.out.print("numero do cartão de credito: ");  String CC = entre.next();   System.out.println();
                  System.out.print("idade: ");   int idade = entre.nextInt(); System.out.println();
                  System.out.print("senha: ");    String S = entre.next();  System.out.println();
                  System.out.print("agencia: ");    String A = entre.next();  System.out.println();
                  System.out.print("telefone contato: ");    String phone = entre.next();  System.out.println();
                  System.out.print("saldo em conta: ");    double dinheiro = entre.nextDouble();  System.out.println();
                  C[cont2] = new cliente(N, cpf, rg, phone, End, cnh, CC, senha, idade, A, dinheiro);
                  System.out.print("deseja cadastrar outro cliente? s/n: "); dec = entre.next(); 
                  cont2++;
              }while(cont2 < C.length && "s".equals(dec));
              for (int i = 0; i < cont2; i++) {
                  C[i].cliente();
              }
              do{
                  System.out.println("qual o seu nome?");
                  String NOME = entre.next();
                  for (int i = 0 ; i < cont2 ; i++) {
                    if(NOME.equals(C[i].getNome())){
                        System.out.println("deseja reservar o carro? s/n");
                        CL = entre.next();
                        if("s".equals(CL)){
                              for(int j = 0; j < cont1; j++){
                                    Carro[i].consulta();
                                    System.out.print("que modelo de carro deseja reservar? "); String MCarro = entre.next();  System.out.println();
                                    System.out.print("quantos carros deseja reservar "); int QCarro = entre.nextInt();  System.out.println();
                                    if(MCarro.equals(Carro[i].modelo) && QCarro <= cont1){
                                        reserva[cont3] = new carro();
                                        reserva[cont3] = Carro[i];
                                        reserva[cont3].quantidade = QCarro;
                                        Q.pagamento(C[i], Carro[j].PModelo, juros);
                                        cont3++;
                                        System.out.println("reserva feita com sucesso");
                                        System.out.println("saldo do cliente: "+C[j].C.getSaldo());
                                    }
                              }
                        }
                          
                        System.out.println("saldo do gerente: "+Q.C.getSaldo());
                    }
                      
                  }
              }while(cont3 < cont2 && "n".equals(CL));
              System.out.println("numero de carros reservados");
              for (int k = 0; k < cont3; k++) {
                  reserva[k].consulta();
              }
        }
        //área do cliente
    }
}
