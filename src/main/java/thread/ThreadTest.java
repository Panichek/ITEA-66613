package thread;

public class ThreadTest implements Runnable{

    Thread thread;

    public ThreadTest() {
        thread = new Thread(this, "Thread test");
        thread.start();
    }

    @Override
    public void run()
    {
        System.out.println("Hi!!!");
    }



}
