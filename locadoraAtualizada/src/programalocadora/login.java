/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programalocadora;

import java.text.ParseException;
import java.util.List;

/**
 *
 * @author elyston
 */
public interface login {
    public void cadastrar(int codigo, String nome, String CPF, String rg, String CNH, String CCredito, String end, String senha, double saldo, String nascimento, String phone)throws ParseException,IdadeMinimaException;
    public void reservar(List<carro> v, int num) throws CodigoErradoException;
    public void consultar(List<carro> v);
}
