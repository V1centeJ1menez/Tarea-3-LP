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
        this.platino = platino;
        this.consumoEnergia = consumoEnergia;
        this.descripcion =  "Este planeta de lejos puede parecer un sol, si no fuese por la nube de cenizas que "
                     + "cubre toda la superficie. Los grandes volcanes producen un aumento en la temperatura "
                     + "de la superficie que es incapaz de albergar vida, por lo que el exotraje lucha por tu "
                     + "supervivencia. La lava de estos planetas al solidificarse es rica en Platino, un "
                     + "elemento muy cotizado por los asentamientos de otros planetas, se puede intercambiar "
                     + "este elemento por mejoras en los asentamientos.";

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
        if (tipo == 4) { // Platino
            System.out.println("¡Extrayendo Plantino del planeta volcanico!");
            return super.extraerRecursos(tipo); // Delegamos la lógica de extracción
        }
        return super.extraerRecursos(tipo); // Si no es un recurso válido, no se extrae nada
    }

    @Override
    public boolean salir() {
        // Implementación por definir
        return true;
    }

 
}
