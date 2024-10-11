package usm.vjimenez.nojavasky.hud.estados;

import usm.vjimenez.nojavasky.hud.GameStateManager;
import usm.vjimenez.nojavasky.juego.controladores.Jugador;
import usm.vjimenez.nojavasky.juego.controladores.Nave;

import usm.vjimenez.nojavasky.juego.controladores.MapaGalactico;


public class EstadoVisitandoPlaneta extends GameState {

    public EstadoVisitandoPlaneta(GameStateManager gsm, Jugador jugador, Nave nave, MapaGalactico mapa) {
        super(gsm, jugador, nave, mapa); // Llama al constructor de GameState
    }

    @Override
    public void mostrarOpciones() {
        boolean enMenuVisita = true;

        while (enMenuVisita) {
            
            limpiarPantalla();
            animarEntradaAlPlaneta();
            
            System.out.println("¿Qué deseas hacer?");
            System.out.println("[1] Extraer recursos");
            System.out.println("[2] Visitar asentamientos");
            System.out.println("[3] Volver a órbita");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Lógica para extraer recursos (se implementará después)
                    System.out.println("Funcionalidad de extracción de recursos aún no implementada.");
                    pausa();
                    break;

                case 2:
                    // Lógica para visitar asentamientos (se implementará después)
                    System.out.println("Funcionalidad de visita a asentamientos aún no implementada.");
                    pausa();
                    break;

                case 3:
                    enMenuVisita = false; // Salir del menú
                    break;

                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
                    pausa();
                    break;
            }
        }
    }

    private void animarEntradaAlPlaneta() {
        String[] mensajes = {
            "Bajando al planeta...",
            "Analizando datos...",
            "Cargando recursos...",
            "Preparando exotraje...",
            "Listo para la exploración."
        };
    
        for (String mensaje : mensajes) {
            limpiarPantalla(); // Limpia la pantalla para un mejor efecto visual
            System.out.println(mensaje);
            pausaAnimacion(1000); // Pausa por 1 segundo entre mensajes
        }
    }
    
}
