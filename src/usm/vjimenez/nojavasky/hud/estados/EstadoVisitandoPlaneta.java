package usm.vjimenez.nojavasky.hud.estados;

import usm.vjimenez.nojavasky.hud.GameStateManager;
import usm.vjimenez.nojavasky.juego.controladores.Jugador;
import usm.vjimenez.nojavasky.juego.controladores.Nave;
import usm.vjimenez.nojavasky.juego.entidades.planetas.*;
import usm.vjimenez.nojavasky.juego.entidades.planetas.tipos.*;
import usm.vjimenez.nojavasky.juego.controladores.MapaGalactico;

public class EstadoVisitandoPlaneta extends GameState {

    private boolean primeraVez;
    public EstadoVisitandoPlaneta(GameStateManager gsm, Jugador jugador, Nave nave, MapaGalactico mapa, boolean primeraVez) {
        super(gsm, jugador, nave, mapa); // Llama al constructor de GameState
        this.primeraVez = primeraVez;
    }

    @Override
    public void mostrarOpciones() {
        boolean enMenuVisita = true;
        if (primeraVez) {
            simularEncendidoMonitor();
            animarEntradaAlPlaneta();
        }
       
        while (enMenuVisita) {
            limpiarPantalla();
            mostrarDescenso();
            mostrarInterface();
    
            System.out.println("¿Qué deseas hacer?");
            // Verifica si el planeta actual implementa la interfaz TieneAsentamientos
            if (mapa.getPlanetaActual() instanceof tieneAsentamientos) {
                System.out.println("[0] Visitar asentamientos");
            }
            System.out.println("[1] Extraer recursos");
            System.out.println("[2] Ver inventario");
            System.out.println("[3] Volver a órbita");
    
            int opcion = scanner.nextInt();
    
            switch (opcion) {
                case 0:
                    if ( (mapa.getPlanetaActual() instanceof tieneAsentamientos)) {
                       
                        limpiarPantalla();
                        mostrarDescenso();
                        animarCaminoAsentamientos();
                        cambiarEstado(new EstadoVisitaAsentamientos(gsm, jugador, nave, mapa));
                        enMenuVisita = false;
                    } else {
                        System.out.println("Opción no válida.");
                    }
                    pausa();
                    break;
                case 1:
                    // Lógica para extraer recursos (se implementará después)
                    limpiarPantalla();
                    cambiarEstado(new EstadoExtraccionRecursos(gsm, jugador, nave, mapa));
                    enMenuVisita = false;
                    break;
    
                case 2:
                    limpiarPantalla();
                    mostrarDescenso();
                    mostrarInterface();
                    mostrarInventario();
                    break;
    
                case 3:
                    if (mapa.getPlanetaActual().salir()) {
                        limpiarPantalla();
                        simularEncendidoMonitor();
                        animarSalidaDelPlaneta();
                        cambiarEstado(new EstadoOrbita(gsm, jugador, nave, mapa));
                        enMenuVisita = false; // Salir del menú
                        break;
    
                    }else{ System.out.println("Error por poco combustible");}
                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
                    pausa();
                    break;
            }
        }
    }


    private void animarCaminoAsentamientos() {
        String[] mensajes = {
            "Observas unas estructuras a lo lejos..",
            "Que curiosidad...",
            "Caminas...",
            "Y caminas..."
        };

        for (String mensaje : mensajes) {
            System.out.println(mensaje);
            pausaAnimacion(500); // Pausa por 1 segundo entre mensajes
        }
        mostrarDescenso(); // Mostrar el descenso después del efecto del monitor
    }

    private void animarSalidaDelPlaneta() {
        String[] mensajes = {
            "Empacando suministros...",
            "Encendiendo motores de la nave...",
            "Despegue...",
            "Ya en orbira, listo para saltar por el espacio..."
        };

        for (String mensaje : mensajes) {
            System.out.println(mensaje);
            pausaAnimacion(300); // Pausa por 1 segundo entre mensajes
        }
        mostrarDescenso(); // Mostrar el descenso después del efecto del monitor
    }
    
    private void animarEntradaAlPlaneta() {
        String[] mensajes = {
            "Bajando al planeta...",
            "Analizando datos...",
            "Preparando exotraje...",
            "Listo para la exploración..."
        };

        for (String mensaje : mensajes) {
            System.out.println(mensaje);
            pausaAnimacion(300); // Pausa por 1 segundo entre mensajes
        }
        mostrarDescenso(); // Mostrar el descenso después del efecto del monitor
    }

