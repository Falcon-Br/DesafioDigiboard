
/*
Essa pacote é destinado ao acesso ao bando de dados através do conceito
DATA ACESS OBJECT (Objeto de acesso a dados), em resumo, o objeto que será usado
para conectar ao bando de daddos
*/
package dao;

import entidade.Usuario;
import exception.ErroSistema;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.BdConnection;

public class UsuarioDAO implements CrudDAO<Usuario>{
    
    @Override
    public void salvar(Usuario usuario) throws ErroSistema{
        try {
            Connection conexao = BdConnection.getConexao();
            PreparedStatement ps;

            if(usuario.getId() == null){
                ps = conexao.prepareStatement("INSERT INTO usuario (nome, endereco, nascimento) VALUES (?, ?, ?)");
            }else{
                ps = conexao.prepareStatement("UPDATE usuario SET nome = ?, endereco = ?, nascimento=? WHERE id = ?");
                ps.setInt(4, usuario.getId());
            }
            
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getEndereço());
            ps.setDate(3, new java.sql.Date(usuario.getDataNascimento().getTime()));
            
            ps.execute();
            
            BdConnection.fecharConexao();

        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao Salvar o novo usuário!", ex);
        }
    }
    
    @Override
    public void deletar(Usuario usuario) throws ErroSistema{
        try {
            Connection conexao = BdConnection.getConexao();
            PreparedStatement ps = conexao.prepareStatement("DELETE FROM usuario WHERE id = ?");
            ps.setInt(1, usuario.getId());
            ps.execute();
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao Deletar o usuário!", ex);
        }
    }
    
    @Override
    public List<Usuario> buscarTodos() throws ErroSistema{
        try {
            Connection conexao = BdConnection.getConexao();
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM usuario");
            ResultSet resultSet = ps.executeQuery(); // Executa a Query do Banco de Dados, esperando um valor a ser retortnado
            
            List<Usuario> usuarios = new ArrayList<>();
            
            //Vai passando para o proximo reguistro até que não tenha nenhu resgistro
            while(resultSet.next()){
                Usuario usuario = new Usuario();
                
                usuario.setId(resultSet.getInt("id")); //Recupera o registro ID
                usuario.setNome(resultSet.getString("nome")); //Recupera o Nome
                usuario.setEndereço(resultSet.getString("endereco")); //Recupera o Endereço
                usuario.setDataNascimento(resultSet.getDate("nascimento")); //Recupera o ano de Nascimento
                
                usuarios.add(usuario); //Adciona a lista que será exibida
            }
            BdConnection.fecharConexao();
            return usuarios;
            
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao Buscar o usuário!", ex);
        }
       
    }
}