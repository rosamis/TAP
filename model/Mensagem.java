package model;

import java.util.ArrayList;
import java.util.List;

public class Mensagem {
    private String texto;
    private String fotos;
    private String videos;
    private String audio;
    private Usuario origem;
    private List<Usuario> visualizado = new ArrayList<>();
    private boolean apagado;

    public Mensagem(String texto, Usuario origem, String fotos, String videos, String audio) {
        this.texto = texto;
        this.origem = origem;
    }

    public Usuario getOrigem() {
        return origem;
    }

    public void setOrigem(Usuario origem) {
        this.origem = origem;
    }

    @Override
    public String toString() {
        return texto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getFotos() {
        return fotos;
    }

    public void setFotos(String fotos) {
        this.fotos = fotos;
    }

    public String getVideos() {
        return videos;
    }

    public void setVideos(String videos) {
        this.videos = videos;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public List<Usuario> getVisualizado() {
        return visualizado;
    }

    public void setVisualizado(List<Usuario> visualizado) {
        this.visualizado = visualizado;
    }

    public boolean isApagado() {
        return apagado;
    }

    public void setApagado(boolean apagado) {
        this.apagado = apagado;
    }

}
