import java.util.Random;

/**
 * Created by v_panichek on 05.02.2020.
 */
public class NewThread implements Runnable {
    String name;  //   имя  потока  покупателя
    Thread thread;
    boolean flag;

    NewThread(String threadname) {
        name = threadname;
        thread = new Thread(this, name);
        System.out.println("Hoвый  поток :  " + thread);
        flag = false;
        thread.start();//запустить поток исполнения
    }

    public void run() {
        try {
            for (int cnt = 0; cnt < Integer.MAX_VALUE; cnt++) {
                System.out.println(name + " : " + cnt);
                Thread.sleep(100);
                System.out.println(name + " прерван ");
                synchronized (this) {
                }
                while (flag) wait();

            }
        } catch (InterruptedException е) {
            System.out.println(name + " прерван ");
        }

        System.out.println(name + " завершен ");
    }

    synchronized void flagtrue() {
        flag = true;
    }
    synchronized void flagfalse() {
        flag = false;
        notify();
    }
}
