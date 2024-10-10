package usm.vjimenez.nojavasky;

import usm.vjimenez.nojavasky.hud.GameStateManager;

public class NoJavaSky {
    public static void main(String[] args) {
        GameStateManager gameStateManager = new GameStateManager(); // Inicializa el GameStateManager
        gameStateManager.actualizar(); // Muestra el menú principal y permite al usuario interactuar
    }
}
