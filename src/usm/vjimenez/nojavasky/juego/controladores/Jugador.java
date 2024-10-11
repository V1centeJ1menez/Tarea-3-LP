package usm.vjimenez.nojavasky.juego.controladores;

import usm.vjimenez.nojavasky.juego.inventario.Inventario;

//import usm.vjimenez.nojavasky.juego.entidades.planetas.Planeta;

public class Jugador {

    //*************************************************** ATRIBUTOS ***************************************************//
  
    private String nombreJugador;
    private float unidadesEnergiaProteccion = 100; // capcidad inicial de 100.0 unidades de energia
    private float eficienciaEnergiaProteccion = 0; // eficiencia inicial de 0.0%
    private Inventario inventario;


    //*************************************************** CONSTRUCTOR ***************************************************//
  
    public Jugador() {
        this.inventario = new Inventario(0, 0, 0, 0); // Inicializamos el inventario vacío
    }


    //*************************************************** GETTERS ***************************************************//

    public float getEficienciaEnergiaProteccion() {
        return eficienciaEnergiaProteccion;
    }
    public float getUnidadesEnergiaProteccion() {
        return unidadesEnergiaProteccion;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public Inventario getInventario() {
        return inventario;
    }

    //*************************************************** SETTERS ***************************************************//
    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public void setEficienciaEnergiaProteccion(float eficienciaEnergiaProteccion) {
        this.eficienciaEnergiaProteccion = eficienciaEnergiaProteccion;
    }
    public void setUnidadesEnergiaProteccion(float unidadesEnergiaProteccion) {
        this.unidadesEnergiaProteccion = unidadesEnergiaProteccion;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    //*************************************************** METODOS ***************************************************//
    /*public void extraccionDeRecursos(int unidadesRecurso, Planeta planetaActual){
        float unidadesConsumidas =  (float)(0.5 * unidadesRecurso * (planetaActual.getConsumoEnergia()/100) * (1-eficienciaEnergiaProteccion));
    }
    public void recargarEnergiaProteccion(int sodio) {
        // Método para recargar energía de protección (por implementar)
        float unidadesRecargadas = (float) (0.65* sodio*(1+eficienciaEnergiaProteccion));
    }*/


}
