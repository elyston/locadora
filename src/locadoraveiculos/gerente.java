/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadoraveiculos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author elyston
 */
public class gerente implements login{
    private String nome;
    private String senha;
    
    void setNome(String nome){
        this.nome = nome;
    }
    String getNome(){
        return this.nome;
    }
    void setSenha(String senha){
        this.senha = senha;
    }
    String getSenha(){
        return this.senha;
    }
    //o gerente cadastra o futuro cliente neste método 
    @Override
    public cliente cadastro(String nome, String CPF, String rg, String CNH, String CCredito, String end, String senha){
        cliente c = null;
        c.setNome(nome);
        c.setCPF(CPF);
        c.setCNH(CNH);
        c.setEnd(end);
        c.setRG(rg);
        c.setSenha(senha);
        return c;
    }
    //este método registra os clientes cadastrados, apenas o gerente visualizará a lista
    void clientesRegistrados(cliente[] cl){
        for(int i = 0; i < cl.length; i++){
            System.out.println("cliente: "+cl[i].getNome());
            System.out.println("CPF: "+cl[i].getCPF());
            System.out.println("RG: "+cl[i].getRG());
            System.out.println("CNH: "+cl[i].getCNH());
            System.out.println("endereço: "+cl[i].getEnd());
            System.out.println("telefone: "+cl[i].getPhone());
            
        }
    }
    //gerente não poderá fazer reserva
    @Override
    public carro reserva(carro[] v, int numcarros, String veiculo, cliente pessoa) {
        throw new UnsupportedOperationException("não poderá fazer isso"); //To change body of generated methods, choose Tools | Templates.      
    }
    //o gerente e cliente vão consultar os carros que estão disponiveis, alocados ou reservados
    @Override
    public void consultar(carro[] locado, int contador) {
        for(int i = 0; i < locado.length; i++){
            System.out.println(locado[i].modelo);
            for (int j = 0; j < contador; j++) {
                System.out.print("ano: "+locado[i].ano[j]);
                System.out.print("ano: "+locado[i].PModelo[j]);
                System.out.print("ano: "+locado[i].PLocacao[j]);
            }
        }
    }
    //espaço para buscar carros (sugestao)
    @Override
    public void mostraCarros(carro[] c) {
        for (carro c1 : c) {
            System.out.println("carro " + c1.modelo);
        }
    }
}
