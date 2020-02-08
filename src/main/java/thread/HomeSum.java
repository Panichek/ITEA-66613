package thread;

import java.util.ArrayList;
import java.util.Timer;

public class HomeSum extends Thread {

    private String nameThread;
    private int random;
    private ArrayList<Integer> summ = new ArrayList<>();

    public String getNameThread() {
        return nameThread;
    }

    public void setNameThread(String nameThread) {
        this.nameThread = nameThread;
    }

    public int getRandom() {
        return random;
    }

    public void setRandom(int currentNum) {
        this.random = currentNum;
    }

    public ArrayList<Integer> getInt() {
        return summ;
    }

    public void setInt(ArrayList<Integer> summ) {
        this.summ = summ;
    }

     public HomeSum(String HomeSum) {
        this.nameThread = nameThread;
    }

    public void run() {
        for (int cnt = 0; cnt < 5; cnt++) {
            Timer myTimer = new Timer();
            try {
                Thread.sleep(2000);
                random = (int) (Math.random() * 100);
                summ.add(random);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myTimer.cancel();
        }

    }
}
