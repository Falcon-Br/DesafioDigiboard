package beans;

import dao.CrudDAO;
import exception.ErroSistema;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public abstract class CrudBean<E, D extends CrudDAO> {

    private String estadoTela = "busca"; //3 Estados: insere, edita e busca

    private E entidade; //Usada para trafegar os dados nos métodos salvar, editar, deletar
    private List<E> entidades; //Lista de entidades

    @PostConstruct
    public void init() {
        // Lógica a ser executada antes de renderizar a página
        buscar();
    }

    public void novo() {
        entidade = criarNovaEntidade(); //Quando for clicado no botão novo, a entidade será zerada
        mudarParaInsere(); //Muda a tela para o modo Inserção
    }

    public void salvar() {
        try {
            getDAO().salvar(entidade); //Salva o usuário no Banco
            entidade = criarNovaEntidade(); //Zera a entidade
            adicionarMensagem("Salvo com sucesso!", FacesMessage.SEVERITY_INFO); //Informa ao usuário do Sistema que tudo certo
            mudarParaBusca(); //Muda para o estado inicial
            buscar(); //Atualiza a tela depois de Deletar o dado
        } catch (ErroSistema ex) {
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
            adicionarMensagem(ex.getMessage(), FacesMessage.SEVERITY_ERROR); //Mostra ao usuário do Sistema um erro amigável
        }
    }

    public void editar(E entidade) {
        this.entidade = entidade; //Recebe a entidade e guarda no atributo de Classe Entidade
        mudarParaEdita();
    }

    public void deletar(E entidade) {
        try {
            getDAO().deletar(entidade); //Remove do Banco
            entidades.remove(entidade); //Remove da Lista de entidades
            adicionarMensagem("Deletado com sucesso!", FacesMessage.SEVERITY_INFO); //Informa ao usuário do Sistema que tudo certo
            buscar(); //Atualiza a tela depois de Deletar o dado
        } catch (ErroSistema ex) {
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
            adicionarMensagem(ex.getMessage(), FacesMessage.SEVERITY_ERROR); //Mostra ao usuário do Sistema um erro amigável
        }
    }

    public void buscar() {
        if (!isBusca()) {
            mudarParaBusca();
            return;
        }
        try {
            entidades = getDAO().buscarTodos();
            //Verifica se o Banco de dados está vazio
            if (entidades == null || entidades.size() < 1) {
                adicionarMensagem("O Banco de Dados não tem nenhum dado cadastrado.", FacesMessage.SEVERITY_WARN); //Mostra ao usuário do Sistema um erro amigável
            }
        } catch (ErroSistema ex) {
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
            adicionarMensagem(ex.getMessage(), FacesMessage.SEVERITY_ERROR); //Mostra ao usuário do Sistema um erro amigável
        }
    }

    public void adicionarMensagem(String mensagem, FacesMessage.Severity tipoErro) {
        FacesMessage fm = new FacesMessage(tipoErro, mensagem, null);
        FacesContext.getCurrentInstance().addMessage(null, fm);
    }

    //getters e setters
    public E getEntidade() {
        return entidade;
    }

    public void setEntidade(E entidade) {
        this.entidade = entidade;
    }

    public List<E> getEntidades() {
        return entidades;
    }

    public void setEntidades(List<E> entidades) {
        this.entidades = entidades;
    }

    //Responsável por criar os métodos nas Classes Bean
    public abstract D getDAO(); //Representa o DAO
    public abstract E criarNovaEntidade(); //Cria uma nova entidade toda vez que for preciso

    //Métodos para controle de tela
    public boolean isInsere() {
        return "insere".equals(estadoTela);
    }

    public boolean isEdita() {
        return "edita".equals(estadoTela);
    }

    public boolean isBusca() {
        return "busca".equals(estadoTela);
    }

    public void mudarParaInsere() {
        estadoTela = "insere";
    }

    public void mudarParaEdita() {
        estadoTela = "edita";
    }

    public void mudarParaBusca() {
        estadoTela = "busca";
    }
}