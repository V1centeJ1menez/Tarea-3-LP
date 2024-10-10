public class Piano extends Instrumento implements EsMagico {
    private int cantidadTeclas;

    public Piano() {
        this.cantidadTeclas = 0;
    }

    public Piano(int cantidad) {
        this.cantidadTeclas = cantidad;
    }

    // Se invoca el método de tocar() de esta clase, y no de la superclase.
    @Override
    public void tocar() {
        System.out.println("Tocar Piano");
    }

    // Requiero definir el comportamiento de la interfaz implementada
    public void hacerMagia() {
        System.out.println("MAGIC!!");
    }

    public void sostener() {
        super.tocar();
    }

    public int getCantidadTeclas() {
        return cantidadTeclas;
    }

    public void setCantidadTeclas(int cantidadTeclas) {
        this.cantidadTeclas = cantidadTeclas;
    }

    // Si heredo los getters y setters de la superclase, tengo que redefinirlos
    // aquí?
}
