package persistencia;

import contacorrente.ContaCorrente;
import contacorrente.Movimentacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Pconta {
    
   
    
    public void inserir(ContaCorrente conta) throws SQLException{
        Connection con = util.Conexao.getConexao();
        
        String sql = "INSERT INTO conta (banco, agencia, ativa, saldo , numero , saldoini) VALUES (?,?,?,?,?,?)";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,conta.getBanco());
        ps.setString(2, conta.getAgencia());
        ps.setBoolean(3, conta.getAtiva());;
        ps.setFloat(4, conta.getSaldo());;
        ps.setString(5, conta.getNumero());;   
        ps.setDouble(6, conta.getSaldoIni());;
        ps.execute();
    }
    
    public void deletar(String banco , String numero) throws SQLException{
        Connection con = util.Conexao.getConexao();
        
        String sql = "DELETE FROM conta  WHERE banco=? and numero=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, banco);
        ps.setString(2, numero);
        
        ps.execute();
    }
    public void alterar(ContaCorrente conta) throws SQLException{
        Connection con = util.Conexao.getConexao();
        
        String sql = "UPDATE conta SET banco=?, agencia=?, ativa=?, saldo=? , numero=? , saldoini=?  WHERE banco=? and numero=?";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, conta.getBanco());
        ps.setString(2, conta.getAgencia());
        ps.setBoolean(3, conta.getAtiva());;
        ps.setFloat(4, conta.getSaldo());;
        ps.setString(5, conta.getNumero());;   
        ps.setDouble(6, conta.getSaldoIni());;
        ps.setString(7, conta.getBanco());
        ps.setString(8, conta.getAgencia());
      
       
        
        
        ps.executeUpdate();
    }
    
    public ContaCorrente visualizarUm(String banco , String numero) throws SQLException{
        Connection con = util.Conexao.getConexao();
        
        String sql = "SELECT * FROM conta  WHERE banco=? and numero=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, banco);
        ps.setString(2, numero);
        
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            return new ContaCorrente(rs.getString(1), rs.getString(2), rs.getFloat(3), 
                    rs.getString(4), rs.getBoolean(5),rs.getFloat(6));            
        }
        
        return null;
    }
    
    public List<ContaCorrente> visualizarAll() throws SQLException{
        Connection con = util.Conexao.getConexao();
        
        String sql = "SELECT * FROM conta";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        List<ContaCorrente> lista = new ArrayList<>();
        while (rs.next()) {
            lista.add(new ContaCorrente(rs.getString(1), rs.getString(2), rs.getFloat(3), 
                    rs.getString(4), rs.getBoolean(5),rs.getFloat(6)));
        }
        return lista;
    }
    
    public Set<ContaCorrente> visualizarAllSet() throws SQLException{
        Connection con = util.Conexao.getConexao();
        
        String sql = "SELECT * FROM conta";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        Set<ContaCorrente> lista = new TreeSet<>();
        while (rs.next()) {
            lista.add(new ContaCorrente(rs.getString(1), rs.getString(2), rs.getFloat(3), 
                    rs.getString(4), rs.getBoolean(5),rs.getFloat(6)));
        }
        return lista;
    }
}
