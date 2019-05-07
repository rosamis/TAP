import interfaces.Command;
import model.Grupo;
import model.Mensagem;
import model.Usuario;

public class ExcluiCommand implements Command {
    Grupo grupo;
    Mensagem mensagem;
    Usuario apagador;

    public ExcluiCommand(Grupo grupo, Mensagem mensagem, Usuario apagador) {
        this.grupo = grupo;
        this.mensagem = mensagem;
        this.apagador = apagador;
    }

    @Override
    public void executa() {
        grupo.apagaMensagem(mensagem,apagador);
    }
}
