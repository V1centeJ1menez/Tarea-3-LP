package usm.vjimenez.nojavasky.hud.estados;

import usm.vjimenez.nojavasky.hud.GameStateManager;
import usm.vjimenez.nojavasky.juego.controladores.Jugador;
import usm.vjimenez.nojavasky.juego.controladores.Nave;
import usm.vjimenez.nojavasky.juego.entidades.planetas.Planeta;
import usm.vjimenez.nojavasky.juego.entidades.planetas.tieneAsentamientos;
import usm.vjimenez.nojavasky.juego.controladores.MapaGalactico;
import usm.vjimenez.nojavasky.juego.entidades.planetas.tipos.*;
import usm.vjimenez.nojavasky.juego.inventario.*;

public class EstadoExtraccionRecursos extends GameState {

    private Planeta planetaActual;
    
    public EstadoExtraccionRecursos(GameStateManager gsm, Jugador jugador, Nave nave, MapaGalactico mapa) {
        super(gsm, jugador, nave, mapa);
        this.planetaActual = mapa.getPlanetaActual();
    }

    @Override
    public void mostrarOpciones() {
        boolean enMenuExtraccion = true;
        while (enMenuExtraccion) {
            limpiarPantalla();
            mostrarDescenso();
            mostrarInterface();
            System.out.println("=== Extracción de Recursos ===");
            System.out.println("Recursos disponibles en el planeta:");
            System.out.println("[0] Volver");
            System.out.println("[1] Cristales de Hidrógeno: " + planetaActual.getCristalesHidrogeno() + " unidades");
            System.out.println("[2] Flores de Sodio: " + planetaActual.getFloresDeSodio() + " unidades");
           
    
            if (planetaActual instanceof Radioactivo) {
                Radioactivo radioactivo = (Radioactivo) planetaActual;
                System.out.println("[3] Uranio: " + radioactivo.getUranio() + " unidades");
            }
    
            if (planetaActual instanceof Volcanico) {
                Volcanico volcanico = (Volcanico) planetaActual;
                System.out.println("[4] Platino: " + volcanico.getPlatino() + " unidades");
            }
            
            int opcion = scanner.nextInt();
            int cantidadExtraida;
            float consumoEnergia = planetaActual.getConsumoEnergia();
    
            Inventario inventario = jugador.getInventario();  // Obtener el inventario del jugador
    
            switch (opcion) {
                
                case 1:
                    // Extraer Cristales de Hidrógeno
                    limpiarPantalla();
                    mostrarDescenso();
                    mostrarInterface();

                    // Extracción
                    cantidadExtraida = planetaActual.extraerRecursos(1);
                    if (cantidadExtraida == -1) {
                        System.out.println("Extracción fallida.");
                    }else{

                        // Gasto de energia del traje
                        jugador.consumirEnergia(cantidadExtraida, consumoEnergia);
                        // Agregar al inventario lo consumido
                        inventario.agregarCristalesHidrogeno(cantidadExtraida);  // Agregar al inventario
                        System.out.println("Has extraído " + cantidadExtraida + " Cristales de Hidrógeno.");
                    }
                    pausa();
                    break;
    
                case 2:
                    // Extraer Flores de Sodio
                    limpiarPantalla();
                    mostrarDescenso();
                    mostrarInterface();
                    cantidadExtraida = planetaActual.extraerRecursos(2);
                    if (cantidadExtraida == -1) {
                        System.out.println("Extracción fallida.");
                    }else{
                        jugador.consumirEnergia(cantidadExtraida, consumoEnergia);
                        inventario.agregarFloresDeSodio(cantidadExtraida);  // Agregar al inventario
                        System.out.println("Has extraído " + cantidadExtraida + " Flores de Sodio.");
                        
                    }
                    pausa();
                    break;
    
                case 3:
                    // Extraer Uranio (solo si el planeta es Radioactivo)
                    limpiarPantalla();
                    mostrarDescenso();
                    mostrarInterface();
                    if (planetaActual instanceof Radioactivo) {
                        cantidadExtraida = planetaActual.extraerRecursos(3);
                        if (cantidadExtraida == -1) {
                            System.out.println("Extracción fallida.");
                        } else{
                            jugador.consumirEnergia(cantidadExtraida, consumoEnergia);
                            inventario.agregarUranio(cantidadExtraida);  // Agregar al inventario
                            System.out.println("Has extraído " + cantidadExtraida + " unidades de Uranio.");
                        }
                    } else {
                        System.out.println("Opción no válida.");
                    }
                    pausa();
                    break;
    
                case 4:
                    // Extraer Platino (solo si el planeta es Volcánico)
                    limpiarPantalla();
                    mostrarDescenso();
                    mostrarInterface();
                    if (planetaActual instanceof Volcanico) {
                        cantidadExtraida = planetaActual.extraerRecursos(4);
                        if (cantidadExtraida == -1) {
                            System.out.println("Extracción fallida.");
                        }else{
    
                            jugador.consumirEnergia(cantidadExtraida, consumoEnergia);
                            inventario.agregarPlatino(cantidadExtraida);  // Agregar al inventario
                            System.out.println("Has extraído " + cantidadExtraida + " unidades de Platino.");
                        }
                    } else {
                        System.out.println("Opción no válida.");
                    }
                    pausa();                    
                    break;
    
                case 0:
                    limpiarPantalla();
                    mostrarDescenso();
                    mostrarInterface();
                    // Volver al estado anterior
                    cambiarEstado(new EstadoVisitandoPlaneta(gsm, jugador, nave, mapa, false));
                    enMenuExtraccion = false;
                    break;
    
                default:
                    System.out.println("Opción no válida.");
                    pausa();
                    mostrarOpciones();
                    break;
            }
        }
    }

