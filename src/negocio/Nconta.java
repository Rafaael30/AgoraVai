package negocio;


import persistencia.Pconta;
import contacorrente.ContaCorrente;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;


public class Nconta {
    
    public void salvar(ContaCorrente obj) throws SQLException{
        if(consultar(obj.getBanco(),obj.getNumero()) != null)  new Pconta().alterar(obj);
        else 
        new Pconta().inserir(obj);
    }
    
    public void deletar(String banco , String numero) throws SQLException{
        new Pconta().deletar(banco , numero );
    }
    
    public ContaCorrente consultar(String banco , String numero) throws SQLException{
        return new Pconta().visualizarUm(banco, numero);
    }
    
    public List<ContaCorrente> listar() throws SQLException{
        return new Pconta().visualizarAll();
    }
    
    public Set<ContaCorrente> listarSet() throws SQLException{
        return new Pconta().visualizarAllSet();
    }
}