    private void simularEncendidoMonitor() {
        String[] encendido = {
            " . . .",
            " . . █",
            " . . .",
            " . . █",
            " . . .",
            " . . █",
            " . . .",
        };

        for (String mensaje : encendido) {
            limpiarPantalla(); // Limpia la pantalla para un mejor efecto visual
            System.out.println(mensaje);
            pausaAnimacion(200); // Pausa por 500 ms entre cada línea
        }
        limpiarPantalla();
    }

    public static void mostrarDescenso() {
        String arte = 
            "*                                            ✧₊                                        ₊                 \n" +
            "                    ooooo \n" +
            "           /█████\\oo    o                                   *                                       ₊                 \n" +
            "          /███████\\  ooo             ██                                           *            \n" +
            "          ████████ooo\n" +
            "        oo██████oo█\n" +
            "       o  \\███oo██/         *                   ₊                       █                 *                    ₊\n" +
            "      o    ooo███/\n" +
            "      ooooo                  \n" +
            "                                    *          ₊                                 *                   ✧₊  \n" +
            "                                                         *                                            \n" +
            "  ₊  \n" +
            "                 *                        ₊                           *                   ₊     \n" +
            "\n" +
            "                                                                                                      /\\\n" +
            "        ██                     *                                                                 /\\  /  \\     ₊ \n" +
            "                                                                                                /  \\/    \\\n" +
            "                    /\\                                                           ✧₊            /    \\     \\\n" +
            "                   /  \\                          ₊                    /\\                      /      \\     \\\n" +
            "__________________/    \\___________________________________________/\\/  \\____________________/        \\_____\\______\n";

        System.out.println(arte); // Muestra el arte en la consola
    }

    public void mostrarInterface() {
        Planeta planetaActual = mapa.getPlanetaActual();
        System.out.println("==========================================================================================================================");
        System.out.println("|                                             Información del Planeta Actual                                             |");
        System.out.println("==========================================================================================================================");
        System.out.println("|------------------------------------------------------------------------------------------------------------------------|");

        

        System.out.println("Tipo de planeta: " + planetaActual.getTipo()); // Suponiendo que tienes un método para obtener el tipo de planeta
        System.out.println("Posición del planeta: " + mapa.getPosicionActual()); // Método que obtiene la posición
        System.out.println("Radio del planeta: " + planetaActual.getRadio() + " metros"); // Suponiendo que tienes un método para obtener el radio
        
        // Mostrar los recursos
        System.out.println("Recursos disponibles:");
        System.out.println("Cristales de Hidrógeno: " + planetaActual.getCristalesHidrogeno() + " unidades");
        System.out.println("Flores de Sodio: " + planetaActual.getFloresDeSodio() + " unidades");

        if (planetaActual instanceof Radioactivo) {
            Radioactivo radioactivo = (Radioactivo) planetaActual;
            System.out.println("Uranio: " + radioactivo.getUranio() + " unidades");
            System.out.println("Radiación: " + radioactivo.getRadiacion() + " Rad");
        } else if (planetaActual instanceof Volcanico) {
            Volcanico volcanico = (Volcanico) planetaActual;
            System.out.println("Platino: " + volcanico.getPlatino() + " unidades");
            System.out.println("Temperatura: " + volcanico.getTemperatura()+ " ºC");
        } else if (planetaActual instanceof Oceanico) {
            Oceanico oceanico = (Oceanico) planetaActual;
            System.out.println("Profundidad: " + oceanico.getProfundidad()+ " metros");
        } else if (planetaActual instanceof Helado) {
            Helado helado = (Helado) planetaActual;
            System.out.println("Temperatura: " + helado.getTemperatura() + " ºC");
        }   

        if (planetaActual instanceof tieneAsentamientos) {
            System.out.println("Este planeta tiene asentamientos.");
        } else {
            System.out.println("Este planeta no tiene asentamientos.");
        }
        
        // Información del jugador
        System.out.println("|------------------------------------------------------------------------------------------------------------------------|");
        System.out.println("Energía del traje: " + jugador.getUnidadesEnergiaProteccion() + " unidades de energia de proteccion");
        System.out.println("Eficiencia del traje: " + jugador.getEficienciaEnergiaProteccion() + " %");
        System.out.println("|------------------------------------------------------------------------------------------------------------------------|");
        System.out.println("Combustible: " + nave.getUnidadesCombustible() + " unidades de combustible");
        System.out.println("Eficiencia de la nave: " + nave.getEficienciaPropulsor()+ " %");
        System.out.println("|------------------------------------------------------------------------------------------------------------------------|");
        System.out.println("==========================================================================================================================");
    
        }
        

    // Método para mostrar el inventario del jugador
    private void mostrarInventario() {
        jugador.getInventario().mostrarInventario(jugador, nave);
    }
}


