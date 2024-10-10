package usm.vjimenez.nojavasky.juego.entidades.planetas.tipos;

import usm.vjimenez.nojavasky.juego.entidades.planetas.Planeta;
import usm.vjimenez.nojavasky.juego.entidades.planetas.tieneAsentamientos;
import usm.vjimenez.nojavasky.juego.controladores.Jugador;

public class Oceanico extends Planeta implements tieneAsentamientos {

    // Atributo
    private int profundidad;

    // Constructor
    public Oceanico(int radio, int cristalesHidrogeno, int floresDeSodio, int profundidad, float consumoEnergia) {
        this.radio = radio;
        this.cristalesHidrogeno = cristalesHidrogeno;
        this.floresDeSodio = floresDeSodio;
        this.profundidad = profundidad;
        this.consumoEnergia = consumoEnergia;
        this.tipo = "Oceanico";
    }

    public int getProfundidad() {
        return profundidad;
    }

    /*public void setProfundidad(int profundidad) {
        this.profundidad = profundidad;
    }*/

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

    // Método de la interfaz tieneAsentamientos
    @Override
    public void visitarAsentamientos(Jugador jugador) {
        // Implementación por definir
    }
}

