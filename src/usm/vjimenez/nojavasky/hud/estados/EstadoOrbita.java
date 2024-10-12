package usm.vjimenez.nojavasky.hud.estados;

import usm.vjimenez.nojavasky.hud.GameStateManager;
import usm.vjimenez.nojavasky.juego.controladores.Jugador;
import usm.vjimenez.nojavasky.juego.controladores.Nave;
import usm.vjimenez.nojavasky.juego.controladores.MapaGalactico;
import usm.vjimenez.nojavasky.utilidad.RandomNumberGenerator;


public class EstadoOrbita extends GameState {

    public EstadoOrbita(GameStateManager gsm, Jugador jugador, Nave nave, MapaGalactico mapa) {
        super(gsm, jugador, nave, mapa); // Llama al constructor de GameState
    }


    // Método para mostrar las opciones del menú
    private void mostrarOpcionesMenu() {
        System.out.println("Seleccione una opción:");
        System.out.println("[1] Bajar al planeta");
        System.out.println("[2] Viajar a otro planeta");
        System.out.println("[3] Mostrar mapa galáctico");
        System.out.println("[4] Mostrar inventario");
        System.out.println("[5] Terminar juego");
    }

    @Override
    public void mostrarOpciones() {
        boolean jugando = true;

        while (jugando) {
            limpiarPantalla();
            mostrarCabecera(); // Muestra el arte ASCII y la información relevante
            mostrarEstadoActual(); // Mostrar estado del jugador y la nave
            mostrarOpcionesMenu(); // Muestra las opciones del menú

            int opcion = scanner.nextInt(); // Usar el scanner de la superclase

            switch (opcion) {
                case 1:
                    efectoCerrarOjos(); // Llama al efecto antes de bajar al planeta
                    boolean enMenuPlaneta = true;

                    while (enMenuPlaneta) {
                        limpiarPantalla();
                        resetCabecera();
                        System.out.println("Submenú: Exploración del Planeta");
                        System.out.println("[1] Mostrar información del planeta");
                        System.out.println("[2] Bajar al planeta");
                        System.out.println("[3] Volver");

                        int opcionPlaneta = scanner.nextInt();

                        switch (opcionPlaneta) {
                            case 1:
                                // Mostrar la información del planeta
                                limpiarPantalla();
                                resetCabecera();
                                mostrarBajarPlaneta();
                                pausa();
                                break;

                            case 2:
                                // Bajar al planeta
                                limpiarPantalla();
                                cambiarEstado(new EstadoVisitandoPlaneta(gsm, jugador, nave, mapa,true));
                                enMenuPlaneta = false; // Salir del submenú después de bajar al planeta
                                jugando = false;
                                break;

                            case 3:
                                // Volver al menú principal
                                enMenuPlaneta = false; // Salir del submenú y volver al menú principal
                                break;

                            default:
                                System.out.println("Opción no válida, por favor intente de nuevo.");
                                pausa(); // Pausa antes de continuar
                                break;
                        }
                    }
                            
                    break;
                
                case 2:
                    efectoCerrarOjos(); // Llama al efecto antes de mostrar el submenu de viaje
                    mostrarSubmenuViaje();
                    break;
            
                case 3:
                    efectoCerrarOjos(); // Llama al efecto antes de mostrar el mapa
                    limpiarPantalla();
                    resetCabecera();
                    mapa.mostrarMapa();
                    pausa();
                    break;
            
                case 4:
                    efectoCerrarOjos(); // Llama al efecto antes de mostrar el inventario
                    limpiarPantalla();
                    resetCabecera();
                    mostrarInventario();
                    break;
            
                case 5:
                    efectoCerrarOjos();
                    limpiarPantalla();
                    mostrarCabeceraMuerto();
                    System.out.println("--------------------------------------------------------");
                    System.out.println("Saliste de la nave");
                    gsm.cerrarScanner(); 
                    jugando = false;
                    break;
            
                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
                    pausa(); // Pausa antes de continuar
                    break;
            }
            
        }
    }

    

