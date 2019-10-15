/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contacorrente;

import java.util.ArrayList;
import java.util.Scanner;

public final class ContaCorrente {

    
    
    private String banco = ""; // str
    private String numero = "";// str
    private float saldoIni = 0;
    private String agencia = "";// str
    private boolean ativa = true;
    private float saldo = 0;
    private Movimentacao extrato = new Movimentacao();        
    private ArrayList extratos = new ArrayList<Movimentacao>();
    
    
    
    public ContaCorrente(String numero, String banco, float saldoIni,String agencia ,boolean ativa , float saldo) {
             
     this.setNumero(numero);
     this.setBanco(banco);
     this.setSaldoIni(saldoIni);
     this.setAgencia(agencia);
     this.setAtiva(ativa);
     this.setSaldo(saldo);
     
     
    }

    ContaCorrente(String numero, String banco, float saldoIni, String agencia, boolean ativa) {
     this.setNumero(numero);
     this.setBanco(banco);
     this.setSaldoIni(saldoIni);
     this.setAgencia(agencia);
     this.setAtiva(ativa);
     
    }


    /**
     * @return the banco
     */
    public String getBanco() {
        return banco;
    }

    /**
     * @param banco the banco to set
     */
    public void setBanco(String banco) {
        this.banco = banco;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the saldoIni
     */
    public double getSaldoIni() {
        return saldoIni;
    }

    /**
     * @param saldoIni the saldoIni to set
     */
    public void setSaldoIni(float saldoIni) {
        this.saldoIni = saldoIni;
        this.setSaldo(saldoIni) ;
    }

    /**
     * @return the agencia
     */
    public String getAgencia() {
        return agencia;
    }

    /**
     * @param agencia the agencia to set
     */
    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    /**
     * @return the ativa
     */
    public boolean getAtiva() {
        return ativa;
    }

    /**
     * @param ativa the ativa to set
     */
    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    /**
     * @return the extrato
     */
    public Movimentacao getExtrato() {
        return extrato;
    }

    /**
     * @param extrato the extrato to set
     */
    public void setExtrato(Movimentacao extrato) {
        this.extrato = extrato;
    }

    /**
     * @return the saldo
     */
    public float getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldoMais(float saldo) {
        System.out.println(this.getSaldo());
        this.setSaldo(this.getSaldo() + saldo);
    }
    
     public void setSaldoMenos(float saldo) {
         this.setSaldo(this.getSaldo() - saldo);
    }

    
    
     @Override
     public String toString(){
        return  " " + this.numero + " \n " + this.getSaldo();
    }
    
    public String ImprimirExtrato(){
        
        String qualquer = "";
        int cont = 0 ;
        
        qualquer += "Saldo Inicial" + this.saldoIni;
        
        while (this.getExtratos().size() > cont) {
            
            qualquer += " \n " + getExtratos().get(cont).toString();
            cont ++;
        }
        
        qualquer += "Saldo final" + this.getSaldo();
        
        return qualquer ;
        
    }

    /**
     * @return the extratos
     */
    public ArrayList getExtratos() {
        return extratos;
    }

    /**
     * @param extratos the extratos to set
     */
    public void setExtratos(ArrayList extratos) {
        this.extratos = extratos;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
        
 
}
