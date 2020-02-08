import java.util.concurrent.Phaser;

public class ManThread implements Runnable {
    Phaser phsr;
    String name;

    public ManThread(Phaser count, String n) {
        phsr = count;
        name = n;
        phsr.register();
        new Thread(this).start();
    }

    public void run() {
        while (!phsr.isTerminated()) {
            System.out.println(" Поток " + name + " начинает  фазу " + phsr.getPhase());

            phsr.arriveAndAwaitAdvance();
            try {
                Thread.sleep(100);
            } catch (InterruptedException е) {
                System.out.println(е);
            }
        }
    }
}