    // Método para mostrar la información del planeta
    private void mostrarBajarPlaneta() {
        String tipoPlaneta = mapa.getPlanetaActual().getTipo();
        
        // Simular una pantalla de computadora con la descripción
        System.out.println("==============================================");
        System.out.println("|              Información del Planeta        |");
        System.out.println("==============================================");
        System.out.println("| Tipo: " + tipoPlaneta);
        System.out.println("|--------------------------------------------|");
        String descripcion = mapa.generadorPlaneta().getDescripcion();
        
        // Formatear la descripción para que parezca dentro de una pantalla
        mostrarDescripcionEnPantalla(descripcion, 44);
        System.out.println("==============================================");

        // Condición de victoria
        if (tipoPlaneta.equals("Centro Galactico") && nave.getEficienciaPropulsor() < 50) {
            System.out.println("Aún no puedes llegar a este lugar, necesitas una mejor nave");
        } else if (tipoPlaneta.equals("Centro Galactico") && nave.getEficienciaPropulsor() >= 50) {
            System.out.println("Ganaste");
            System.exit(0); // Termina el juego
        }
    }

    // Método para mostrar la descripción con ajuste de líneas
    private void mostrarDescripcionEnPantalla(String texto, int anchoMaximo) {
        String[] palabras = texto.split(" ");
        StringBuilder lineaActual = new StringBuilder();

        for (String palabra : palabras) {
            if (lineaActual.length() + palabra.length() + 1 > anchoMaximo) {
                // Cuando la línea excede el ancho máximo, imprime y resetea la línea
                System.out.println("| " + formatearLinea(lineaActual.toString(), anchoMaximo) + " |");
                lineaActual = new StringBuilder(palabra);
            } else {
                if (lineaActual.length() > 0) {
                    lineaActual.append(" ");
                }
                lineaActual.append(palabra);
            }
        }
        // Imprimir la última línea
        if (lineaActual.length() > 0) {
            System.out.println("| " + formatearLinea(lineaActual.toString(), anchoMaximo) + " |");
        }
    }

    // Método para formatear una línea con espacios si es más corta que el ancho máximo
    private String formatearLinea(String texto, int anchoMaximo) {
        return String.format("%-" + anchoMaximo + "s", texto); // Completa con espacios si es más corto
    }
    
    // Método para mostrar el inventario del jugador
    private void mostrarInventario() {
        jugador.getInventario().mostrarInventario(jugador, nave);
    }


    private void efectoCerrarOjos() {
        int milisegundos = RandomNumberGenerator.rand(100, 150);
        limpiarPantalla();
        mostrarCabeceraCerrandoOjos(); // Mostrar arte ASCII "cerrando los ojos"
        mostrarEstadoActual();
        pausaAnimacion(milisegundos); // Mantenerlo visible brevemente
        limpiarPantalla();
        mostrarCabecera(); // Volver a mostrar el arte ASCII original
        mostrarEstadoActual();
    }
    
    

    // Método para mostrar el estado actual de la nave y el jugador
    private void mostrarEstadoActual() {
        System.out.println("Estado del Jugador: " + jugador.getNombreJugador());
        System.out.println("Estado del Exotraje: Energía: " + jugador.getUnidadesEnergiaProteccion() + " | Eficiencia: " + jugador.getEficienciaEnergiaProteccion() + "%");
        System.out.println("Estado de la Nave: Combustible: " + nave.getUnidadesCombustible() + " | Eficiencia: " + nave.getEficienciaPropulsor() + "%");
        System.out.println("Orbitando | Planeta Actual: " + mapa.getPlanetaActual().getTipo() + " | Posición: " + mapa.getPosicionActual());
        System.out.println("--------------------------------------------------------");
    }

