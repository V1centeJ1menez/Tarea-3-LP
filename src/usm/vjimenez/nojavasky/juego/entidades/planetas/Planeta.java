package usm.vjimenez.nojavasky.juego.entidades.planetas;

import usm.vjimenez.nojavasky.juego.controladores.Jugador;


public abstract class Planeta {

    //*************************************************** ATRIBUTOS ***************************************************//
    protected int radio;
    protected int cristalesHidrogeno;
    protected int floresDeSodio;
    protected float consumoEnergia;
    protected String tipo;
    protected String descripcion;


    //*************************************************** GETTERS ***************************************************//
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
    public String getDescripcion() {
        return descripcion;
    }

    //*************************************************** SETTERS ***************************************************//
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
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    //*************************************************** METODOS ***************************************************//
    // Método que se llama cuando el jugador visita el planeta
    public boolean visitar(Jugador jugador) {
        
        if (jugador.getUnidadesEnergiaProteccion() == 0) {
            return false;
        }
        return true;
    }
    public abstract int extraerRecursos(int tipo);
    // Método para salir del planeta
    public boolean salir() {
        return true;
    }
    
}

