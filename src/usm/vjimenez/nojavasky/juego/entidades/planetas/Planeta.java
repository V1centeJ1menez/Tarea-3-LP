package usm.vjimenez.nojavasky.juego.entidades.planetas;

import usm.vjimenez.nojavasky.juego.controladores.Jugador;

public abstract class Planeta {

    // Atributos
    protected int radio;
    protected int cristalesHidrogeno;
    protected int floresDeSodio;
    protected float consumoEnergia;
    protected String tipo;


    // GETTERS - SETTERS
    public float getConsumoEnergia() {
        return consumoEnergia;
    }public int getCristalesHidrogeno() {
        return cristalesHidrogeno;
    }public int getFloresDeSodio() {
        return floresDeSodio;
    }public int getRadio() {
        return radio;
    }public String getTipo() {
        return tipo;
    }


    public void setConsumoEnergia(float consumoEnergia) {
        this.consumoEnergia = consumoEnergia;
    }public void setCristalesHidrogeno(int cristalesHidrogeno) {
        this.cristalesHidrogeno = cristalesHidrogeno;
    }public void setFloresDeSodio(int floresDeSodio) {
        this.floresDeSodio = floresDeSodio;
    }public void setRadio(int radio) {
        this.radio = radio;
    }public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public abstract boolean visitar(Jugador jugador);
    public abstract int extraerRecursos(int tipo);
    public abstract boolean salir();
    
}

