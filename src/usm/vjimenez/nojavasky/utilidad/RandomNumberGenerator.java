package usm.vjimenez.nojavasky.utilidad;
import java.util.Random;


public class RandomNumberGenerator {
    public static int rand(int a, int b) {
        Random rand = new Random();
        return Math.round(a + (rand.nextFloat() * (b - a)));
    }
}
