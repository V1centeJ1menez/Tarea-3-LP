public class Guitarra extends Instrumento {
    private int cantidadCuerdas;
    private int tamano;

    public Guitarra() {
        // Invoco constructor de Super -> Instrumento
        super();
        this.cantidadCuerdas = 0;
        this.tamano = 0;
    }

    // Polimorfismo de tocar de la superclass
    @Override
    public void tocar() {
        System.out.println("Tocar Guitarra");
    }

    public void afinar() {
        System.out.println("Afinando " + this.cantidadCuerdas + " cuerdas");
    }

    public void entregarTamano(){
        System.out.println("El tamano es: " + this.tamano);
    }

    // Aplicando Sobrecarga
    public void tocar(int cuerda) {
        System.out.println("Tocar cuerda " + cuerda);
    }

    public void tocar(int cuerda_1, int cuerda_2) {
        System.out.println("Tocar cuerda " + cuerda_1 + " y " + cuerda_2);
    }
}
