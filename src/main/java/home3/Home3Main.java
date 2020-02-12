package home3;

import java.util.concurrent.Exchanger;

public class Home3Main implements Runnable {
    public static void main( String[] args ) throws InterruptedException {
        Exchanger<String> ex = new Exchanger<>();
        new Thread(new Loader2(ex)).start();
        new Thread(new Transporter2(ex)).start();
        new Thread(new Unloader2(ex)).start();
    }
    public void run() {

    }
}
