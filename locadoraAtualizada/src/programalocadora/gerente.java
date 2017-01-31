/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programalocadora;

import banco.conta;
import banco.contacorrente;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author elyston
 */
public class gerente{

    private String nome;
    private String CPF;
    private String RG;
    private String phone;
    private String end;
    private String CNH;
    private String CCredito;
    private String senha;
    private String nascimento;
    conta CC;
    public gerente(String nome, String CPF, String RG, String phone, String end, String CNH, String CCredito, String senha, String nascimento, double Saldo){
        this.CC = new contacorrente();
        this.setNome(nome);
        this.setCPF(CPF);
        this.setEnd(end);
        this.setRG(RG);
        this.setCCredito(CCredito);
        this.setPhone(phone);
        this.setSenha(senha);
        this.setNascimento(nascimento);
        this.CC.setSaldo(Saldo);
    }
    //métodos encapsulados
    public void setNascimento(String nascimento){
        this.nascimento = nascimento;
    }
    public String getNascimento(){
        return this.nascimento;
    }
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
    public void setSenha(String senha){
        this.senha = senha;
    }
    public String getSenha(){
        return this.senha;
    }
    
    void gerente(){
        System.out.println("nome: "+this.getNome());
        System.out.println("CPF: "+this.getCPF());
        System.out.println("end: "+this.getEnd());
        System.out.println("CNH: "+this.getCNH());
        System.out.println("RG: "+this.getRG());
        System.out.println("CCredito: "+this.getCCredito());
        System.out.println("senha: "+this.getSenha());
        System.out.println("saldo na conta: "+this.CC.getSaldo());
    }
    
    

    
    
    
    

    
}

