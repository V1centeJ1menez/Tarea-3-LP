package usm.vjimenez.nojavasky.hud.estados;

import usm.vjimenez.nojavasky.hud.GameStateManager;
import usm.vjimenez.nojavasky.juego.controladores.Jugador;
import usm.vjimenez.nojavasky.juego.entidades.planetas.Planeta;
import java.util.Scanner;

public class EstadoExploracion implements GameState {

    private GameStateManager gsm;
    private Jugador jugador;
    private Planeta planetaActual;

    public EstadoExploracion(GameStateManager gsm, Jugador jugador, Planeta planetaActual) {
        this.gsm = gsm;
        this.jugador = jugador;
        this.planetaActual = planetaActual;
    }

    @Override
    public void mostrarOpciones() {
        System.out.println("Estás explorando el planeta " + planetaActual.getTipo());
        System.out.println("Opciones:");
        System.out.println("1. Extraer recursos");
        System.out.println("2. Regresar a órbita");

        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();

        if (opcion == 1) {
            System.out.print("¿Cuántos recursos deseas extraer? ");
            int cantidad = scanner.nextInt();
            jugador.extraccionDeRecursos(cantidad, planetaActual);
            System.out.println("Recursos extraídos.");
            mostrarOpciones();
        } else if (opcion == 2) {
            // Cambiar de vuelta al estado de órbita
            gsm.cambiarEstado(new EstadoOrbita(gsm, jugador, null, null)); // Deberás pasar los objetos correctos
        } else {
            System.out.println("Opción inválida.");
            mostrarOpciones();
        }
    }
}
