/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contacorrente;

import negocio.Nconta;
import negocio.Nmovimentacao;
import java.util.Scanner;
import contacorrente.ContaCorrente;
import java.util.ArrayList;
import contacorrente.Movimentacao;
import java.sql.SQLException;
import javax.swing.JOptionPane;



public class Main {
    
    Nconta nconta = new Nconta();
    Nmovimentacao movimenta = new Nmovimentacao();
    
    
    ArrayList<ContaCorrente> contas = new ArrayList<>();
    
   
    
    public void SalvaConta(String numero, String banco, float saldoIni,String agencia ,boolean ativa) throws SQLException{
    
        
     ContaCorrente Aconta = new ContaCorrente(numero,banco,saldoIni,agencia,ativa );    
   
     
   nconta.salvar(Aconta);
   
        
    }
    
    public void Depositar(String data, float valor , String descricao, ContaCorrente conta){
    
        
        try {
            conta.getExtrato().setValor(valor);
            conta.getExtrato().setData(data);
            conta.getExtrato().setDescricao(descricao);
            conta.getExtrato().setTipo("D");
            System.out.println(valor);
            conta.setSaldoMais(valor);
            //conta.getExtratos().add(conta.getExtrato());
            movimenta.salvar(conta.getExtrato());
            
            
        System.out.println(conta.toString());
        } catch (Exception e) {
            
             System.out.println("Erro: " + e.getMessage());
        }
       
}
    
    public void Sacar(String data, float valor , ContaCorrente conta){
         conta.getExtrato().setValor(valor);
         conta.getExtrato().setData(data);
         conta.setSaldoMenos(valor);
         conta.getExtratos().add(conta.getExtrato());
        
        
        System.out.println(conta.toString());
        
       
}
    
    public ContaCorrente BuscarConta(String conta , String banco) throws SQLException{
        
        int cont = 0;
        
        System.out.println("buscasadas");
        ValidarConta(""+conta);
        return nconta.consultar(banco, conta);
     
    }

    public boolean ValidarConta(String conta) {
     
    int cont = 0;
     
    if(conta.isEmpty()){
        
        return false;
        
    }
    
        
    
    while(contas.size() > cont){
            
            String nconta = (conta); 
            
            if(nconta == contas.get(cont).getNumero() ){ 
                
                return true;
            }
            
          
            cont ++;
            

        }
    
    return false;
    
    }
}