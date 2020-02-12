package home3;

import java.util.concurrent.Exchanger;

public class Loader2 implements Runnable {

    String str;
    Exchanger<String> ex;
    Loader2(Exchanger<String> ex){
        this.ex = ex;
        str = new String();
    }
    @Override
    public void run() {
        for(int i = 0; i < 6; i ++){

            try {
                str = ex.exchange(new String());
                System.out.println("Loader2 " + str);
                str = ex.exchange(str);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

