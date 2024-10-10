package usm.vjimenez.nojavasky.juego.entidades.planetas.tipos;

import usm.vjimenez.nojavasky.juego.entidades.planetas.Planeta;
import usm.vjimenez.nojavasky.juego.controladores.Jugador;

public class Volcanico extends Planeta {

    // Atributo
    private int temperatura;
    private int platino;

    // Constructor
    public Volcanico(int radio, int cristalesHidrogeno, int floresDeSodio, int platino, int temperatura, float consumoEnergia) {
        this.radio = radio;
        this.cristalesHidrogeno = cristalesHidrogeno;
        this.floresDeSodio = floresDeSodio;
        this.temperatura = temperatura;
        this.tipo = "Volcanico";
    }


    public int getPlatino() {
        return platino;
    }
    public int getTemperatura() {
        return temperatura;
    }

    public void setPlatino(int platino) {
        this.platino = platino;
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
}
