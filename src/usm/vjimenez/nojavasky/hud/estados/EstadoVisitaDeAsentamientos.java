package usm.vjimenez.nojavasky.hud.estados;

import usm.vjimenez.nojavasky.hud.GameStateManager;
import usm.vjimenez.nojavasky.juego.controladores.Jugador;
import usm.vjimenez.nojavasky.juego.controladores.Nave;
import usm.vjimenez.nojavasky.juego.controladores.MapaGalactico;

public class EstadoVisitaDeAsentamientos extends GameState {

    public EstadoVisitaDeAsentamientos(GameStateManager gsm, Jugador jugador, Nave nave, MapaGalactico mapa) {
        super(gsm, jugador, nave, mapa); // Llama al constructor de GameState
    }
    @Override
    public void mostrarOpciones() {
        // TODO Auto-generated method stub
        
    }
}
