
public class MiSegundoHilo implements Runnable {

    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.println("2do hilo => " + i);
        }
    }
}