package usm.vjimenez.nojavasky;

import usm.vjimenez.nojavasky.juego.controladores.MapaGalactico;
import usm.vjimenez.nojavasky.juego.controladores.Nave;
// import usm.vjimenez.nojavasky.juego.entidades.planetas.Planeta;

import java.util.Scanner;

public class NoJavaSky{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Nave nave = new Nave();
        MapaGalactico mapaGalactico = new MapaGalactico();
        
        mapaGalactico.generadorPlaneta(); // Generar planetas al inicio
        
        
        // Bucle principal del juego
        boolean jugando = true;
        while (jugando) {
            System.out.println("Combutible: "+ nave.getUnidadesCombustible());
            System.out.println("Posicion actual: "+ mapaGalactico.getPosicionActual());
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Mostrar mapa galáctico");
            System.out.println("2. Viajar a otro planeta");
            System.out.println("3. Analizar saltos");
            System.out.println("4. Salir");
            System.out.print("Opción: ");
            int opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    // Mostrar mapa galáctico
                    mapaGalactico.mostrarMapa();
                    break;

                case 2:

                    // Viajar a otro planeta
                    System.out.print("Ingrese la dirección de su siguiente salto: \n 1. Adelante\n 2. Atras ");
                    int direccion = scanner.nextInt();
                    if (direccion == 1) {
                        direccion = 1;
                    }else if (direccion == 2) {
                        direccion = -1;
                    }else{
                        System.out.println("Dirección invalida.");
                        break;
                    }
                    // Verificar si el salto está dentro de los límites (por delante o por atrás)
                    if (mapaGalactico.getPosicionActual() == 0 && direccion == -1) {
                        System.out.println("No puedes saltar más atrás del origen.");
                        break;
                    }

                    System.out.print("Ingrese el tamaño del salto: ");
                    int tamanoSalto = scanner.nextInt();

                    if (nave.viajarPlaneta(mapaGalactico, direccion, tamanoSalto)) {
                        System.out.println("¡Salto exitoso!");
                    } else {
                        System.out.println("El salto falló.");
                    }
                    break;
 
                
                case 3:
                    System.out.println("Este es el analizador de saltos 200a\n ¿Qué deseas hacer? ");
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
                            }else{
                                System.out.println("Tienes "+ saltosDisponibles + " opciones de salto si la distancia de estos es "+ distanciaSalto);
                            }
                        }
                        else if (opcionAnalisis == 2) {

                            analisisTerminado = true;
                        }
                        
                    }
                    break;
                   

                case 4:
                    // Salir del juego
                    System.out.println("Saliendo del juego...");
                    jugando = false;
                    break;

                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
                    break;
            }
        }
        
        scanner.close(); // Cerrar el escáner al salir
    }
}