    public static void mostrarDescenso() {
        String arte = 
            "*                                            ✧₊                                        ₊                 \n" +
            "                    ooooo \n" +
            "           /█████\\oo    o                                   *                                       ₊                 \n" +
            "          /███████\\  ooo             ██                                           *            \n" +
            "          ████████ooo\n" +
            "        oo██████oo█\n" +
            "       o  \\███oo██/         *                   ₊                       █                 *                    ₊\n" +
            "      o    ooo███/\n" +
            "      ooooo                  \n" +
            "                                    *          ₊                                 *                   ✧₊  \n" +
            "                                                         *                                            \n" +
            "  ₊  \n" +
            "                 *                        ₊                           *                   ₊     \n" +
            "\n" +
            "                                                                                                      /\\\n" +
            "        ██                     *                                                                 /\\  /  \\     ₊ \n" +
            "                                                                                                /  \\/    \\\n" +
            "                    /\\                                                           ✧₊            /    \\     \\\n" +
            "                   /  \\                          ₊                    /\\                      /      \\     \\\n" +
            "__________________/    \\___________________________________________/\\/  \\____________________/        \\_____\\______\n";

        System.out.println(arte); // Muestra el arte en la consola
    }

    private void mostrarInterface() {
    Planeta planetaActual = mapa.getPlanetaActual();
    System.out.println("==========================================================================================================================");
    System.out.println("|                                             Información del Planeta Actual                                             |");
    System.out.println("==========================================================================================================================");
    System.out.println("|------------------------------------------------------------------------------------------------------------------------|");

    if(planetaActual instanceof CentroGalactico){ System.out.println("Estas en Centro Galactico, osea ganasteee.. Aqui cerrar juego.");} 
    else {

        System.out.println("Tipo de planeta: " + planetaActual.getTipo()); // Suponiendo que tienes un método para obtener el tipo de planeta
        System.out.println("Posición del planeta: " + mapa.getPosicionActual()); // Método que obtiene la posición
        System.out.println("Radio del planeta: " + planetaActual.getRadio() + " metros"); // Suponiendo que tienes un método para obtener el radio
        
        // Mostrar los recursos
        System.out.println("Recursos disponibles:");
        System.out.println("Cristales de Hidrógeno: " + planetaActual.getCristalesHidrogeno() + " unidades");
        System.out.println("Flores de Sodio: " + planetaActual.getFloresDeSodio() + " unidades");

        if (planetaActual instanceof Radioactivo) {
            Radioactivo radioactivo = (Radioactivo) planetaActual;
            System.out.println("Uranio: " + radioactivo.getUranio() + " unidades");
            System.out.println("Radiación: " + radioactivo.getRadiacion() + " Rad");
        } else if (planetaActual instanceof Volcanico) {
            Volcanico volcanico = (Volcanico) planetaActual;
            System.out.println("Platino: " + volcanico.getPlatino() + " unidades");
            System.out.println("Temperatura: " + volcanico.getTemperatura()+ " ºC");
        } else if (planetaActual instanceof Oceanico) {
            Oceanico oceanico = (Oceanico) planetaActual;
            System.out.println("Profundidad: " + oceanico.getProfundidad()+ " metros");
        } else if (planetaActual instanceof Helado) {
            Helado helado = (Helado) planetaActual;
            System.out.println("Temperatura: " + helado.getTemperatura() + " ºC");
        }   

        if (planetaActual instanceof tieneAsentamientos) {
            System.out.println("Este planeta tiene asentamientos.");
        } else {
            System.out.println("Este planeta no tiene asentamientos.");
        }
        
        // Información del jugador
        System.out.println("|------------------------------------------------------------------------------------------------------------------------|");
        System.out.println("Energía del traje: " + jugador.getUnidadesEnergiaProteccion() + " unidades de energia de proteccion");
        System.out.println("Eficiencia del traje: " + jugador.getEficienciaEnergiaProteccion() + " %");
        System.out.println("|------------------------------------------------------------------------------------------------------------------------|");
        System.out.println("Combustible: " + nave.getUnidadesCombustible() + " unidades de combustible");
        System.out.println("Eficiencia de la nave: " + nave.getEficienciaPropulsor()+ " %");
        System.out.println("|------------------------------------------------------------------------------------------------------------------------|");
        System.out.println("==========================================================================================================================");
    
        }
    }

}
