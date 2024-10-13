package usm.vjimenez.nojavasky.juego.controladores;

//import usm.vjimenez.nojavasky.juego.entidades.planetas.Planeta;

import usm.vjimenez.nojavasky.utilidad.RandomNumberGenerator;

public class Nave {

    //*************************************************** ATRIBUTOS ***************************************************//
    private float unidadesCombustible = 100; // Capacidad inicial de 100.0 unidades de energía
    private float capcidadTotalCombustible = 100;
    private float eficienciaPropulsor = 0; // Eficiencia inicial de 0.0%
    

    //*************************************************** GETTERS ***************************************************//
    public float getUnidadesCombustible(){
        return unidadesCombustible;
    }

    public float getEficienciaPropulsor(){
        return eficienciaPropulsor;
    }

    public float getCapcidadTotalCombustible() {
        return capcidadTotalCombustible;
    }
    //*************************************************** SETTERS ***************************************************//
    public void setEficienciaPropulsor(float eficienciaPropulsor) {
        this.eficienciaPropulsor = eficienciaPropulsor;
    }

    public void setUnidadesCombustible(float unidadesCombustible) {
        this.unidadesCombustible = unidadesCombustible;
    }
    public void setCapcidadTotalCombustible(float capcidadTotalCombustible) {
        this.capcidadTotalCombustible = capcidadTotalCombustible;
    }

    //*************************************************** METODOS ***************************************************//
    
    public boolean viajarPlaneta(MapaGalactico MG, int direccion, int tamanoSalto) {
        int posicionActual = MG.getPosicionActual();
        int nuevaPosicion = posicionActual + direccion * tamanoSalto;
    
        // Verificar si la nueva posición es válida (no debe ir hacia atrás si estamos en el origen)
        if (nuevaPosicion < 0 || (posicionActual == 0 && direccion == -1)) {
            System.out.println("No puedes saltar a esa posición.");
            return false;
        }
    
        // Calcular el consumo de combustible basado en el tamaño del salto
        float unidadesConsumidas = (float)(0.75 * Math.pow(tamanoSalto, 2) * (1 - eficienciaPropulsor));
    
        // Verificar si hay suficiente combustible para hacer el salto
        if (unidadesCombustible >= unidadesConsumidas) {
            // Descontar el combustible consumido
            this.unidadesCombustible -= unidadesConsumidas;
    
            if (unidadesCombustible < 0) {
                unidadesCombustible = 0;
            }
    
            // Si el combustible llega a cero, mover a posición segura
            if (unidadesCombustible == 0) {
                System.out.println("Te has quedado sin combustible. Moviéndote a una posición segura...");
                moverAPosicionSegura(MG);
                return false;
            }
    
            // Expandir la lista si es necesario, llenando con "no visitados" (null)
            while (nuevaPosicion >= MG.getPlanetas().size()) {
                MG.getPlanetas().add(null);  // Añadir un espacio "no visitado"
            }
    
            // Actualizar la posición actual del jugador
            MG.setPosicionActual(nuevaPosicion);
            System.out.println("Has saltado a la posición " + nuevaPosicion);
    
            // Generar el planeta en la nueva posición si es necesario (si es null, se genera al visitarlo)
            if (MG.getPlanetas().get(nuevaPosicion) == null) {
                MG.generadorPlaneta(); // Generar un nuevo planeta
            }
    
            return true; // Salto exitoso
        } else {
            System.out.println("No tienes suficiente combustible para este salto.");
            return false; // Salto fallido
        }
    }
    
    // Método que mueve la nave a una posición segura
    private void moverAPosicionSegura(MapaGalactico MG) {
        // Mover la nave al origen (posición 0) cuando se quede sin combustible
        MG.setPosicionActual(0);
        System.out.println("Has sido movido al origen (posición 0) para recargar combustible.");
    }
    

    public int analizarSaltos(float tamañoSalto) {
        float combustibleActual = this.unidadesCombustible; // Combustible disponible
        float eficiencia = this.eficienciaPropulsor; // Eficiencia del propulsor
        int saltos = 0;
    
        // Calcular el consumo de combustible para un salto según el tamaño del salto ingresado
        float consumoDeUnSalto = (float) (0.75 * Math.pow(tamañoSalto, 2) * (1 - eficiencia));
    
        // Mientras tengas combustible suficiente para realizar saltos
        while (combustibleActual >= consumoDeUnSalto) {
            combustibleActual -= consumoDeUnSalto; // Restar el combustible necesario para un salto
            saltos++; // Incrementar el número de saltos posibles
        }
    
        return saltos; // Devolver la cantidad máxima de saltos que puede realizar
    }
    

    public void recargarPropulsores(int hidrogeno) {
        // Calcular las unidades de combustible recargadas basadas en el hidrógeno y la eficiencia del propulsor
        float unidadesRecargadas = (float)(0.6 * hidrogeno * (1 + eficienciaPropulsor));
        
        // Aumentar las unidades de combustible en la nave
        this.unidadesCombustible += unidadesRecargadas;

        // Asegurarse de que la energía no exceda la capacidad total
        if (unidadesCombustible > capcidadTotalCombustible) {
            unidadesCombustible = capcidadTotalCombustible;
        }
    
        System.out.println("Has recargado " + unidadesRecargadas + " unidades de combustible.");
        System.out.println("Combustible actual en la nave: " + unidadesCombustible + " unidades.");
    }

    // Método para mejorar la capacidad total de combustible de la nave
    public void mejorarCapacidad() {
        // Aumenta la capacidad total de combustible en un 15% (por ejemplo)
        this.capcidadTotalCombustible *= 1.15;
        System.out.println("Capacidad total de combustible de la nave mejorada a: " + this.capcidadTotalCombustible);
    }

    
    public void mejorarEficiencia() {
        float a = (float) 0.5;
        float b = (float) 10.0;

        float incremento = RandomNumberGenerator.randF(a, b);
    
        // Aumenta la eficiencia energética
        this.eficienciaPropulsor+= incremento;
    
        // Limitar la eficiencia máxima a 100%
        if (this.eficienciaPropulsor > 100) {
            this.eficienciaPropulsor = 100;  // Limitar a 100%
        }

        // Determinar el mensaje según el incremento
        if (incremento <= 5) {
            System.out.println("Eficiencia del propulsor mejorada a: " + (this.eficienciaPropulsor * 100) + "% - ¡Lo mejor que se pudo hacer!");
        } else if (incremento > 5 && incremento <= 7) {
            System.out.println("Eficiencia del propulsor mejorada a: " + (this.eficienciaPropulsor * 100) + "% - ¡Nada mal!");
        } else if (incremento > 7) {
            System.out.println("Eficiencia del propulsor mejorada a: " + (this.eficienciaPropulsor * 100) + "% - ¡Éxitoso!");
        }
    }
    
}
