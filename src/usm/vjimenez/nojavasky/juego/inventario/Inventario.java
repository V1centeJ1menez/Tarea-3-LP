package usm.vjimenez.nojavasky.juego.inventario;

public class Inventario {

    // Atributos
    private int cristalesHidrogeno;
    private int floresDeSodio;
    private int uranio;
    private int platino;

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
    public void mostrarInventario() {
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
    }
}
