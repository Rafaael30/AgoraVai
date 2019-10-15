package negocio;


import persistencia.Pmovimentacao;
import contacorrente.Movimentacao;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;


public class Nmovimentacao {
    
    public void salvar(Movimentacao obj) throws SQLException{
     if(obj.getId() != 0) new Pmovimentacao().alterar(obj);
          else 
        new Pmovimentacao().inserir(obj);
    }
    
    public void deletar(int id) throws SQLException{
        new Pmovimentacao().deletar(id );
    }
    
    public Movimentacao consultar(int id) throws SQLException{
        return new Pmovimentacao().visualizarUm(id);
    }
    
    public List<Movimentacao> listar(String numero ,String banco) throws SQLException{
        return new Pmovimentacao().visualizarAll(numero, banco);
    }
    
    public Set<Movimentacao> listarSet() throws SQLException{
        return new Pmovimentacao().visualizarAllSet();
    }
}
