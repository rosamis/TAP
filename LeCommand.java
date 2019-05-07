import interfaces.Command;
import interfaces.Observer;
import model.Grupo;

import java.util.List;

public class LeCommand implements Command {
    Grupo grupo;
    List<Observer> u;

    public LeCommand(Grupo leitor, List<Observer> u) {
        this.grupo = leitor;
        this.u = u;
    }

    @Override
    public void executa() {
        grupo.notifyObservers(u);
    }
}
