package home2;

public class Loader implements Runnable {
    private static int load;
    private Process process;

    public Loader(Process process) {
        this.process = process;
        new Thread(this).start();
    }
    public void run() {
        System.out.println("Start"+toString());
        while (Loader.getLoad() < 101) {
            load += 6;
            try {
                Thread.sleep(10);

                process.Loader();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static int  getLoad() {
        return load;
    }

    public String toString(String transporter) {
        return "Loader";
    }


}
