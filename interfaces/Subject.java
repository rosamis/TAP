package interfaces;

import model.Usuario;

import java.util.List;

public interface Subject {
    public void register(Observer observer);
    public void unregister(Observer observer);
    public  void notifyObservers();
    public  void notifyObservers(List<Observer> u);
    public Object getUpdate(Observer observer);
    public String getNome();
}
