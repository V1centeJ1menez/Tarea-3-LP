package usm.vjimenez.nojavasky.hud.estados;


import usm.vjimenez.nojavasky.hud.GameStateManager;
import usm.vjimenez.nojavasky.juego.controladores.Jugador;
import usm.vjimenez.nojavasky.juego.controladores.Nave;
import usm.vjimenez.nojavasky.juego.controladores.MapaGalactico;

public class EstadoCentroGalactico extends GameState {

    public EstadoCentroGalactico(GameStateManager gsm, Jugador jugador, Nave nave, MapaGalactico mapa) {
        super(gsm, jugador, nave, mapa);
    }

    @Override
    public void mostrarOpciones() {

        System.out.println("                   '                                .                *                 ");
        System.out.println("            *          .                  .                      .           ' .                        ");
        System.out.println("                   *       '              .                      ;           ");
        System.out.println("              *                *          :                  - --+- -        ");
        System.out.println("                                          !           .          !                   .");
        System.out.println("         .                      .         |        .             .         *  ");
        System.out.println("                                          |_         +");
        System.out.println("  .                 *     .            ,  | `.                                     .");
        System.out.println("                                 --- --+-<#>-+- ---  --  -            '      *   ");
        System.out.println("   *   '*      .                       `._|_,'                            .");
        System.out.println("           *                              T                                           *");
        System.out.println("                *                         |                                       '*");
        System.out.println("                       *                  !                   .:              ");
        System.out.println("                     *                    *             *               .*");
        
        System.out.println("");
        System.out.println("[1] Continuar explorando");
        System.out.println("[2] Reiniciar juego");
        System.out.println("[3] Salir del juego");

        // Lee la entrada del usuario para realizar una acción
    int opcion = scanner.nextInt();
    switch(opcion) {
        case 1:
            cambiarEstado(new EstadoOrbita(gsm, jugador, nave, mapa));
            break;
        case 2:
        
            // Reiniciar las instancias
            GameStateManager nuevoGsm = new GameStateManager(); // Crea una nueva instancia del GameStateManager
            Jugador nuevoJugador = new Jugador();               // Crea un nuevo jugador
            Nave nuevaNave = new Nave();                        // Crea una nueva nave
            MapaGalactico nuevoMapa = new MapaGalactico();      // Crea un nuevo mapa galáctico
         
            // Cambia el estado actual al menú principal con las nuevas instancias
            cambiarEstado(new EstadoMainMenu(nuevoGsm, nuevoJugador, nuevaNave, nuevoMapa));
        case 3:
            // Cerrar el programa
            System.out.println("Saliendo del juego...");
            cerrarScanner();  // Cerrar el Scanner antes de salir
            System.exit(0);
            break;
        default:
            System.out.println("Opción no válida. Inténtalo de nuevo.");
    }
    }
}

   
