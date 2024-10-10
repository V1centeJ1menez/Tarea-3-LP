package usm.vjimenez.nojavasky.hud;

import usm.vjimenez.nojavasky.hud.estados.*;
import usm.vjimenez.nojavasky.juego.controladores.Jugador;
import usm.vjimenez.nojavasky.juego.controladores.Nave;
import usm.vjimenez.nojavasky.juego.controladores.MapaGalactico;


public class GameStateManager {
    private GameState estadoActual;

    // Constructor que inicializa el estado inicial
    public GameStateManager(Jugador jugador, Nave nave, MapaGalactico mapa) {
        // Comenzamos en órbita
        estadoActual = new EstadoOrbita(this, jugador, nave, mapa);
    }

    // Cambia el estado actual del juego
    public void cambiarEstado(GameState nuevoEstado) {
        this.estadoActual = nuevoEstado; // Cambia el estado actual
        estadoActual.mostrarOpciones(); // Muestra las opciones del nuevo estado
    }

    // Método para actualizar el estado actual del juego
    public void actualizar() {
        if (estadoActual != null) {
            estadoActual.mostrarOpciones(); // Muestra opciones dependiendo del estado actual
        }
    }
}
