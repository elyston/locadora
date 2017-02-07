/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programalocadora;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import jxl.write.WriteException;

/**
 *
 * @author elyston
 */
public class sistema implements login{
    public entrada Entrada;
    public gerente G;
    public List<carro> disponiveis;
    public List<carro> reservados;
    public List<pessoa> pessoas;
    public sistema(String nome, String CPF, String RG, String phone, String end, String CNH, String CCredito, String senha, String nascimento, double Saldo) throws IOException, WriteException{
        G = new gerente(nome, CPF, RG, phone, end, CNH, CCredito, senha, nascimento, Saldo);
        disponiveis = new ArrayList<>();
        reservados = new ArrayList<>();
        pessoas = new LinkedList<>();
        Entrada = new entrada();
        
    }
    /**
     * método que valida quem está entrando no sistema
     * @param nome o usuario entra com o nome
     * @param senha o usuario entra com a senha
     * @return instrução de retorno se usuario é um administrador ou cliente registrado, o padrão é quando nao é usuário
     */
    public int validar(String nome, String senha){
        if(this.Entrada.valida(G) || nome.equals(this.G.getCPF())){
            return 0;
        }
        
        for (pessoa P : pessoas) {
            if(this.Entrada.valida(P, P.getCodigo()) || nome.equals(P.getCPF())){
                return 1;
            }
        }
        return 2;
    }
    /**
     * método responsável por efetuar o LOGIN, usei uma classe para guardar os dados do usuario e decidir como ele vai interagir com o sistema, as exceções estão lançadas no MENU1 
     * @throws IdadeMinimaException exceção relacionada à idade do cliente, está no método chamado MENU2
     * @throws CodigoErradoException exceção relacionada ao codigo do carro que se deseja alugar , está no método chamado MENU2
     * @throws ParseException exceção iniciada ao calcular a idade do cliente, está no método chamado MENU2
     * @throws RestrictionException exceção relacionada ao definir se cliente tem crédito necessário para efetuar o pagamento, está no método chamado MENU2
     */
    public void LOGAR() throws ParseException, IdadeMinimaException, CodigoErradoException, RestrictionException{
        
        Scanner input = new Scanner(System.in);
        System.out.println("menu");
        System.out.print("nome ou CPF = ");
        this.Entrada.login = input.next();
        System.out.print("senha = ");
        this.Entrada.senha = input.next();
        this.menu1();
    }
    
    /**
     * método que insere dados do usuário caso ele seja maior de idade
     * @param codigo codigo do usuário
     * @param nome nome do usuário
     * @param CPF CPF usuário
     * @param rg RG do usuário
     * @param CNH CNH do usuário
     * @param CCredito cartão do usuário
     * @param end endereço do usuário
     * @param senha senha do usuário
     * @param saldo saldo do usuário
     * @param nascimento data de nascimento do usuário
     * @param phone telefone do usuário
     * @throws ParseException exceção usada na classe PESSOA 
     */
    @Override
    public void cadastrar(int codigo, String nome, String CPF, String rg, String CNH, String CCredito, String end, String senha, double saldo, String nascimento, String phone) throws ParseException {
        pessoa A = new pessoa(codigo, nome, CPF, rg, phone, end, CNH, CCredito, senha, nascimento, saldo);
        try {
            A.setData(nascimento);
            this.pessoas.add(A);
        } catch (IdadeMinimaException e) {
            System.err.println(e.getMessage());
        } 
        
        
    }
    /**
     * método que reserva o carro para o usuário, identifica o carro pelo código e caso o codigo do carro nao for encontrado, é lançada uma exceção
     * @param v lista de carros
     * @param num codigo do carro
     * @throws CodigoErradoException exceção lançada para o código do carro
     */
    @Override
    public void reservar(List<carro> v, int num) throws CodigoErradoException{
        for (carro ob : v) {
            if(ob.codigo == num){
                this.reservados.add(ob);
                v.remove(num);
            }else{
                throw new CodigoErradoException("codigo do veiculo errado");
            }
        }
    }
    /**
     * método que acessa todos os carros
     * @param v lista de carros
     */
    @Override
    public void consultar(List<carro> v) {
        for (carro object : v) {
            System.out.println("código: "+object.codigo+"   | carro: "+object.modelo+"    | marca: "+object.marca+"   | ano: "+object.ano);
        }
    }
    /**
     * método que acessa todos os clientes
     * @param p lista de clientes
     */
    public void consultaClientes(List<pessoa> p){
        for (pessoa P : pessoas) {
            System.out.println("nome: "+P.getNome()+"   | CPF: "+P.getCPF()+"    |  nascimento: "+P.getDNascim());
        }
    }
    /**
     * método que insere dados de carro na lista 
     * @param codigo codigo do carro
     * @param marca marca do carro
     * @param modelo modelo do carro
     * @param ano ano do carro
     * @param preco preço unitário do carro
     */
    public void cadastra(int codigo, String marca, String modelo, int ano, double preco){
        this.disponiveis.add(this.cadastraCarros(codigo, marca, modelo, ano, preco));
    }
    /**
     * método que remove o carro da lista
     * @param codigo codigo do carro
     */
    public void removeCarro(int codigo){
        this.disponiveis.remove(codigo);
    }
    /**
     * método que lê um dado
     * @return retorna um tipo inteiro
     */
    
