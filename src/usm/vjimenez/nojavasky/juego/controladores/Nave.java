package usm.vjimenez.nojavasky.juego.controladores;

//import usm.vjimenez.nojavasky.juego.entidades.planetas.Planeta;

public class Nave {

    //*************************************************** ATRIBUTOS ***************************************************//
    private float unidadesCombustible = 100; // Capacidad inicial de 100.0 unidades de energía
    private float eficienciaPropulsor = 0; // Eficiencia inicial de 0.0%
    

    //*************************************************** GETTERS ***************************************************//
    public float getUnidadesCombustible(){
        return unidadesCombustible;
    }

    public float getEficienciaPropulsor(){
        return eficienciaPropulsor;
    }

    //*************************************************** SETTERS ***************************************************//
    public void setEficienciaPropulsor(float eficienciaPropulsor) {
        this.eficienciaPropulsor = eficienciaPropulsor;
    }

    public void setUnidadesCombustible(float unidadesCombustible) {
        this.unidadesCombustible = unidadesCombustible;
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
        // Método para recargar los propulsores (por implementar)
        float unidadesRecargadas = (float)(0.6 * hidrogeno * (1 + eficienciaPropulsor));
        this.unidadesCombustible += unidadesRecargadas;
    }
}
