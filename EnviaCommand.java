import interfaces.Command;
import model.Grupo;
import model.Mensagem;

public class EnviaCommand implements Command {
    Grupo grupo;
    Mensagem mensagem;

    public EnviaCommand(Grupo grupo, Mensagem mensagem) {
        this.grupo = grupo;
        this.mensagem = mensagem;
    }

    @Override
    public void executa() {
        grupo.enviaMensagem(mensagem);
    }
}