    public int leitura(){
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
    /**
     * Menu que indica quem está acessando as opções que variam dependendo de quem entrar
     * @throws IdadeMinimaException exceção relacionada à idade do cliente, está no método chamado MENU2
     * @throws CodigoErradoException exceção relacionada ao codigo do carro que se deseja alugar , está no método chamado MENU2
     * @throws ParseException exceção iniciada ao calcular a idade do cliente, está no método chamado MENU2
     * @throws RestrictionException exceção relacionada ao definir se cliente tem crédito necessário para efetuar o pagamento, está no método chamado MENU2
     */
    public void menu1() throws ParseException, CodigoErradoException, IdadeMinimaException, RestrictionException{
        int N = 0;
        do {            
            if(this.validar(this.Entrada.login, this.Entrada.senha) == 0){
                System.out.println("menu");
                System.out.println("1 - cadastrar carro");
                System.out.println("2 - cadastrar cliente");
                System.out.println("3 - reservar carro");
                System.out.println("4 - exibir carros disponiveis");
                System.out.println("5 - exibir clientes");
                System.out.println("6 - exibir carros reservados");
                System.out.println("7 - exibir relatório do gerente");
                System.out.println("8 - emitir comprovante");
                System.out.println("9 - sair");
                N = this.leitura();
                this.menu2(N);
                
            }
            if(this.validar(this.Entrada.login, this.Entrada.senha) == 1){
                System.out.println("menu");
                System.out.println("3 - reservar carro");
                System.out.println("4 - exibir carros disponiveis");
                System.out.println("8 - emitir comprovante");
                System.out.println("9 - sair");
                N = this.leitura();
                this.menu2(N);
                
            }
            if(this.validar(this.Entrada.login, this.Entrada.senha) == 2){
                System.out.println("menu");
                System.out.println("2 - cadastrar cliente");
                System.out.println("9 - sair");
                N = this.leitura();
                this.menu2(N);
                
            } 
        } while (N != 9);
        
    }
    /**
     * menu que acessa os métodos CADASTRAMENTO E RESERVA, somente o cliente registrado e o gerente poderão fazer tais procedimentos, porém o administrador é quem tem privilegios a mais
     * @param opcao recebe um tipo inteiro referente à opção selecionada no menu anterior
     * @throws IdadeMinimaException exceção relacionada à idade do cliente, uma mensagem é emitida caso seja menor de 18 anos
     * @throws CodigoErradoException exceção relacionada ao codigo do carro que se deseja alugar
     * @throws ParseException exceção iniciada ao calcular a idade do cliente
     * @throws RestrictionException exceção relacionada ao definir se cliente tem crédito necessário para efetuar o pagamento
     */
    public void menu2(int opcao) throws IdadeMinimaException, CodigoErradoException, ParseException, RestrictionException{
        int cont1 = 0,cont2 = 0, X, TUso;
        Scanner input = new Scanner(System.in);
        switch(opcao){
            case 1:
                System.out.println("adicionando carro");
                System.out.println("marca: ");              String marca = input.next(); 
                System.out.println("nome: ");               String modelo = input.next();
                System.out.println("ano: ");                int ano = input.nextInt();
                System.out.println("preço unitário: ");     double preco = input.nextDouble();
                this.cadastra(cont1, marca, modelo, ano, preco);
                cont1++;
                break;
            case 2:
                System.out.println("cadastrando cliente");
                System.out.println("nome: ");                   String N = input.next();
                System.out.println("RG: ");                     String RG = input.next();
                System.out.println("CPF: ");                    String CPF = input.next();
                System.out.println("telefone: ");               String tel = input.next();
                System.out.println("endereco: ");               String END = input.next();
                System.out.println("senha: ");                  String Senha = input.next();
                System.out.println("data de nascimento: ");     String data = input.next();
                this.cadastrar(cont2, N, CPF, RG, "#######", "#########", END, Senha, 300, data, tel);
                cont2++;
                break;
            case 3:
                System.out.println("reservando carro");
                System.out.print("entre com o codigo do usuario"); 
                int A = input.nextInt();
                System.out.println();
                this.consultar(disponiveis);
                System.out.println("entre com o codigo do carro escolhido");
                int B = this.leitura();
                this.verificaPagamento(A, B);
                this.reservar(disponiveis, B);
                
                break;
            case 4:
                System.out.println("consultando:");
                this.consultar(disponiveis);
                break;
            case 5:
                System.out.println("consultando:");
                this.consultaClientes(pessoas);
                break;
            case 6:
                System.out.println("consultando");
                this.consultar(reservados);
                break;
            case 7:
                System.out.println("RELATÓRIO DO GERENTE");
                this.G.gerente();
                break;
            case 8:    
                
        
        }
    }
    /**
     * verifica se o cliente tem fundos necessários para efetuar o pagamento
     * @param codigocliente codigo do cliente
     * @param codigocarro codigo do carro
     * @throws RestrictionException exceção que trata do fundo do cliente 
     */
    public void verificaPagamento(int codigocliente ,int codigocarro) throws RestrictionException{
        
        if(this.pessoas.get(codigocliente).getCC().getSaldo() < this.disponiveis.get(codigocarro).PModelo){
            throw new RestrictionException("saldo insuficiente para locação");
        }else{
            System.out.print("quantos dias?");
            int TUso = this.leitura();
            System.out.println();
            double F = this.disponiveis.get(codigocarro).PModelo * TUso;
            G.CC.deposita(F);
            this.pessoas.get(codigocliente).getCC().saca(F);
        }
       
    }
    /**
     * método que cadastra carros
     * @param codigo codigo do carro
     * @param marca marca do carro
     * @param modelo modelo do carro
     * @param ano ano do carro
     * @param preco preço unitário do carro
     * @return retorna classe carro
     */
    public carro cadastraCarros(int codigo, String marca, String modelo, int ano, double preco){
        carro A = new carro(marca, ano, modelo, preco, codigo);
        return A;
    }
}
