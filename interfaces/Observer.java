package interfaces;

public interface Observer {
    public void update(Subject sub);
    public void setSubject(Subject subject);

    String getNome();
}
