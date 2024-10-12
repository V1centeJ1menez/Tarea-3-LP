package usm.vjimenez.nojavasky.juego.entidades.planetas.tipos;

import usm.vjimenez.nojavasky.juego.entidades.planetas.Planeta;
import usm.vjimenez.nojavasky.juego.controladores.Jugador;

public class CentroGalactico extends Planeta {

    // Constructor
    public CentroGalactico() {
        this.tipo = "Centro Galactico";
        this.descripcion = "Solo existe un centro galáctico. Es un lugar muy hostil, estrellas parecen orbitar "
                     + "un objeto estelar desconocido, y solo las mejores naves espaciales pueden llegar. Para "
                     + "poder visitar este lugar es necesario una nave con una eficiencia de propulsor sobre "
                     + "el 50%.";
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
        return super.extraerRecursos(tipo);
    }

    @Override
    public boolean salir() {
        // Implementación por definir
        return true;
    }

}


        
