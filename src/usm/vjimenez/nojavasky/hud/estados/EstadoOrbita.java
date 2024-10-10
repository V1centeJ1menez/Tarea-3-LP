package usm.vjimenez.nojavasky.hud.estados;

import java.util.Scanner;
import usm.vjimenez.nojavasky.hud.GameStateManager;
import usm.vjimenez.nojavasky.juego.controladores.*;

public class EstadoOrbita extends GameState {
    private Scanner scanner;

    public EstadoOrbita(GameStateManager gsm, Jugador jugador, Nave nave, MapaGalactico mapa) {
        super(gsm, jugador, nave, mapa); // Llama al constructor de GameState
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void mostrarOpciones() {
        boolean jugando = true;

        while (jugando) {
            System.out.println("Combustible: " + nave.getUnidadesCombustible());
            System.out.println("Posición actual: " + mapa.getPosicionActual());
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Mostrar mapa galáctico");
            System.out.println("2. Viajar a otro planeta");
            System.out.println("3. Analizar saltos");
            System.out.println("4. Salir");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    mapa.mostrarMapa();
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
                    break;
            }
        }
    }

    private void realizarViaje() {
        System.out.print("Ingrese la dirección de su siguiente salto: \n1. Adelante\n2. Atrás ");
        int direccion = scanner.nextInt();
        if (direccion == 1) {
            direccion = 1;
        } else if (direccion == 2) {
            direccion = -1;
        } else {
            System.out.println("Dirección inválida.");
            return;
        }

        // Verificar si el salto está dentro de los límites
        if (mapa.getPosicionActual() == 0 && direccion == -1) {
            System.out.println("No puedes saltar más atrás del origen.");
            return;
        }

        System.out.print("Ingrese el tamaño del salto: ");
        int tamanoSalto = scanner.nextInt();

        if (nave.viajarPlaneta(mapa, direccion, tamanoSalto)) {
            System.out.println("¡Salto exitoso!");
            // Aquí puedes agregar lógica para verificar si el viaje fue exitoso
        } else {
            System.out.println("El salto falló.");
        }
    }

    private void analizarSaltos() {
        System.out.println("Este es el analizador de saltos 200a\n¿Qué deseas hacer?");
        boolean analisisTerminado = false;

        while (!analisisTerminado) {
            System.out.println("1. Analizar saltos");
            System.out.println("2. Salir");
            int opcionAnalisis = scanner.nextInt();

            if (opcionAnalisis == 1) {
                System.out.println("Indica el tamaño del salto que quieres analizar: ");
                int distanciaSalto = scanner.nextInt();
                int saltosDisponibles = nave.analizarSaltos(distanciaSalto);

                if (saltosDisponibles == 0) {
                    System.out.println("No tienes opciones de salto.");
                } else {
                    System.out.println("Tienes " + saltosDisponibles + " opciones de salto si la distancia de estos es " + distanciaSalto);
                }
            } else if (opcionAnalisis == 2) {
                analisisTerminado = true;
            }
        }
    }
}
