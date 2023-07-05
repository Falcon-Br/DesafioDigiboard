//Interface que descreve como quais o métodos, como uma fôrma
//que a Classe precisa ter caso seja implementada
package dao;


import exception.ErroSistema;
import java.util.List;

//Classe genérica 
public interface CrudDAO<E> { //E representa a entidade
    
    public void salvar(E entidade) throws ErroSistema;
    public void deletar(E entidade) throws ErroSistema;
    public List<E> buscarTodos() throws ErroSistema;
    
}
