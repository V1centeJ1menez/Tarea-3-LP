package usm.vjimenez.nojavasky.juego.entidades.planetas.tipos;

import usm.vjimenez.nojavasky.juego.entidades.planetas.Planeta;
import usm.vjimenez.nojavasky.juego.controladores.Jugador;

public class CentroGalactico extends Planeta {

    // Constructor
    public CentroGalactico() {
        this.tipo = "Centro Galactico";
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


        
