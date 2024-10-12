package usm.vjimenez.nojavasky.juego.entidades.planetas.tipos;

import usm.vjimenez.nojavasky.juego.entidades.planetas.Planeta;
import usm.vjimenez.nojavasky.juego.controladores.Jugador;

public class Radioactivo extends Planeta {

    // Atributo
    private int radiacion;
    private int uranio;
    // Constructor
    public Radioactivo(int radio, int cristalesHidrogeno, int floresDeSodio, int radiacion, int uranio, float consumoEnergia) {
        this.radio = radio;
        this.cristalesHidrogeno = cristalesHidrogeno;
        this.floresDeSodio = floresDeSodio;
        this.radiacion = radiacion;
        this.uranio = uranio;
        this.consumoEnergia = consumoEnergia;
        this.tipo = "Radioactivo";
        this.descripcion =  "Estos planetas están llenos de vida muy exótica. Pero la atmósfera es muy densa en "
        + "componentes radiactivos incompatibles con tu sistema, por lo que el traje consume "
        + "mucha energía para evitar los efectos letales. Esta radiación proviene de los grandes "
        + "yacimientos ricos en Uranio, un elemento muy cotizado por los asentamientos de otros "
        + "planetas, se puede intercambiar este elemento por mejoras en los asentamientos.";
    }

    public int getUranio() {
        return uranio;
    }
    public int getRadiacion() {
        return radiacion;
    }

    public void setUranio(int uranio) {
        this.uranio = uranio;
    }

    public void setRadiacion(int radiacion) {
        this.radiacion = radiacion;
    }

    // Métodos de la clase abstracta Planeta
    @Override
    public boolean visitar(Jugador jugador) {
        // Implementación por definir
        return false;
    }

    @Override
    public int extraerRecursos(int tipo) {
        if (tipo == 3) { // Platino
            System.out.println("¡Extrayendo Uranio del planeta Radioactivo!");;
            return super.extraerRecursos(tipo); // Delegamos la lógica de extracción
        }
        return super.extraerRecursos(tipo); // Si no es un recurso válido, no se extrae nada
    }

    @Override
    public boolean salir() {
        // Implementación por definir
        return true;
    }

}
