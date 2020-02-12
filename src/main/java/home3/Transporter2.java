package home3;

import java.util.concurrent.Exchanger;

public class Transporter2 implements Runnable {
    String str;
    Exchanger<String> ex;

    Transporter2(Exchanger<String> ex) {
        this.ex = ex;
        str = new String();
    }

    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            try {

                str = ex.exchange(str);
                System.out.println("Transporter2 " + str);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
