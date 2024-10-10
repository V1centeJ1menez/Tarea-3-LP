package usm.vjimenez.nojavasky.hud.estados;

import usm.vjimenez.nojavasky.hud.GameStateManager;
import usm.vjimenez.nojavasky.juego.controladores.MapaGalactico;
import usm.vjimenez.nojavasky.juego.controladores.Nave;
import usm.vjimenez.nojavasky.juego.controladores.Jugador;

public abstract class GameState {
    protected GameStateManager gsm;
    protected Jugador jugador;
    protected Nave nave;
    protected MapaGalactico mapa;

    public GameState(GameStateManager gsm, Jugador jugador, Nave nave, MapaGalactico mapa) {
        this.gsm = gsm;
        this.jugador = jugador;
        this.nave = nave;
        this.mapa = mapa;
    }

    protected void cambiarEstado(GameState nuevoEstado) {
        gsm.cambiarEstado(nuevoEstado);
    }


    public abstract void mostrarOpciones(); 
}
