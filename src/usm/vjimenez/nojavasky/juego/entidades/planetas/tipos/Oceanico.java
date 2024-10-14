package usm.vjimenez.nojavasky.juego.entidades.planetas.tipos;

import usm.vjimenez.nojavasky.juego.entidades.Alienigena;
import usm.vjimenez.nojavasky.juego.entidades.planetas.Planeta;
import usm.vjimenez.nojavasky.juego.entidades.planetas.tieneAsentamientos;
import usm.vjimenez.nojavasky.juego.controladores.Jugador;


public class Oceanico extends Planeta implements tieneAsentamientos {

    // Atributo
    private int profundidad;
    private Alienigena alienigenaPersistente;

    // Constructor de la clase Oceanico
    public Oceanico(int radio, int cristalesHidrogeno, int floresDeSodio, int profundidad, float consumoEnergia) {
        // Llamada al constructor de la superclase Planeta
        super(radio, cristalesHidrogeno, floresDeSodio, 0, 0, consumoEnergia); // Pasando 0 para uranio y platino
        this.profundidad = profundidad;
        this.setTipo("Oceanico");
        this.setDescripcion("Estos planetas son un gran océano, rico en vida acuática. Pero todos los recursos de "
                + "valor están en las profundidades, si decides aventurarte bajo el agua, deberás considerar "
                + "energía para poder respirar. Son ricos en Flores de Sodio y puede haber "
                + "asentamientos de especies alienígenas que están dispuestos a intercambiar recursos "
                + "por mejoras a tu exotraje o para tu nave.");
    }

    public int getProfundidad() {
        return profundidad;
    }
    public Alienigena getAlienigenaPersistente() {
        return alienigenaPersistente;
    }
    public void setProfundidad(int profundidad) {
        this.profundidad = profundidad;
    }
    public void setAlienigenaPersistente(Alienigena alienigenaPersistente) {
        this.alienigenaPersistente = alienigenaPersistente;
    }

    // Métodos de la clase abstracta Planeta
    @Override
    public boolean visitar(Jugador jugador) {
        // Implementación por definir
        return true;
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

    @Override
    public boolean verificartieneAsentamientos() {
        return true; // Este planeta tiene asentamientos
    }
    @Override
    public void visitarAsentamientos(Jugador jugador) {
        // Si no existe un alienígena persistente, lo generamos
        if (alienigenaPersistente == null) {
            Alienigena generador = new Alienigena("", "Aqualuxian", " ", " ", " "); // Crear una instancia
            alienigenaPersistente = generador.generarAlienigena();  // Generar el alienígena
        }

    }

}

