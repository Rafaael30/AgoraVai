/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contacorrente;

/**
 *
 * @author Rafael
 */
public class Movimentacao {

    public Movimentacao() {
   
    
    
    }
    
    
    private String data = "";
    private float valor = 0;
    private String descricao = "";
    private String numero = "";
    private String banco = "";
    private String bancoDestino = "";
    private String numeroDestino = "";
    private String tipo = "";
    private int id = 0;

    public Movimentacao(String data, float valor, String descricao, String numero, String banco, String bancoDestino, String numeroDestino , String tipo , int id) {
  
    this.setData(data);
    this.setValor(valor);
    this.setDescricao(descricao);
    this.setNumero(numero);
    this.setBanco(banco);
    this.setBancoDestino(bancoDestino);
    this.setNumeroDestino(numeroDestino);
    this.setTipo(tipo);
    this.setId(id);
    
    
    }
    
    
    

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the valor
     */
    public float getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(float valor){
        this.valor = valor;
        
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    @Override
     public String toString(){
        return  " " + this.data + "  " + this.descricao + " " + this.valor  ;
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
     * @return the bancoDestino
     */
    public String getBancoDestino() {
        return bancoDestino;
    }

    /**
     * @param bancoDestino the bancoDestino to set
     */
    public void setBancoDestino(String bancoDestino) {
        this.bancoDestino = bancoDestino;
    }

    /**
     * @return the numeroDestino
     */
    public String getNumeroDestino() {
        return numeroDestino;
    }

    /**
     * @param numeroDestino the numeroDestino to set
     */
    public void setNumeroDestino(String numeroDestino) {
        this.numeroDestino = numeroDestino;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
    
    
    
}
