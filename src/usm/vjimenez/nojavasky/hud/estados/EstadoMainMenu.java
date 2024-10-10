package usm.vjimenez.nojavasky.hud.estados;

import java.util.Scanner;
import usm.vjimenez.nojavasky.hud.GameStateManager;
import usm.vjimenez.nojavasky.juego.controladores.Jugador;
import usm.vjimenez.nojavasky.juego.controladores.Nave;
import usm.vjimenez.nojavasky.juego.controladores.MapaGalactico;

public class EstadoMainMenu extends GameState {

    public EstadoMainMenu(GameStateManager gsm, Jugador jugador, Nave nave, MapaGalactico mapa) {
        super(gsm, jugador, nave, mapa);
    }

    @Override
    public void mostrarOpciones() {

        // Mostrar arte ASCII y opciones
        System.out.println("✶ *   ✧₊⁺      *       *       *       *    *    *      *   *     *  *    *     *    *    *     *    *   *  *  *");
        System.out.println("*    *	    *	███╗   ██╗ ██████╗ *    *   ██╗ █████╗ ██╗   ██╗ █████╗ *  *███████╗██╗  ██╗██╗ * ██╗ *   ᯓ★ *");
        System.out.println("✶   *	*    *	████╗  ██║██╔═══██╗   *   * ██║██╔══██╗██║ * ██║██╔══██╗  * ██╔════╝██║ ██╔╝╚██╗ ██╔╝   *   * ✶");
        System.out.println("*   *	 ✧₊⁺  *	██╔██╗ ██║██║   ██║     *   ██║███████║██║   ██║███████║    ███████╗█████╔╝  ╚████╔╝  *   *   *");
        System.out.println("✶ *    *    *   ██║╚██╗██║██║   ██║ *  ██ * ██║██╔══██║╚██╗ ██╔╝██╔══██║  * ╚════██║██╔═██╗   ╚██╔╝    *    * ✶");
        System.out.println("*   ☾ 	*     *	██║ ╚████║╚██████╔╝    ╚█████╔╝██║  ██║ ╚████╔╝ ██║  ██║ *  ███████║██║  ██╗   ██║   *    *   *");
        System.out.println("✶    *	  *   *	╚═╝  ╚═══╝ ╚═════╝ *  * ╚════╝ ╚═╝  ╚═╝  ╚═══╝  ╚═╝  ╚═╝  * ╚══════╝╚═╝  ╚═╝   ╚═╝   ✧₊⁺   *  ✶");
        System.out.println("*  *     *       *       *       *    *    *      *   *     *  ✧₊⁺     *     *    *    *    ✧₊⁺     *   *   * *");
        System.out.println("\n");
        // No es necesario crear un nuevo Scanner, usar el de la superclase
        System.out.println("Bienvenido a No Java Sky!");
        System.out.print("Por favor, ingresa tu nombre: ");
        String nombreJugador = scanner.nextLine();
        jugador.setNombreJugador(nombreJugador); // Guardar el nombre del jugador

        System.out.println("¡Hola " + jugador.getNombreJugador() + "! Listo para empezar el viaje?");
        System.out.println("[1] Empezar juego");
        System.out.println("[2] Cambiar nombre");
        System.out.println("[3] Salir");

        System.out.print("Selecciona una opción: ");
        int opcion = obtenerOpcion(scanner); // Método para obtener una opción válida

        switch (opcion) {
            case 1:
                // Cambiar al estado de órbita
                Nave nave = new Nave();  // Inicializar la nave
                MapaGalactico mapaGalactico = new MapaGalactico(); // Inicializar el mapa
                mapaGalactico.generadorPlaneta(); // Generar el primer planeta
                cambiarEstado(new EstadoOrbita(gsm, jugador, nave, mapaGalactico));
                break;
            case 2:
                limpiarPantalla();
                mostrarOpciones(); // Repetir opciones
                break;

            case 3:
                System.out.println("Saliendo del juego...");
                gsm.cerrarScanner(); // Asegúrate de cerrar el scanner al salir
                System.exit(0);
                break;

            default:
                limpiarPantalla();
                System.out.println("Ingresaste una opción no válida, intentemoslo de nuevo.\n");
                mostrarOpciones(); // Repetir opciones
                break;
        }
    }

    // Método para obtener una opción válida del usuario
    private int obtenerOpcion(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Por favor, ingresa un número: ");
            }
        }
    }
}