    // Nueva opción: Menú para viajar a otro planeta
    private void mostrarSubmenuViaje() {
        boolean enSubmenu = true;
        while (enSubmenu) {
            limpiarPantalla();
            resetCabecera();
            System.out.println("Submenú: Viajar a otro planeta");
            System.out.println("[1] Dar salto espacial");
            System.out.println("[2] Analizar saltos");
            System.out.println("[3] Volver");

            int opcionViaje = scanner.nextInt();

            switch (opcionViaje) {
                case 1:
                    efectoCerrarOjos();
                    limpiarPantalla();
                    resetCabecera();
                    realizarViaje();
                    enSubmenu = false;
                    break;
                case 2:
                    resetCabecera();
                    analizarSaltos();
                    break;
                case 3:
                    enSubmenu = false;  // Volver al menú principal
                    efectoCerrarOjos(); 
                    limpiarPantalla();
                    resetCabecera();
                    break;
                default:
                    System.out.println("Opción no válida.");
                    pausa();
                    break;
            }
        }
    }

    // Método para realizar un viaje a otro planeta
    private void realizarViaje() {
        resetCabecera();

        if (mapa.getPosicionActual() == 0) {
            System.out.print("Ingrese la dirección de su siguiente salto: \n[1] Adelante\n[3] Volver\n");
        } else {
            System.out.print("Ingrese la dirección de su siguiente salto: \n[1] Adelante\n[2] Atrás\n[3] Volver\n");
        }

        int direccion = scanner.nextInt();

        if (direccion == 1) {
            direccion = 1;
        } else if (direccion == 2) {
            direccion = -1;
        } else if (direccion == 3) {
            efectoCerrarOjos(); 
            limpiarPantalla();
            resetCabecera();
            return; // Volver al submenú
        } else {
            System.out.println("Dirección inválida.");
            pausa();
            return;
        }

        System.out.print("Ingrese el tamaño del salto: ");
        int tamanoSalto = scanner.nextInt();

        efectoCerrarOjos(); 
        limpiarPantalla();
        resetCabecera();

        if (nave.viajarPlaneta(mapa, direccion, tamanoSalto)) {
            System.out.println("El salto ha sido exitoso.");
        } else {
            System.out.println("El salto ha fallado.");
        }
        pausa();
    }

    // Método para analizar los saltos disponibles
    private void analizarSaltos() {
        resetCabecera();
        System.out.println("Stellar Pathway Analyzer 2.0\n¿Qué deseas hacer?");
        boolean analisisTerminado = false;

        while (!analisisTerminado) {
            System.out.println("[1] Analizar saltos");
            System.out.println("[2] Volver");

            int opcionAnalisis = scanner.nextInt();

            if (opcionAnalisis == 1) {
                efectoCerrarOjos(); // Llama al efecto antes de mostrar el inventario
                limpiarPantalla();
                resetCabecera();
                resetCabecera();
                System.out.println("Indica el tamaño del salto que quieres analizar: ");
                int distanciaSalto = scanner.nextInt();
                int opciones = nave.analizarSaltos(distanciaSalto);
                System.out.println("Hay " + opciones + " opciones de salto disponibles.");
            } else if (opcionAnalisis == 2) {
                efectoCerrarOjos(); // Llama al efecto antes de mostrar el inventario
                limpiarPantalla();
                resetCabecera();
                analisisTerminado = true;
                resetCabecera();
            } else {
                System.out.println("Opción no válida.");
            }
        }
    }

    private void resetCabecera() {
        limpiarPantalla();
        mostrarCabecera();
        mostrarEstadoActual();
    }

