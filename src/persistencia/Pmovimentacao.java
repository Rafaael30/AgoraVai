/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import contacorrente.Movimentacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Roberto
 */
public class Pmovimentacao {
        
   
    
    public void inserir(Movimentacao movimento) throws SQLException{
        Connection con = util.Conexao.getConexao();
        
        String sql = "INSERT INTO movimentacao (data, descricao, valor, numero , banco , bancodestino, numerodestino , tipo, id) VALUES (?,?,?,?,?,?,?,?,?)";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,movimento.getData());
        ps.setString(2, movimento.getDescricao());
        ps.setFloat(3, movimento.getValor());;
        ps.setString(4, movimento.getNumero());;
        ps.setString(5, movimento.getBanco());;   
        ps.setString(6, movimento.getBancoDestino());;
        ps.setString(7, movimento.getNumeroDestino());;
        ps.setString(8, movimento.getTipo());;
        ps.setInt(9, movimento.getId());;
        
        
        
        ps.execute();
    }
    
    public void deletar(int id) throws SQLException{
        Connection con = util.Conexao.getConexao();
        
        String sql = "DELETE FROM movimentacao  WHERE id =?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
      
        
        ps.execute();
    }
    public void alterar(Movimentacao movimenta) throws SQLException{
        Connection con = util.Conexao.getConexao();
        
        String sql = "UPDATE conta SET (data=?, descricao=?, valor=?, numero=? , banco=? , bancodestino=?, numerodestino=? ,tipo=?  WHERE id=?  ";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, movimenta.getData());
        ps.setString(2, movimenta.getDescricao());
        ps.setFloat(3, movimenta.getValor());;
        ps.setString(4, movimenta.getNumero());;
        ps.setString(5, movimenta.getBanco());;   
        ps.setString(6, movimenta.getBancoDestino());;
        ps.setString(7, movimenta.getNumeroDestino());
        ps.setString(8, movimenta.getTipo());
        ps.setInt(9, movimenta.getId());
        
      
       
        
        
        ps.executeUpdate();
    }
    
    public Movimentacao visualizarUm(int id) throws SQLException{
        Connection con = util.Conexao.getConexao();
        
        String sql = "SELECT * FROM movimentacao  WHERE  id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
       
        
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            return new Movimentacao(rs.getString(1), rs.getFloat(2), rs.getString(3), 
                    rs.getString(4), rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(9));            
        }
        
        return null;
    }
    
    public List<Movimentacao> visualizarAll(String numero, String banco) throws SQLException{
        Connection con = util.Conexao.getConexao();
        
        String sql = "SELECT * FROM movimentacao where numero=? and banco=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        List<Movimentacao> lista = new ArrayList<>();
        while (rs.next()) {
            lista.add(new Movimentacao(rs.getString(1), rs.getFloat(2), rs.getString(3), 
                    rs.getString(4), rs.getString(5),rs.getString(6),rs.getString(6),rs.getString(6),rs.getInt(9)));
        }
        return lista;
    }
    
    public Set<Movimentacao> visualizarAllSet() throws SQLException{
        Connection con = util.Conexao.getConexao();
        
        String sql = "SELECT * FROM movimentacao";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        Set<Movimentacao> lista = new TreeSet<>();
        while (rs.next()) {
            lista.add(new Movimentacao(rs.getString(1), rs.getFloat(2), rs.getString(3), 
                    rs.getString(4), rs.getString(5),rs.getString(6),rs.getString(6),rs.getString(6),rs.getInt(9)));
        
        }
        return lista;
    }

}
