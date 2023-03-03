package com.example.higherlower;

public class Pregunta {
    private int pregunta;

    private int total;
    private int imagen;

    private int resposta_correcte;

    public Pregunta(int pregunta, int total) {
        this.pregunta = pregunta;
        this.total = total;
    }
    public int setImagen(){
        return imagen;
    }

    public int getImagen() {
        return imagen;
    }

    public int getPregunta() {
        return pregunta;
    }

    public int getTotal() {
        return total;
    }

    public void setResposta_correcte(int resposta_correcte) {
        this.resposta_correcte = resposta_correcte;
    }

    public int getResposta_correcte() {
        return resposta_correcte;
    }

}
