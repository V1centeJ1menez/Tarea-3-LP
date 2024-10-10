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

    public int getCristalesHidrogeno() {
        return cristalesHidrogeno;
    }

    public int getFloresDeSodio() {
        return floresDeSodio;
    }
    public int getPlatino() {
        return platino;
    }
    public int getUranio() {
        return uranio;
    }
    public void setCristalesHidrogeno(int cristalesHidrogeno) {
        this.cristalesHidrogeno = cristalesHidrogeno;
    }
    public void setFloresDeSodio(int floresDeSodio) {
        this.floresDeSodio = floresDeSodio;
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

    // Métodos para obtener la cantidad de recursos
    public int obtenerCristalesHidrogeno() {
        return this.cristalesHidrogeno;
    }

    public int obtenerFloresDeSodio() {
        return this.floresDeSodio;
    }

    // Método para mostrar el estado del inventario
    public void mostrarInventario() {
        System.out.println("Cristales de Hidrógeno: " + cristalesHidrogeno);
        System.out.println("Flores de Sodio: " + floresDeSodio);
    }
}
