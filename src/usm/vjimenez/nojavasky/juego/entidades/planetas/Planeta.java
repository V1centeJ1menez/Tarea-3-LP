package usm.vjimenez.nojavasky.juego.entidades.planetas;


import usm.vjimenez.nojavasky.juego.controladores.Jugador;
import java.util.Scanner;


public abstract class Planeta {

    //*************************************************** ATRIBUTOS ***************************************************//
    protected int radio;
    protected int cristalesHidrogeno;
    protected int floresDeSodio;
    protected int uranio;
    protected int platino;
    protected float consumoEnergia;
    protected String tipo;
    protected String descripcion;

    // Para la extracción de recursos específicos de cada planeta
    protected int unidadesRecurso;
    protected String nombreRecurso;

    // Scanner global
    protected Scanner scanner = new Scanner(System.in);



    //*************************************************** GETTERS ***************************************************//
    public float getConsumoEnergia() {
        return consumoEnergia;
    }public int getCristalesHidrogeno() {
        return cristalesHidrogeno;
    }public int getFloresDeSodio() {
        return floresDeSodio;
    }public int getRadio() {
        return radio;
    }public String getTipo() {
        return tipo;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public int getPlatino() {
        return platino;
    }
    public int getUranio() {
        return uranio;
    }


    //*************************************************** SETTERS ***************************************************//
    public void setConsumoEnergia(float consumoEnergia) {
        this.consumoEnergia = consumoEnergia;
    }public void setCristalesHidrogeno(int cristalesHidrogeno) {
        this.cristalesHidrogeno = cristalesHidrogeno;
    }public void setFloresDeSodio(int floresDeSodio) {
        this.floresDeSodio = floresDeSodio;
    }public void setRadio(int radio) {
        this.radio = radio;
    }public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setPlatino(int platino) {
        this.platino = platino;
    }
    public void setUranio(int uranio) {
        this.uranio = uranio;
    }


    //*************************************************** METODOS ***************************************************//
    // Método que se llama cuando el jugador visita el planeta
    public boolean visitar(Jugador jugador) {
        
        if (jugador.getUnidadesEnergiaProteccion() == 0) {
            return false;
        }
        return true;
    }

     // Método general para extraer recursos
     public int extraerRecursos(int tipo) {
        String nombreRecurso = "";
        int unidadesRecurso = 0;

        // Determina el tipo de recurso que se va a extraer
        if (tipo == 1) {
            unidadesRecurso = getCristalesHidrogeno();
            nombreRecurso = "Cristales de Hidrógeno";
        } else if (tipo == 2) {
            unidadesRecurso = getFloresDeSodio();
            nombreRecurso = "Flores de Sodio";
        } else if (tipo == 3) {
            unidadesRecurso = getUranio();
            nombreRecurso = "Uranio";
        } else if (tipo == 4) {
            unidadesRecurso = getPlatino();
            nombreRecurso = "Platino";
        } else {
            System.out.println("Tipo de recurso no válido.");
            return -1; // Tipo de recurso no válido
        }

        // Verifica si hay recursos disponibles
        if (unidadesRecurso <= 0) {
            System.out.println("No hay suficientes " + nombreRecurso + " para extraer.");
            return -1;
        }

        // Solicita la cantidad de recursos a extraer
        System.out.println("¿Cuántas unidades de " + nombreRecurso + " deseas extraer? (Máximo " + unidadesRecurso + ")");
        int cantidadSolicitada = scanner.nextInt();

        // Verifica si la cantidad solicitada es válida
        if (cantidadSolicitada > unidadesRecurso || cantidadSolicitada <= 0) {
            System.out.println("Cantidad no válida.");
            return -1;
        }

        // Realiza la extracción, actualizando el recurso en la superclase
        unidadesRecurso -= cantidadSolicitada;  
        if (tipo == 1) {
            setCristalesHidrogeno(unidadesRecurso);
        } else if (tipo == 2) {
            setFloresDeSodio(unidadesRecurso);
        } else if (tipo == 3) {
            setUranio(unidadesRecurso);
        } else if (tipo == 4) {
            setPlatino(unidadesRecurso);
        }

        System.out.println("Has extraído " + cantidadSolicitada + " unidades de " + nombreRecurso + ".");
        return cantidadSolicitada;
    }
    // Método para salir del planeta
    public boolean salir() {
        // Debe ser la logica, consultar combustible
        return true;
    }

    
}

