/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programalocadora;
import banco.conta;
import banco.contacorrente;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
/**
 *
 * @author elyston
 */
public class pessoa{
    private int codigo;
    private String nome;
    private String CPF;
    private String RG;
    private String CNH;
    private String senha;
    private String comprovante;
    private String DNascim;
    private Date datafinal;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private conta CC;
    public pessoa(int codigo, String nome, String CPF, String RG, String phone, String end, String CNH, String CCredito, String senha, String nascimento, double saldo){
        this.CC = new contacorrente();
        this.setCodigo(codigo);
        this.setNome(nome);
        this.setCPF(CPF);
        this.setRG(RG);
        this.setCNH(CNH);
        this.setSenha(senha);
        this.setDNascim(nascimento);
        this.CC.setSaldo(saldo);
    }

    /**
     * @return retorna nome 
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome nome da pessoa
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return retorna CPF
     */
    public String getCPF() {
        return CPF;
    }

    /**
     * @param CPF CPF da pessoa
     */
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    /**
     * @return retorna RG da pessoa
     */
    public String getRG() {
        return RG;
    }

    /**
     * @param RG RG da pessoa
     */
    public void setRG(String RG) {
        this.RG = RG;
    }

    
    /**
     * @return retorna CNH da pessoa
     */
    public String getCNH() {
        return CNH;
    }

    /**
     * @param CNH CNH da pessoa
     */
    public void setCNH(String CNH) {
        this.CNH = CNH;
    }

    /**
     * @return retorna cartão de crédito
     */
    
    /**
     * @return retorna senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha senha 
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return retorna comprovante
     */
    public String getComprovante() {
        return comprovante;
    }

    /**
     * @param comprovante comprovante
     */
    public void setComprovante(String comprovante) {
        this.comprovante = comprovante;
    }

    /**
     * @return retorna data de nascimento
     */
    public String getDNascim() {
        return DNascim;
    }

    /**
     * @param DNascim data de nascimento
     */
    public void setDNascim(String DNascim) {
        this.DNascim = DNascim;
    }

    /**
     * @return retorna data atual
     */
    public Date getDatafinal() {
        return datafinal;
    }

    /**
     * @param datafinal data atual
     */
    public void setDatafinal(Date datafinal) {
        this.datafinal = datafinal;
    }

    /**
     * @return retorna formato de data
     */
    public SimpleDateFormat getSdf() {
        return sdf;
    }

    /**
     * @param sdf formato de data
     */
    public void setSdf(SimpleDateFormat sdf) {
        this.sdf = sdf;
    }

    /**
     * @return retorna conta
     */
    public conta getCC() {
        return CC;
    }

    /**
     * @param CC conta
     */
    public void setCC(conta CC) {
        this.CC = CC;
    }
    
    /**
     * @return retorna codigo de pessoa
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo codigo de pessoa
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    /**
     * método que calcula idade da pessoa
     * @param data recebe dados de data atual
     * @return retorna um tipo inteiro
     */
    public int calcularIdade(Date data){
        Calendar dataA = new GregorianCalendar();
        dataA.setTime(data);
        Calendar hoje = Calendar.getInstance();
        int idade = hoje.get(Calendar.YEAR) - dataA.get(Calendar.YEAR);
        dataA.add(Calendar.YEAR, idade);
        if(hoje.before(dataA)){
            idade--;
        }
        return idade;
    }
    /**
     * 
     * @return retorna data final
     */
    public Date getData(){
        return getDatafinal();
    }
    /**
     * método que define se pessoa é maior de idade ou não
     * @param Data recebe dados de data atual
     * @throws ParseException exceção usada para definir uma data temporária
     * @throws IdadeMinimaException exceção criada para ser lançada assim que a pessoa atender uma condição (se idade for menor igual a 20 anos) 
     */
    public void setData(String Data)throws ParseException,IdadeMinimaException{
        Date datatemp;
        datatemp = getSdf().parse(Data);
        int idade;
        idade = calcularIdade(datatemp);
        if(idade <= 20){
            throw new IdadeMinimaException("Não será possivel realizar o cadastro, o cliente está fora da idade minima para locação!");
        }else{
            this.setDNascim(Data);
            this.setDatafinal(datatemp);
        }
        this.setDNascim(Data);
    }

    
    

    
}
