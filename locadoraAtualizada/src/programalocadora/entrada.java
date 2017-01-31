/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programalocadora;

import java.util.List;

/**
 *
 * @author elyston
 */
public class entrada {
    String login, senha;
    
    public boolean valida (gerente G){
        return this.login.equals(G.getNome()) && this.senha.equals(G.getSenha());
    }
    public boolean valida (pessoa cliente, int num){
        return this.login.equals(cliente.getNome()) && this.senha.equals(cliente.getSenha());
    }
}
