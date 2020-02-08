package thread;

public class Main {
    public static void main(String[] args) {
        new ThreadTest();
        ThreadTest thread1 = new ThreadTest();


        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Liamda");
            }
        };
        new Thread(runnable).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Liamda 2");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Liamda 3");
            }
        }).start();

        System.out.println(Thread.activeCount());

    }
}
