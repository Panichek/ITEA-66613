package thread;

import java.util.ArrayList;
import java.util.Iterator;

public class Starter extends Thread {

    public static void main(String[] args) {
        HomeSum thread1 = new HomeSum("A");
        HomeSum thread2 = new HomeSum("B");
        thread1.start();
        System.out.println(thread1.getStackTrace());
        thread2.start();
        System.out.println(thread1.getStackTrace());
        while (thread1.isAlive() && thread2.isAlive()) {
        }

        System.out.println(thread1.getStackTrace() + ": " + thread1.getInt() );
        System.out.println(thread1.getStackTrace() + ": " + thread2.getInt() );
        int summ1 = sum(thread1.getInt());
        int summ2 = sum(thread2.getInt());
        System.out.println(thread1.getStackTrace() + "  поток A: " + summ1);
        System.out.println(thread2.getStackTrace() + "  поток B: " + summ2);

        if (summ1 > summ2) {
            System.out.println("поток A victory");
        } else {
            System.out.println("поток B victory");
        }
    }

    public static int sum(ArrayList<Integer> list) {
        Iterator<Integer> iter = list.iterator();
        int res = 0;
        while (iter.hasNext()) {
            int num = iter.next();
            res += num;
        }
       return res;
    }

}