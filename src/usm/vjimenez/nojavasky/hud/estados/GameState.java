package usm.vjimenez.nojavasky.hud.estados;

import usm.vjimenez.nojavasky.juego.controladores.Jugador;
import usm.vjimenez.nojavasky.juego.controladores.Nave;
import usm.vjimenez.nojavasky.juego.controladores.MapaGalactico;
import usm.vjimenez.nojavasky.hud.*;

import java.util.Scanner;

public abstract class GameState {
    protected GameStateManager gsm;
    protected Jugador jugador;
    protected Nave nave;
    protected MapaGalactico mapa;
    protected Scanner scanner; // Declarar el Scanner aquí

    public GameState(GameStateManager gsm, Jugador jugador, Nave nave, MapaGalactico mapa) {
        this.gsm = gsm;
        this.jugador = jugador;
        this.nave = nave;
        this.mapa = mapa;
        this.scanner = new Scanner(System.in); // Inicializar el Scanner en el constructor
    }

    protected void cambiarEstado(GameState nuevoEstado) {
        gsm.cambiarEstado(nuevoEstado);
    }

    public abstract void mostrarOpciones(); 

    // Asegúrate de cerrar el Scanner al final de la aplicación
    public void cerrarScanner() {
        scanner.close();
    }

    // Método para limpiar la consola (esto puede variar según el sistema operativo)
    public void limpiarPantalla() {
        // Esto es un método simple para limpiar la consola
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            System.out.println("No se pudo limpiar la pantalla.");
        }
    }

       // Método para pausar y esperar una entrada del usuario
    public void pausa() {
        System.out.println("Presiona Enter para continuar...");
        scanner.nextLine(); // Espera a que el usuario presione Enter
    }
}
