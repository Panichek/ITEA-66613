package home2;

public class Home2Main implements Runnable {
    public static void main( String[] args ) throws InterruptedException {
        Process process = new Process();
        new Loader(process).toString();
        new Transporter(process).toString();
        new Unloader(process).toString();
    }

    public void run() {

    }
}
