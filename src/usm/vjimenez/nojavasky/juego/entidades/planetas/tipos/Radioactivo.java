package usm.vjimenez.nojavasky.juego.entidades.planetas.tipos;

import usm.vjimenez.nojavasky.juego.entidades.planetas.Planeta;
import usm.vjimenez.nojavasky.juego.controladores.Jugador;

public class Radioactivo extends Planeta {

    // Atributo
    private int radiacion;
    private int uranio;
    // Constructor
    public Radioactivo(int radio, int cristalesHidrogeno, int floresDeSodio, int radiacion, int uranio, float consumoEnergia) {
        this.radio = radio;
        this.cristalesHidrogeno = cristalesHidrogeno;
        this.floresDeSodio = floresDeSodio;
        this.radiacion = radiacion;
        this.uranio = uranio;
        this.consumoEnergia = consumoEnergia;
        this.tipo = "Radioactivo";
    }

    public int getRadiacion() {
        return radiacion;
    }

    public int getUranio() {
        return uranio;
    }

    /* 
    public void setUranio(int uranio) {
        this.uranio = uranio;
    }

    public void setRadiacion(int radiacion) {
        this.radiacion = radiacion;
    }

    */
    // Métodos de la clase abstracta Planeta
    @Override
    public boolean visitar(Jugador jugador) {
        // Implementación por definir
        return false;
    }

    @Override
    public int extraerRecursos(int tipo) {
        // Implementación por definir
        return 0;
    }

    @Override
    public boolean salir() {
        // Implementación por definir
        return false;
    }
}