    // Método para mostrar el arte ASCII y la información del jugador
    private void mostrarCabecera() {
        System.out.println("                                         ████████████                                                ");
        System.out.println("                                      ██████████████████                                             ");
        System.out.println("                                   ████████████████████████                                          ");
        System.out.println("                                   ████████████████████████                                         ");
        System.out.println("                                 ██████                ██████                                       ");
        System.out.println("                               █████    ███████████████   █████                                    ");
        System.out.println("                               ███   ███               ███   ███                                  ");
        System.out.println("                              ███ ███   ███████████████   ███  ███                                ");
        System.out.println("                              ██ █   ██████████████████████   █ ██                                ");
        System.out.println("                             █  █  ██████████████████████████  █  █                               ");
        System.out.println("                            ██  █  ███████ █████████ ████████  █  ██                               ");
        System.out.println("                            ██  █  █████     █████     ██████  █  ██                               ");
        System.out.println("                            ██  █  █████     █████     ██████  █  ██                               ");
        System.out.println("                            ██  █  █████     █████     ██████  █  ██                               ");
        System.out.println("                            ██  █  █████     █████     ██████  █  ██                               ");
        System.out.println("                            ██  █  █████     █████     ██████  █  ██                               ");
        System.out.println("                            ██  █  ███████ █████████ ████████  █  ██                               ");
        System.out.println("                              █  █  ████████████████████████  █  █                                 ");
        System.out.println("                              ███  █  ███████      ███████  █  ███                                  ");
        System.out.println("                              ████  █   ████████████████   █  ████                                  ");
        System.out.println("                               █████ ██  ██████████████  ██ █████                                  ");
        System.out.println("                               ███████ ██████████████████ ███████                                    ");
        System.out.println("                              █  ██████████████████████████████  █                                    ");
        System.out.println("                           ██  ██ ████████████████████████████ ██  ██                                ");
        System.out.println("                           ████ ██  █████   █     █   █████  ██ █████                                ");
        System.out.println("                         ████████ ██  ███   █     █   ████  ██ ████████                              ");
        System.out.println("                         ██████████ █ ████████████████████ █ ██████████                             ");
        System.out.println("                       █████████████  ████████████████████  █████████████                           ");
        System.out.println("                      ██████████████  █  █            █  █  ██████████████                          ");
        System.out.println("                     ███████████████  █  ██████████████  █  ███████████████                         ");
        System.out.println("                   █████████          ████            ████          █████████                        ");
        System.out.println("                   █████████  ██████  ███ ████████████ ███  ██████  █████████                       ");
        System.out.println("                 ███████████  █    █  ███ ██        ██ ███  █    █  ██████████                      ");
        System.out.println("                ████████████  ██████  ███ ████████████ ███  ██████  ███████████                     ");
        System.out.println("                ████████████          ███ ██        ██ ███          ███████████                    ");
        System.out.println("                ████████████████████  ███ ████████████ ███  ███████████████████                    ");
        System.out.println();
    }
    
    private void mostrarCabeceraCerrandoOjos() {
        System.out.println("                                         ████████████                                                ");
        System.out.println("                                      ██████████████████                                             ");
        System.out.println("                                   ████████████████████████                                          ");
        System.out.println("                                   ████████████████████████                                         ");
        System.out.println("                                 ██████                ██████                                       ");
        System.out.println("                               █████    ███████████████   █████                                    ");
        System.out.println("                               ███   ███               ███   ███                                  ");
        System.out.println("                              ███ ███   ███████████████   ███  ███                                ");
        System.out.println("                              ██ █   ██████████████████████   █ ██                                ");
        System.out.println("                             █  █  ██████████████████████████  █  █                               ");
        System.out.println("                            ██  █  ██████████████████████████  █  ██                               ");
        System.out.println("                            ██  █  ██████████████████████████  █  ██                               ");
        System.out.println("                            ██  █  █████     █████     ██████  █  ██                               ");
        System.out.println("                            ██  █  ██████████████████████████  █  ██                               ");
        System.out.println("                            ██  █  ██████████████████████████  █  ██                               ");
        System.out.println("                            ██  █  ██████████████████████████  █  ██                               ");
        System.out.println("                            ██  █  ██████████████████████████  █  ██                               ");
        System.out.println("                              █  █  ████████████████████████  █  █                                 ");
        System.out.println("                              ███  █  ███████      ███████  █  ███                                  ");
        System.out.println("                              ████  █   ████████████████   █  ████                                  ");
        System.out.println("                               █████ ██  ██████████████  ██ █████                                  ");
        System.out.println("                               ███████ ██████████████████ ███████                                    ");
        System.out.println("                              █  ██████████████████████████████  █                                    ");
        System.out.println("                           ██  ██ ████████████████████████████ ██  ██                                ");
        System.out.println("                           ████ ██  █████   █     █   █████  ██ █████                                ");
        System.out.println("                         ████████ ██  ███   █     █   ████  ██ ████████                              ");
        System.out.println("                         ██████████ █ ████████████████████ █ ██████████                             ");
        System.out.println("                       █████████████  ████████████████████  █████████████                           ");
        System.out.println("                      ██████████████  █  █            █  █  ██████████████                          ");
        System.out.println("                     ███████████████  █  ██████████████  █  ███████████████                         ");
        System.out.println("                   █████████          ████            ████          █████████                        ");
        System.out.println("                   █████████  ██████  ███ ████████████ ███  ██████  █████████                       ");
        System.out.println("                 ███████████  █    █  ███ ██        ██ ███  █    █  ██████████                      ");
        System.out.println("                ████████████  ██████  ███ ████████████ ███  ██████  ███████████                     ");
        System.out.println("                ████████████          ███ ██        ██ ███          ███████████                    ");
        System.out.println("                ████████████████████  ███ ████████████ ███  ███████████████████                    ");
        System.out.println();
    }

