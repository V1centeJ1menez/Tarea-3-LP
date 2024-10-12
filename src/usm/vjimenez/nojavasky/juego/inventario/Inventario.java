package usm.vjimenez.nojavasky.juego.inventario;

import usm.vjimenez.nojavasky.hud.estados.GameState;
import usm.vjimenez.nojavasky.juego.controladores.Jugador;
import usm.vjimenez.nojavasky.juego.controladores.Nave;
import java.util.Scanner;

public class Inventario {

    // Atributos
    private int cristalesHidrogeno;
    private int floresDeSodio;
    private int uranio;
    private int platino;

    protected Scanner scanner = new Scanner(System.in);


    // Constructor
    public Inventario(int cristalesHidrogeno, int floresDeSodio, int uranio, int platino) {
        this.cristalesHidrogeno = cristalesHidrogeno;
        this.floresDeSodio = floresDeSodio;
        this.uranio = uranio;
        this.platino = platino;
    }

    // Getters
    public int getCristalesHidrogeno() {
        return cristalesHidrogeno;
    }

    public int getFloresDeSodio() {
        return floresDeSodio;
    }

    public int getUranio() {
        return uranio;
    }

    public int getPlatino() {
        return platino;
    }

    // Setters
    public void setCristalesHidrogeno(int cristalesHidrogeno) {
        this.cristalesHidrogeno = cristalesHidrogeno;
    }

    public void setFloresDeSodio(int floresDeSodio) {
        this.floresDeSodio = floresDeSodio;
    }

    public void setUranio(int uranio) {
        this.uranio = uranio;
    }

    public void setPlatino(int platino) {
        this.platino = platino;
    }

    // Métodos para agregar recursos al inventario
    public void agregarCristalesHidrogeno(int cantidad) {
        if (cantidad > 0) {
            this.cristalesHidrogeno += cantidad;
        }
    }

    public void agregarFloresDeSodio(int cantidad) {
        if (cantidad > 0) {
            this.floresDeSodio += cantidad;
        }
    }

    public void agregarUranio(int cantidad) {
        if (cantidad > 0) {
            this.uranio += cantidad;
        }
    }

    public void agregarPlatino(int cantidad) {
        if (cantidad > 0) {
            this.platino += cantidad;
        }
    }

    // Métodos para retirar recursos del inventario
    public void retirarCristalesHidrogeno(int cantidad) {
        if (cantidad > 0 && this.cristalesHidrogeno >= cantidad) {
            this.cristalesHidrogeno -= cantidad;
        }
    }

    public void retirarFloresDeSodio(int cantidad) {
        if (cantidad > 0 && this.floresDeSodio >= cantidad) {
            this.floresDeSodio -= cantidad;
        }
    }

    public void retirarUranio(int cantidad) {
        if (cantidad > 0 && this.uranio >= cantidad) {
            this.uranio -= cantidad;
        }
    }

    public void retirarPlatino(int cantidad) {
        if (cantidad > 0 && this.platino >= cantidad) {
            this.platino -= cantidad;
        }
    }

    // Método para mostrar el estado del inventario con presentación mejorada
    public void mostrarInventario(Jugador jugador, Nave nave) {
        boolean enMenuInventario = true;

        while (enMenuInventario) {
            GameState.limpiarPantalla();
            System.out.println("\n=== Inventario del Jugador ===");
            System.out.println("┌─────────────────────────────┐");
            
            // Mostrar Cristales de Hidrógeno siempre
            System.out.printf("│ %-20s: %4d │\n", "Cristales de Hidrógeno", cristalesHidrogeno);
            
            // Mostrar Flores de Sodio siempre
            System.out.printf("│ %-20s: %4d │\n", "Flores de Sodio", floresDeSodio);
            
            // Mostrar Uranio sólo si el jugador tiene más de 0
            if (uranio > 0) {
                System.out.printf("│ %-20s: %4d │\n", "Uranio", uranio);
            }
            
            // Mostrar Platino sólo si el jugador tiene más de 0
            if (platino > 0) {
                System.out.printf("│ %-20s: %4d │\n", "Platino", platino);
            }

            System.out.println("└─────────────────────────────┘");
            
            // Mostrar combustible y energia actual
            System.out.println("Energia actual de traje: " + jugador.getUnidadesEnergiaProteccion());
            System.out.println("Combustible actual de nave: " + nave.getUnidadesCombustible());

            // Mostrar opciones adicionales para recargar y volver
            System.out.println("\nOpciones:");
            System.out.println("[1] Recargar energía de exotraje (Flores de Sodio)");
            System.out.println("[2] Recargar combustible de nave (Cristales de Hidrogeno)");
            System.out.println("[3] Volver");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Recargar energía del exotraje
                    recargarEnergiaExotraje(jugador);
                    GameState.pausa();
                    break;

                case 2:
                    // Recargar combustible de la nave
                    recargarCombustibleNave(nave);
                    GameState.pausa();
                    break;

                case 3:
                    // Volver al menú anterior
                    enMenuInventario = false;
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }
    // Método para recargar energía del exotraje usando sodio
    private void recargarEnergiaExotraje(Jugador jugador) {
        if (floresDeSodio > 0) {
            System.out.print("¿Cuántas flores de sodio desea utilizar para recargar el exotraje? ");
            int cantidad = scanner.nextInt();

            if (cantidad > 0 && cantidad <= floresDeSodio) {
                // Realizar la recarga en la clase Jugador
                jugador.recargarEnergiaProteccion(cantidad);
                retirarFloresDeSodio(cantidad); // Restar las flores del inventario
                System.out.println("Has recargado la energía del exotraje.");
            } else {
                System.out.println("Cantidad no válida.");
            }
        } else {
            System.out.println("No tienes suficiente flores de sodio para recargar el exotraje.");
        }
    }

    // Método para recargar combustible de la nave usando hidrógeno
    private void recargarCombustibleNave(Nave nave) {
        if (cristalesHidrogeno > 0) {
            System.out.print("¿Cuántos cristales de hidrógeno desea utilizar para recargar la nave? ");
            int cantidad = scanner.nextInt();

            if (cantidad > 0 && cantidad <= cristalesHidrogeno) {
                // Realizar la recarga en la clase Nave
                nave.recargarPropulsores(cantidad);
                retirarCristalesHidrogeno(cantidad); // Restar los cristales del inventario
                System.out.println("Has recargado el combustible de la nave.");
            } else {
                System.out.println("Cantidad no válida.");
            }
        } else {
            System.out.println("No tienes suficientes cristales de hidrógeno para recargar la nave.");
        }
    }



    
}
