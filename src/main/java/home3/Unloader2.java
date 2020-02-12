package home3;

import java.util.concurrent.Exchanger;

public class Unloader2 implements Runnable {
    String str;
    Exchanger<String> ex;
    Unloader2(Exchanger<String> ex){
        this.ex = ex;
        str = new String();
    }
    @Override
    public void run() {
        for(int i = 0; i < 6; i ++){
            //String str = "Loader" + i;
            try {
                str = ex.exchange(new String());
                System.out.println("Unloader2 " + str);
                str = ex.exchange(str);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