    private void mostrarCabeceraMuerto() {
        System.out.println("                                        ███    ██                                      ");
        System.out.println("                                                       █     █                                  ");
        System.out.println("                                           ███    ██    ██    ███                               ");
        System.out.println("                                                      ███                                           ");
        System.out.println("                                           ██████████                                                ");
        System.out.println("                                      ███████████████████  ██                                        ");
        System.out.println("                                    ██ ███████████████████                                           ");
        System.out.println("                                    ██████████████████████                                           ");
        System.out.println("                                 ██ ██████████████████████ ██                                        ");
        System.out.println("                               ██   ██████████████████████   ██                                      ");
        System.out.println("                               ██ ██████████████████████████ ████                                    ");
        System.out.println("                             ████ █████████████████████████  ██ ██                                  ");
        System.out.println("                              ██  █████████████████████████  ██ ██                                  ");
        System.out.println("                            ██ ██ ███████  █████████  ███████ ██  █                                 ");
        System.out.println("                            ██ ██ █████      █████      █████  █  █                                 ");
        System.out.println("                            ██ ██ ███   ███    █   ███    ███  ████                                 ");
        System.out.println("                            ██ ██ █████      █████      █████  ████                                 ");
        System.out.println("                            ██ ██ ███████  ████  ███  ███████ ██  █                                 ");
        System.out.println("                            █████  ██████████     ███████████ ██  █                                 ");
        System.out.println("                            ██   █   ██████████  ██████████  ██   ██                                ");
        System.out.println("                             ██  ██     █████████████████    ██ ██                                  ");
        System.out.println("                              ███ ████    █████████████    ██  ███                                  ");
        System.out.println("                              ████  ███   █████████████  ██  █████                                  ");
        System.out.println("                             ██████   ███ ██ ██  █  █   ██ ███████                                  ");
        System.out.println("                              ████████                 █  ███████                                    ");
        System.out.println("                              █  ██████████████████████████████  █                                    ");
        System.out.println("                           ██  ██ ████████████████████████████ ██  ██                                ");
        System.out.println("                           ████ ██  █████   █     █   █████  ██ █████                                ");
        System.out.println("                         ████████ ██  ███   █     █   ████  ██ ████████                              ");
        System.out.println("                         ██████████ █ ████████████████████ █ ██████████                             ");
        System.out.println("                       █████████████  ████████████████████  █████████████                           ");
        System.out.println("                      ██████████████  █  █            █  █  ██████████████                          ");
        System.out.println("                     ███████████████  █  ██████████████  █  ███████████████                         ");
        System.out.println("                   █████████          ████            ████          █████████                        ");
        System.out.println("                   █████████  ██████  ███ ████████████ ███  ██████  ██  █  ██                       ");
        System.out.println("                 ███████████  █    █  ███ ██        ██ ███  █    █  ██  █  ███                      ");
        System.out.println("                ████████████  ██████  ███ ████████████ ███  ██████  ███████████                     ");
        System.out.println("                ████████████          ███ ██        ██ ███          ██  █  ████                    ");
        System.out.println("                ████████████████████  ███ ████████████ ███  ███████████████████                       ");
        System.out.println();
    }
    

}
