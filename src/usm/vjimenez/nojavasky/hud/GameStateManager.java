package usm.vjimenez.nojavasky.hud;

import usm.vjimenez.nojavasky.hud.estados.*; // Cambiamos a EstadoMenuPrincipal
import usm.vjimenez.nojavasky.juego.controladores.Jugador;
import usm.vjimenez.nojavasky.juego.controladores.Nave;
import usm.vjimenez.nojavasky.juego.controladores.MapaGalactico;

public class GameStateManager {
    private GameState estadoActual;

    // Constructor que inicializa el estado inicial
    public GameStateManager() {
        // Comenzamos en el menú principal
        estadoActual = new EstadoMainMenu(this, new Jugador(), new Nave(), new MapaGalactico());
    }

    // Cambia el estado actual del juego
    public void cambiarEstado(GameState nuevoEstado) {
        this.estadoActual = nuevoEstado; // Cambia el estado actual
        estadoActual.mostrarOpciones(); // Muestra las opciones del nuevo estado
    }

    // Método para manejar la ejecución de los estados
    public void actualizar() {
        if (estadoActual != null) {
            estadoActual.mostrarOpciones(); // Muestra opciones dependiendo del estado actual
        }
    }

    // Método para cerrar el Scanner al final del juego
    public void cerrarScanner() {
        if (estadoActual != null) {
            estadoActual.cerrarScanner(); // Cierra el Scanner
        }
    }
}
