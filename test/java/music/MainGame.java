package test.java.music;

import java.util.Scanner;

public class MainGame {
    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();
        player.play("./test/java/music/spaceship.wav");

        // Aquí va la lógica del juego
        Scanner scanner = new Scanner(System.in);
        
        try {
            while (true) {
                System.out.print("Ingresa un número: ");
                int numero = scanner.nextInt();
                System.out.println("Has ingresado: " + numero);
                Thread.sleep(1000); // Simula el bucle del juego
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            scanner.close(); // Cerrar el Scanner para evitar fugas de recursos
            player.stop();   // Detener la música cuando el juego termina
        }
    }
}
