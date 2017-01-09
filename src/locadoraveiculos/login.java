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
public interface login {
    public cliente cadastro(String nome, String CPF, String rg, String CNH, String CCredito, String end, String senha);
    carro reserva(carro[] v, int numcarros, String veiculo, cliente pessoa);
    void consultar(carro[] locado, int contador);
    void mostraCarros(carro[] c);
}
