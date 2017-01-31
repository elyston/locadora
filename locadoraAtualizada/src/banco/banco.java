/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author elyston
 */
public class banco{
    protected List<conta> contas;
    protected Map<String,conta> mapa;
    
    banco(){
        setContas(new ArrayList<>());
        setMapa(new HashMap<>());
    }
    /**
     * método que inicializa lista ligada (LinkedList) e hashmap
     */
    public void inicializaLinkedList(){
        setContas(new LinkedList<>());
        setMapa(new HashMap<>());
    }
    /**
     * método que adiciona elementos da lista e do mapa
     * @param C recebe classe conta como parãmetro
     */
    public void adiciona(conta C){
        getContas().add(C);
        getMapa().put(C.getTitular(), C);
    }
    /**
     * método que retorna classe conta caso esteja dentro da lista de contas, senão retorna null
     * @param x recebe numero para comparar com numero da conta
     * @return retorna a classe conta caso encontre dentro da lista 
     */
    public conta pega(int x){
        for (conta conta : getContas()) {
            if(conta.numero == x){
                return conta;
            }
        }
        return null;
    }
    /**
     * método que retorna total de contas
     * @return retorna tamanho da lista de contas
     */
    public int pegaTotaldeContas(){
        return this.getContas().size();
    }
    /**
     * método que retorna a conta caso o nome da pessoa se encontre dentro da lista de contas
     * @param nome recebe nome para comparação 
     * @return retorna conta da pessoa
     */
    public conta BuscaNome(String nome){
        for (conta conta : getContas()) {
            if(nome.equals(conta.getTitular())){
                this.getMapa().get(nome);
                return conta;
            }
        }
        return null;
    }

    /**
     * @return retorna lista de contas
     */
    public List<conta> getContas() {
        return contas;
    }

    /**
     * @param contas lista de contas
     */
    public void setContas(List<conta> contas) {
        this.contas = contas;
    }

    /**
     * @return retorna mapa de contas
     */
    public Map<String,conta> getMapa() {
        return mapa;
    }

    /**
     * @param mapa mapa de contas
     */
    public void setMapa(Map<String,conta> mapa) {
        this.mapa = mapa;
    }
    
    
}
