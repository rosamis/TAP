package model;

import interfaces.Observer;
import interfaces.Subject;

import java.util.ArrayList;
import java.util.List;

public class Grupo implements Subject {
    private List<Observer> observers;
    private List<Mensagem> mensagens;
    private String nome;
    private Observer administrador;
    private List<Usuario> usuarios;
    private String descricao;

    public Grupo(String nome, Observer administrador, String descricao) {
        this.observers = new ArrayList<>();
        this.nome = nome;
        this.administrador = administrador;
        this.descricao = descricao;
        this.mensagens = new ArrayList<>();
        this.observers.add(administrador);
        System.out.println(administrador.getNome() + " criou o grupo "+getNome());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAdministrador(Usuario administrador) {
        this.administrador = administrador;
    }
    //ele cria uma cópia da lista, para o caso de querer imprimir ela por ex! a fim de não acessar diretamente a lista
    public List<Usuario> getUsuarios() {
        return new ArrayList<>(usuarios);
    }
    //só pode acessar os itens da lista nesses casos, para adc e remover
    public void addUsuario(Usuario u) {
        this.usuarios.add(u);
    }

    public void removeUsuario(Usuario u) {
        this.usuarios.remove(u);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public void register(Observer observer) {
        if (observer == null) throw new NullPointerException("Objeto ou Observer nulo");
        if(!observers.contains(observer)) {
            observers.add(observer);
            System.out.println(administrador.getNome() + " inclui  " + observer.getNome() + " ao grupo " + getNome());
        }
    }

    @Override
    public void unregister(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers){
            observer.update(this);
        }
    }

    @Override
    public void notifyObservers(List<Observer> u) {
        for (Observer observer : observers){
            if (u.contains(observer)) observer.update(this);
        }
    }

    @Override
    public Object getUpdate(Observer observer) {
        return this.mensagens;
    }

    public void enviaMensagem(Mensagem msg){
        System.out.println(msg.getOrigem().getNome() + " envia mensagens para " + getNome());
        this.mensagens.add(msg);
    }

    public void apagaMensagem(Mensagem msg, Usuario apagador){
        if (apagador != msg.getOrigem()){
            System.out.println("Somente quem enviou pode apagar");
            return;
        }
        if (!mensagens.contains(msg)) {
            System.out.println("Essa mensagem não está no grupo "+getNome());
            return;
        }
        msg.setApagado(true);
        System.out.println(apagador.getNome()+" apagou a mensagem "+msg.getTexto() + " do grupo " + getNome());
    }
}
