public class Main {
    public static void main(String[] args) {
        // Instrumento instrumento = new Instrumento(); // No es posible instanciar una clase abstracta
        Piano piano = new Piano();  // Instancia de Piano
        Piano piano2 = new Piano(81); // Constructor con parametros de Piano

        System.out.println(piano.getCantidadTeclas());
        System.out.println(piano2.getCantidadTeclas());

        Guitarra guitarra = new Guitarra(); // Instancia de Guitarra

        // Guitarra guitarra2 = new Piano(); // No se puede tener una referencia a Piano en una Guitarra

        // Puedo tenener referencias a subclases donde esperaba una superclase
        guitarra.afinar();
        Instrumento instrumentoGenerico = new Piano();
        Instrumento instrumentoGenerico2 = new Guitarra();

        instrumentoGenerico.tocar();
        instrumentoGenerico2.tocar();

        System.out.println(instrumentoGenerico.getClass().getName());
        System.out.println(instrumentoGenerico2.getClass().getName());

    }
}

