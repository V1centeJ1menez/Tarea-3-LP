public abstract class Instrumento {
    // Atributos
    private int Precio;
    private String Estado;
    private String Tipo;

    // Constructor Por Defecto
    public Instrumento() {
        this.Precio = 0;
        this.Estado = "None";
        this.Tipo = "None";
    }

    // Constructor Sobrecargado
    public Instrumento(int precio, String estado, String tipo) {
        this.Precio = precio;
        this.Estado = estado;
        this.Tipo = tipo;
    }

    // Metodos de la clase
    public void tocar() {
        System.out.println("Tocar Intrumento");
    }

    // Getters y Setters
    public int getPrecio() {
        return Precio;
    }

    public String getEstado() {
        return Estado;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setPrecio(int precio) {
        Precio = precio;
    }

    public void setEstado(String estado) {
        this.Estado = estado;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }
}