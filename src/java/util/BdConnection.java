
package util;

//Classe responsável de fazer a conexão com o bando de dados.

import exception.ErroSistema;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BdConnection {
    
    private static Connection conexao;
    private static final String URL_CONEXAO =  "jdbc:postgresql://localhost:5432/DesafioDigiBoard";
    private static final String USUARIO =  "postgres";
    private static final String SENHA =  "1234";

    public static Connection getConexao() throws ErroSistema{
        if(conexao == null){
            try {
                Class.forName("org.postgresql.Driver");
                conexao =  DriverManager.getConnection(URL_CONEXAO, USUARIO, SENHA);
            } catch (ClassNotFoundException ex) {
                throw new ErroSistema("Não foi possível Conectar ao Banco de dados." ,ex);
            } catch (SQLException ex) {
                throw new ErroSistema("Driver do Banco de Dados não foi encontrado.", ex);
            }
        }
        return conexao;
    }
    
    public static void fecharConexao() throws ErroSistema{
        if(conexao != null){
            try {
                conexao.close();
                conexao = null;
            } catch (SQLException ex) {
                throw new ErroSistema("Erro ao encerrar a conexão do Banco de dados.", ex);
            }
        }
    }
    
}
