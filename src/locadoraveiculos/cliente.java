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
public class cliente implements login {
    private String nome;
    private String CPF;
    private String RG;
    private String phone;
    private String end;
    private String CNH;
    private String CCredito;
    private String comprovante;
    private String senha;

    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCPF() {
        return CPF;
    }
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
    public String getRG() {
        return RG;
    }
    public void setRG(String RG) {
        this.RG = RG;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEnd() {
        return end;
    }
    public void setEnd(String end) {
        this.end = end;
    }
    public String getCNH() {
        return CNH;
    }
    public void setCNH(String CNH) {
        this.CNH = CNH;
    }
    public String getCCredito() {
        return CCredito;
    }
    public void setCCredito(String CCredito) {
        this.CCredito = CCredito;
    }
    public String getComprovante() {
        return comprovante;
    }
    public void setComprovante(String comprovante) {
        this.comprovante = comprovante;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }
    public String getSenha(){
        return this.senha;
    }
    //este método exibe pro usuário e gerente quais carros estão na reserva ou alocação
    @Override
    public void consultar(carro[] locado, int contador) {
        for(int i = 0; i < contador; i++){
            System.out.println(locado[i].modelo);
        }
    }
    //ste método mostra todos os carrose as devidas informações 
    @Override
    public void mostraCarros(carro[] c) {
        for (int i = 0; i < c.length; i++) {
            System.out.println("carro " + c[i].modelo);
            System.out.println("fabricante " + c[i].marca);
            System.out.println("preço (modelo): " + c[i].PModelo);
            for(int j = 0; j < c[i].ano.length; j++){
                System.out.println("ano " + c[i].ano[j]);
                System.out.println("preço (locação): " + c[i].PLocacao[j]);
                
            }
            for(int j = 0; j < c[i].PLocacao.length; j++){
                System.out.println("preço (locação): " + c[i].PLocacao[j]);
            }
            System.out.println("quantidade " + c[i].quantidade);
        }
    }
    //método que retorna null pois cliente não pode fazer cadastro
    @Override
    public cliente cadastro(String nome, String CPF, String rg, String CNH, String CCredito, String end, String senha) {
        try {
            throw new RestrictionException("cliente não é permitido fazer cadastro");
        } catch (RestrictionException ex) {
            System.err.println("este cliente não está autorizado a fazer esta operação");
        }
        return null;
    }
    //este método retorna à uma classe carro direcionada para reserva
    @Override
    public carro reserva(carro[] v, int numcarros, String veiculo, cliente pessoa) {
        carro c = new carro();
        for(int i = 0; i < v.length; i++){
            if(veiculo.equals(v[i].modelo)){
                c = v[i];
                System.out.println("carro reservado com sucesso");
          }
        }
        return c;
    }
}
