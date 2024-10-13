package usm.vjimenez.nojavasky.juego.entidades.planetas.tipos;

import usm.vjimenez.nojavasky.juego.entidades.Alienigena;
import usm.vjimenez.nojavasky.juego.entidades.planetas.Planeta;
import usm.vjimenez.nojavasky.juego.entidades.planetas.tieneAsentamientos;
import usm.vjimenez.nojavasky.juego.controladores.Jugador;

public class Helado extends Planeta implements tieneAsentamientos {

    // Atributo
    private int temperatura;
    private Alienigena alienigenaPersistente; 

    // Constructor
    public Helado(int radio, int cristalesHidrogeno, int floresDeSodio, int temperatura, float consumoEnergia) {
        this.radio = radio;
        this.cristalesHidrogeno = cristalesHidrogeno;
        this.floresDeSodio = floresDeSodio;
        this.temperatura = temperatura;
        this.consumoEnergia = consumoEnergia;
        this.tipo = "Helado";
        this.descripcion = "Estos planetas son una tundra congelada, donde uno siempre verá nieve y hielo. "
                     + "Son muy ricos en Cristales de Hidrógeno y puede haber asentamientos de especies "
                     + "alienígenas que están dispuestas a intercambiar recursos por mejoras para tu exotraje "
                     + "o para tu nave.";
    }

    public int getTemperatura() {
        return temperatura;
    }
    public Alienigena getAlienigenaPersistente() {
        return alienigenaPersistente;
    }
    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }
    public void setAlienigenaPersistente(Alienigena alienigenaPersistente) {
        this.alienigenaPersistente = alienigenaPersistente;
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

    @Override
    public boolean verificartieneAsentamientos() {
        return true; // Este planeta tiene asentamientos
    }
    // Método de la interfaz tieneAsentamientos
    @Override
    public void visitarAsentamientos(Jugador jugador) {
        // Si no existe un alienígena persistente, lo generamos
        if (alienigenaPersistente == null) {
            Alienigena generador = new Alienigena("", "Glaciarido", " ", " ", " "); // Crear una instancia
            alienigenaPersistente = generador.generarAlienigena();  // Generar el alienígena
        }

    }

}

