package beans;

import dao.UsuarioDAO;
import entidade.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class UsuarioBean extends CrudBean<Usuario, UsuarioDAO>{

    private UsuarioDAO usuarioDAO; 
    
    @Override
    public UsuarioDAO getDAO() {
        //Verifica se já tem um usuarioDAO na memória
        if(usuarioDAO == null){
            usuarioDAO = new UsuarioDAO();
        }
        return usuarioDAO;
    }

    @Override
    public Usuario criarNovaEntidade() {
        return new Usuario(); //Retorna um tipo genérico
    }
}