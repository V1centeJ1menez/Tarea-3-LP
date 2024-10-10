package usm.vjimenez.nojavasky.hud.estados;

import usm.vjimenez.nojavasky.hud.GameStateManager;
import usm.vjimenez.nojavasky.juego.controladores.Jugador;
import usm.vjimenez.nojavasky.juego.controladores.Nave;
import usm.vjimenez.nojavasky.juego.controladores.MapaGalactico;

public class EstadoOrbita extends GameState {

    public EstadoOrbita(GameStateManager gsm, Jugador jugador, Nave nave, MapaGalactico mapa) {
        super(gsm, jugador, nave, mapa); // Llama al constructor de GameState
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
                    limpiarPantalla();
                    resetCabecera();
                    mapa.mostrarMapa();
                    pausa();
                    break;

                case 2:
                    realizarViaje();
                    break;

                case 3:
                    analizarSaltos();
                    break;

                case 4:
                    System.out.println("Saliendo del juego...");
                    jugando = false;
                    break;

                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
                    pausa(); // Pausa antes de continuar
                    break;
            }
        }
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

    // Método para mostrar el estado actual de la nave y el jugador
    private void mostrarEstadoActual() {
        System.out.println("Estado del Jugador: " + jugador.getNombreJugador());
        System.out.println("Estado del Exotraje: Energía: " + jugador.getUnidadesEnergiaProteccion() + " | Eficiencia: " + jugador.getEficienciaEnergiaProteccion() + "%");
        System.out.println("Estado de la Nave: Combustible: " + nave.getUnidadesCombustible() + " | Eficiencia: " + nave.getEficienciaPropulsor() + "%");
        System.out.println("Planeta Actual: " + mapa.getPlanetaActual().getTipo() + " | Posición: " + mapa.getPosicionActual());
        System.out.println("--------------------------------------------------------");
    }

    private void resetCabecera(){
        limpiarPantalla();
        mostrarCabecera();
        mostrarEstadoActual();
    }

    // Método para mostrar las opciones del menú
    private void mostrarOpcionesMenu() {
        System.out.println("Seleccione una opción:");
        System.out.println("[1] Mostrar mapa galáctico");
        System.out.println("[2] Viajar a otro planeta");
        System.out.println("[3] Analizar saltos SPA2.0");
        System.out.println("[4] Terminar juego");
    }


    private void realizarViaje() {
        resetCabecera();

        if (mapa.getPosicionActual() == 0){
            System.out.print("Ingrese la dirección de su siguiente salto: \n[1] Adelante\n[3] Volver\n");
        }else{
            System.out.print("Ingrese la dirección de su siguiente salto: \n[1] Adelante\n[2] Atrás\n[3] Volver\n");
        }
        int direccion = scanner.nextInt();
        resetCabecera();
        if (direccion == 1) {
            direccion = 1;
        } else if (direccion == 2) {
            direccion = -1;
        } else if (direccion== 3) {
            resetCabecera();
            return;
            
        } else {
            System.out.println("Dirección inválida.");
            pausa();
            return;
        }
        
        // Verificar si el salto está dentro de los límites
        if (mapa.getPosicionActual() == 0 && direccion == -1) {
            System.out.println("No puedes saltar más atrás del origen.");
            pausa();
            return;
        }

        resetCabecera();
        System.out.print("Ingrese el tamaño del salto: ");
        int tamanoSalto = scanner.nextInt();

        if (nave.viajarPlaneta(mapa, direccion, tamanoSalto)) {
            System.out.println("El salto ha sido exitoso.");
            pausa();
            // Aquí puedes agregar lógica para verificar si el viaje fue exitoso
        } else {
            System.out.println("El salto ha fallado.");
            pausa();
        }
    }

    private void analizarSaltos() {
        resetCabecera();
        System.out.println("Stellar Pathway Analyzer 2.0\n¿Qué deseas hacer?");
        boolean analisisTerminado = false;

        while (!analisisTerminado) {
            System.out.println("[1] Analizar saltos");
            System.out.println("[2] Volver");
            int opcionAnalisis = scanner.nextInt();

            if (opcionAnalisis == 1) {
                resetCabecera();
                System.out.println("Indica el tamaño del salto que quieres analizar: ");
                int distanciaSalto = scanner.nextInt();
                int opciones = nave.analizarSaltos(distanciaSalto);
                System.out.println("Hay " + opciones + " opciones de salto disponibles.");
            } else if (opcionAnalisis == 2) {
                analisisTerminado = true;
                resetCabecera();
            } else {
                System.out.println("Opción no válida.");
            }
        }
    }
}
