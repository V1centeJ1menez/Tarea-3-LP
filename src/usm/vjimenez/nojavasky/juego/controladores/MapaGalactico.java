package usm.vjimenez.nojavasky.juego.controladores;

import java.util.List;
import java.util.ArrayList;
import usm.vjimenez.nojavasky.juego.entidades.planetas.*;
import usm.vjimenez.nojavasky.juego.entidades.planetas.tipos.*;
import usm.vjimenez.nojavasky.utilidad.*;

public class MapaGalactico {


    //*************************************************** ATRIBUTOS ***************************************************//
  
    private List<Planeta> planetas = new ArrayList<>();
    private int posicionActual; // Posición del jugador en el mapa galáctico
    private boolean centroGalacticoGenerado = false;

    public MapaGalactico(){
        this.posicionActual = 0;
        planetas.add(null);
    }

    //*************************************************** GETTERS ***************************************************//
    public List<Planeta> getPlanetas() {
        return planetas;
    }

    public Planeta getPlanetaActual(){

        return planetas.get(posicionActual);
    }
    
    public int getPosicionActual() {
        return posicionActual;
    }

    //*************************************************** SETTERS ***************************************************//
    // Método setter para cambiar la posición actual a un planeta ya descubierto
    public void setPosicionActual(int nuevaPosicion) {
        if (nuevaPosicion >= 0 && nuevaPosicion < planetas.size()) {
            posicionActual = nuevaPosicion;
            System.out.println("Te has trasladado al planeta en la posición: " + nuevaPosicion);
        } else {
            System.out.println("Posición inválida. No se puede trasladar a una posición no explorada.");
        }
    }




    //*************************************************** METODOS ***************************************************//

    public void mostrarMapa() {
        System.out.println("\n--- Mapa Galáctico ---");
    
        // Recorrer la lista de planetas y mostrar el estado de cada uno
        for (int i = 0; i < planetas.size(); i++) {
            Planeta planeta = planetas.get(i);
            
            if (planeta == null) {
                // Mostrar como "No visitado" si el planeta es null
                System.out.println("Planeta " + i + ": No visitado (❓)");
            } else {
                // Mostrar el tipo de planeta y su símbolo
                String simbolo = obtenerSimboloPlaneta(planeta);
                System.out.println("Planeta " + i + ": " + planeta.getTipo() + " " + simbolo);
            }
        }
    
        System.out.println("------------------------");
    }
    
    // Método auxiliar para obtener un símbolo según el tipo de planeta
    private String obtenerSimboloPlaneta(Planeta planeta) {
        if (planeta instanceof Helado) {
            return "(❄️)"; // Símbolo de planeta helado
        } else if (planeta instanceof Oceanico) {
            return "(🌊)"; // Símbolo de planeta oceánico
        } else if (planeta instanceof Volcanico) {
            return "(🌋)"; // Símbolo de planeta volcánico
        } else if (planeta instanceof Radioactivo) {
            return "(☢️)"; // Símbolo de planeta radioactivo
        } else if (planeta instanceof CentroGalactico) {
            return "(🌟)"; // Símbolo de centro galáctico
        } else {
            return "(🌍)"; // Símbolo genérico para otros planetas
        }
    }
    
    


    // Método para generar un nuevo planeta (solo si es necesario)
    public Planeta generadorPlaneta() {
        int randomNum = RandomNumberGenerator.rand(1, 100); // Genera un número entre 1 y 100

        Planeta nuevoPlaneta = null;

        if (randomNum <= 30) {
            nuevoPlaneta = crearHelado();
        } else if (randomNum <= 60) {
            nuevoPlaneta = crearOceanico();
        } else if (randomNum <= 80) {
            nuevoPlaneta = crearRadioactivo();
        } else if (randomNum <= 99) {
            nuevoPlaneta = crearVolcanico();
        } else if (!centroGalacticoGenerado) {
            nuevoPlaneta = crearCentroGalactico();
            centroGalacticoGenerado = true; // Asegurarse de que solo se genere una vez
        }

        // Si el nuevo planeta es válido, agregarlo a la lista
        if (nuevoPlaneta != null) {
            planetas.set(this.posicionActual,nuevoPlaneta);
        }

        return nuevoPlaneta;
    }

    // Métodos de creación de planetas (sin cambios)

    private Helado crearHelado() {
        int radio = RandomNumberGenerator.rand(1000, 1000000); // rand(10^3, 10^6)
        int temperatura = RandomNumberGenerator.rand(-120, -30); // rand(-120, -30)
        int cristalesHidrogeno = (int) (0.65 * (4 * Math.PI * Math.pow(radio, 2)));
        int floresDeSodio = (int) (0.35 * (4 * Math.PI * Math.pow(radio, 2)));
        float consumoEnergia = (float) (0.15 * Math.abs(temperatura));

        return new Helado(radio, cristalesHidrogeno, floresDeSodio, temperatura, consumoEnergia);
    }

    private Oceanico crearOceanico() {
        int radio = RandomNumberGenerator.rand(10000, 1000000); // rand(10^4, 10^6)
        int profundidad = RandomNumberGenerator.rand(30, 1000); // rand(30, 103)
        int cristalesHidrogeno = (int) (0.2 * (4 * Math.PI * Math.pow(radio, 2)));
        int floresDeSodio = (int) (0.65 * (4 * Math.PI * Math.pow(radio, 2)));
        float consumoEnergia = (float) (0.002 * Math.pow(profundidad, 2));

        return new Oceanico(radio, cristalesHidrogeno, floresDeSodio, profundidad, consumoEnergia);
    }

    private Radioactivo crearRadioactivo() {
        int radio = RandomNumberGenerator.rand(10000, 100000); // rand(10^4, 10^5)
        int radiacion = RandomNumberGenerator.rand(10, 50); // rand(10, 50)
        int cristalesHidrogeno = (int) (0.2 * (4 * Math.PI * Math.pow(radio, 2)));
        int floresDeSodio = (int) (0.2 * (4 * Math.PI * Math.pow(radio, 2)));
        int uranio = (int) (0.25 * (4 * Math.PI * Math.pow(radio, 2)) * radiacion);
        float consumoEnergia = (float) (0.3 * radiacion);

        return new Radioactivo(radio, cristalesHidrogeno, floresDeSodio, uranio, radiacion, consumoEnergia);
    }

    private Volcanico crearVolcanico() {
        int radio = RandomNumberGenerator.rand(1000, 100000); // rand(10^3, 10^5)
        int temperatura = RandomNumberGenerator.rand(120, 256); // rand(120, 256)
        int cristalesHidrogeno = (int) (0.3 * (4 * Math.PI * Math.pow(radio, 2)));
        int floresDeSodio = 0;
        int platino = (int) ((0.25 * (4 * Math.PI * Math.pow(radio, 2))) - (20.5 * Math.pow(temperatura, 2)));
        float consumoEnergia = (float) (0.08 * temperatura);

        return new Volcanico(radio, cristalesHidrogeno, floresDeSodio, platino, temperatura, consumoEnergia);
    }

    private CentroGalactico crearCentroGalactico() {
        return new CentroGalactico(); // Crear un CentroGalactico sin parámetros
    }

    //***********************************************************************************************************//
}
