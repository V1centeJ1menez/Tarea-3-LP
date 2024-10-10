package usm.vjimenez.nojavasky.juego.controladores;

import usm.vjimenez.nojavasky.juego.entidades.planetas.Planeta;

public class Jugador {

    // Atributos
    private float unidadesEnergiaProteccion = 100; // capcidad inicial de 100.0 unidades de energia
    private float eficienciaEnergiaProteccion = 0; // eficiencia inicial de 0.0%

    // GETTERS - SETTERS

    public float getEficienciaEnergiaProteccion() {
        return eficienciaEnergiaProteccion;
    }
    public float getUnidadesEnergiaProteccion() {
        return unidadesEnergiaProteccion;
    }

    public void setEficienciaEnergiaProteccion(float eficienciaEnergiaProteccion) {
        this.eficienciaEnergiaProteccion = eficienciaEnergiaProteccion;
    }
    public void setUnidadesEnergiaProteccion(float unidadesEnergiaProteccion) {
        this.unidadesEnergiaProteccion = unidadesEnergiaProteccion;
    }


    // METODOS
    public void extraccionDeRecursos(int unidadesRecurso, Planeta planetaActual){
        float unidadesConsumidas =  (float)(0.5 * unidadesRecurso * (planetaActual.getConsumoEnergia()/100) * (1-eficienciaEnergiaProteccion));
    }
    public void recargarEnergiaProteccion(int sodio) {
        // Método para recargar energía de protección (por implementar)
        float unidadesRecargadas = (float) (0.65* sodio*(1+eficienciaEnergiaProteccion));
    }


}
