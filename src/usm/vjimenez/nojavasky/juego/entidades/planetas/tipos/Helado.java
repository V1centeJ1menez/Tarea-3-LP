package usm.vjimenez.nojavasky.juego.entidades.planetas.tipos;

import usm.vjimenez.nojavasky.juego.entidades.planetas.Planeta;
import usm.vjimenez.nojavasky.juego.entidades.planetas.tieneAsentamientos;
import usm.vjimenez.nojavasky.juego.controladores.Jugador;

public class Helado extends Planeta implements tieneAsentamientos {

    // Atributo
    private int temperatura;

    // Constructor
    public Helado(int radio, int cristalesHidrogeno, int floresDeSodio, int temperatura, float consumoEnergia) {
        this.radio = radio;
        this.cristalesHidrogeno = cristalesHidrogeno;
        this.floresDeSodio = floresDeSodio;
        this.temperatura = temperatura;
        this.consumoEnergia = consumoEnergia;
        this.tipo = "Helado";
    }

    public int getTemperatura() {
        return temperatura;
    }
    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

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

