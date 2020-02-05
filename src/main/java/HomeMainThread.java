import java.util.Random;

/**
 * Created by v_panichek on 05.02.2020.
 */
public class HomeMainThread {
    public static void main(String args[]) {
        NewThread thread1 = new NewThread("Один");
        NewThread thread2 = new NewThread("Двa");
        NewThread thread3 = new NewThread("Три");
        NewThread thread4 = new NewThread("Четыре");
        NewThread thread5 = new NewThread("Пять");
        Random random = new Random();
        try {
            Thread.sleep(3000);
            thread1.flagtrue();
            System.out.println(random.nextInt(10) < 7 ? "true" : "false");
            System.out.println("Пpиocтaнoвкa  потока  Один");
            Thread.sleep(3000);
            thread1.flagfalse();
            System.out.println("Boзoбнoвлeниe  потока  Один");
            thread2.flagtrue();
            System.out.println(random.nextInt(10) < 7 ? "true" : "false");
            System.out.println("Пpиocтaнoвкa  потока  Два ");
            Thread.sleep(3000);
            thread2.flagfalse();
            System.out.println("Boзoбнoвлeниe  потока  Два");
            Thread.sleep(3000);
            thread3.flagtrue();
            System.out.println(random.nextInt(10) < 7 ? "true" : "false");
            System.out.println("Пpиocтaнoвкa  потока  Три");
            Thread.sleep(3000);
            thread3.flagfalse();
            System.out.println("Boзoбнoвлeниe  потока  Три");
            Thread.sleep(3000);
            thread4.flagtrue();
            System.out.println(random.nextInt(10) < 7 ? "true" : "false");
            System.out.println("Пpиocтaнoвкa  потока  Четыре");
            Thread.sleep(3000);
            thread4.flagfalse();
            System.out.println("Boзoбнoвлeниe  потока  Четыре");
            Thread.sleep(3000);
            thread5.flagtrue();
            System.out.println(random.nextInt(10) < 7 ? "true" : "false");
            System.out.println("Пpиocтaнoвкa  потока  Пять");
            Thread.sleep(3000);
            thread5.flagfalse();
            System.out.println("Boзoбнoвлeниe  потока  Пять");

        } catch (InterruptedException е) {
            System.out.println("Глaвный  поток  прерван ");
        }
        //ожидать завершения потоков исполнения
        try {
            System.out.println("Oжидaниe  завершения  потоков ");
            thread1.thread.join();
            thread2.thread.join();
            thread3.thread.join();
            thread4.thread.join();
            thread5.thread.join();
        } catch (InterruptedException е) {
            System.out.println("Глaвный  поток  прерван");
        }
        System.out.println("Глaвный  поток  завершен");
    }
}


