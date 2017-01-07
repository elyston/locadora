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

    @Override
    public void login(String nome, String senha) {
        
    }

    @Override
    public void cadastro(cliente pessoa) {
        try {
            throw new RestrictionException("cliente não é permitido fazer cadastro");
        } catch (RestrictionException ex) {
            System.err.println("este cliente não está autorizado a fazer esta operação");
        }
    }

    @Override
    public void reserva(carro[] v, String veiculo, cliente pessoa) {
        for (carro v1 : v) {
            if (v1.modelo.equals(veiculo)) {
                System.out.println("carro "+veiculo+" reservado para "+pessoa.nome+" com sucesso");
            }
        }
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the CPF
     */
    public String getCPF() {
        return CPF;
    }

    /**
     * @param CPF the CPF to set
     */
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    /**
     * @return the RG
     */
    public String getRG() {
        return RG;
    }

    /**
     * @param RG the RG to set
     */
    public void setRG(String RG) {
        this.RG = RG;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the end
     */
    public String getEnd() {
        return end;
    }

    /**
     * @param end the end to set
     */
    public void setEnd(String end) {
        this.end = end;
    }

    /**
     * @return the CNH
     */
    public String getCNH() {
        return CNH;
    }

    /**
     * @param CNH the CNH to set
     */
    public void setCNH(String CNH) {
        this.CNH = CNH;
    }

    /**
     * @return the CCredito
     */
    public String getCCredito() {
        return CCredito;
    }

    /**
     * @param CCredito the CCredito to set
     */
    public void setCCredito(String CCredito) {
        this.CCredito = CCredito;
    }

    /**
     * @return the comprovante
     */
    public String getComprovante() {
        return comprovante;
    }

    /**
     * @param comprovante the comprovante to set
     */
    public void setComprovante(String comprovante) {
        this.comprovante = comprovante;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }
    
    public String getSenha(){
        return this.senha;
    }

    @Override
    public void consultaReserva(carro[] reserva) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void consultaLocado(carro[] locado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
