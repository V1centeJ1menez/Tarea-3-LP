package usm.vjimenez.nojavasky.juego.controladores;

import usm.vjimenez.nojavasky.juego.inventario.Inventario;

//import usm.vjimenez.nojavasky.juego.entidades.planetas.Planeta;

public class Jugador {

    //*************************************************** ATRIBUTOS ***************************************************//
  
    private String nombreJugador;
    private float capcidadTotalEnergiaProteccion = 100;
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
    public float getCapcidadTotalEnergiaProteccion() {
        return capcidadTotalEnergiaProteccion;
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
    public void setCapcidadTotalEnergiaProteccion(float capcidadTotalEnergiaProteccion) {
        this.capcidadTotalEnergiaProteccion = capcidadTotalEnergiaProteccion;
    }

    //*************************************************** METODOS ***************************************************//
  
    public void consumirEnergia(float unidadesRecurso, float consumoEnergia) {
        // Calcular las unidades de energía consumidas basadas en la fórmula dada
        float eficiencia = getEficienciaEnergiaProteccion(); // Obtener la eficiencia actual del jugador
        float energiaConsumida = 0.5f * unidadesRecurso * (consumoEnergia / 100) * (1 - eficiencia);
    
        // Descontar las unidades de energía consumidas del total de energía de protección
        unidadesEnergiaProteccion -= energiaConsumida;
    
        // Asegurarse de que las unidades de energía no bajen de cero
        if (unidadesEnergiaProteccion < 0) {
            unidadesEnergiaProteccion = 0;
        }
    
        // Mostrar la energía consumida y la energía restante
        System.out.println("Energía consumida: " + energiaConsumida + " unidades.");
        System.out.println("Energía restante en el exotraje: " + unidadesEnergiaProteccion + " unidades.");
    }
    
    
    public void recargarEnergiaProteccion(float sodio) {
        // Calcular las unidades de energía recargadas basadas en las flores de sodio y la eficiencia de la protección
        float unidadesRecargadas = (float) (0.65 * sodio * (1 + eficienciaEnergiaProteccion));
        
        // Aumentar las unidades de energía en el exotraje
        unidadesEnergiaProteccion += unidadesRecargadas;
    
        // Asegurarse de que la energía no exceda la capacidad total
        if (unidadesEnergiaProteccion > capcidadTotalEnergiaProteccion) {
            unidadesEnergiaProteccion = capcidadTotalEnergiaProteccion;
        }
    
        System.out.println("Has recargado " + unidadesRecargadas + " unidades de energía.");
        System.out.println("Energía actual del exotraje: " + unidadesEnergiaProteccion + " unidades.");
    }
    


}
