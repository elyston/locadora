/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadoraveiculos;

/**
 *
 * @author elyston
 */
public class gerente extends funcionario implements login{
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
    
    @Override
    public void login(String nome, String senha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cadastro(cliente pessoa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void reserva(carro[] v, String veiculo, cliente pessoa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
