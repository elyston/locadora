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
    void login(String nome, String senha);
    void cadastro(cliente pessoa);
    void reserva(carro[] v, String veiculo, cliente pessoa);
    void consultaReserva(carro[] reserva);
    void consultaLocado(carro[] locado);
}
