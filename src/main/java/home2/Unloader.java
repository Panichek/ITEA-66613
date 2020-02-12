package home2;

public class Unloader implements Runnable{
    private Process process;

    public Unloader(Process process) {
        this.process = process;
        new Thread(this).start();
    }
    public void run() {
        System.out.println("Start" +toString());
        while (Loader.getLoad() < 101) {
            try {
                Thread.sleep(10);
                process.Unloader();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public String toString(String transporter) {
        return "Unloader";
    }
}
