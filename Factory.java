import interfaces.Observer;
import model.Grupo;
import model.Mensagem;
import model.Usuario;

public class Factory {
    public static Grupo criaGrupo(String nome, Observer administrador, String descricao) {
        return new Grupo(nome, administrador, descricao);
    }

    public static Usuario criaUsuario(String nome, String telefone, String status, String foto) {
        return new Usuario(nome, telefone, status, foto);
    }

    public static Mensagem criaMensagem(String texto, Usuario origem) {
        return new Mensagem(texto, origem, null, null, null);
    }

    public static Mensagem criaVideo(String videos, Usuario origem) {
        return new Mensagem(null, origem, null, videos, null);
    }

    public static Mensagem criaAudio(String audio, Usuario origem) {
        return new Mensagem(null, origem, null, null, audio);
    }

    public static Mensagem criaFoto(String foto, Usuario origem) {
        return new Mensagem(null, origem, foto, null, null);
    }
}
