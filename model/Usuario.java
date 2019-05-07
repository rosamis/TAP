package model;

import interfaces.Observer;
import interfaces.Subject;

import java.util.ArrayList;
import java.util.List;

public class Usuario implements Observer {
    private String nome;
    private String telefone;
    private String status;
    private String foto;

    //construtor dos usuarios
    public Usuario(String nome, String telefone, String status, String foto) {
        this.nome = nome;
        this.telefone = telefone;
        this.status = status;
        this.foto = foto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    //Referencia a classe Subject
    private List<Subject> grupos = new ArrayList<>();

    @Override
    public void update(Subject grupo) {
        if (!grupos.contains(grupo)) {
            System.out.println(getNome()+" não está no grupo "+grupo.getNome());
            return;
        }
        List<Mensagem> msg = (List<Mensagem>) grupo.getUpdate(this);
        if (msg.isEmpty()) {
            System.out.println(nome + " Não há novas mensagens no grupo! ");
        }
        for (Mensagem m : msg) {
            if (m.getOrigem() == this) continue;
            if (!m.getVisualizado().contains(this) && !m.isApagado()) {
                m.getVisualizado().add(this);
                System.out.println(nome + " leu a mensagem: "+ m.getTexto() + " do grupo " + grupo.getNome());
            } else if (m.isApagado() && !m.getVisualizado().contains(this)) {
                System.out.println(nome + " leu a mensagem: 'Mensagem apagada' do grupo " + grupo.getNome());
            }
        }
    }

    //colocar o grupo que ele pertence
    @Override
    public void setSubject(Subject subject) {
        this.grupos.add(subject);
    }
}
