package home2;

public class Process {
    private int process;
    boolean processLoaderFlag = true;
    boolean processTransporterFlag = false;
    boolean processUnloaderFlag = false;

    public synchronized void Loader() throws InterruptedException {
        if (!processLoaderFlag) {
            wait();
        }
        process = Loader.getLoad();
        System.out.println("Loader: " + process);
        processTransporterFlag = false;
        processTransporterFlag = true;
        processUnloaderFlag = false;
        Thread.sleep(3000);
        notify();
    }

    public synchronized void Transporter() throws InterruptedException {
        if (!processTransporterFlag) {
            wait();
        }
        System.out.println("Transporter: " + process);
        processTransporterFlag = false;
        processTransporterFlag = false;
        processUnloaderFlag = true;
        Thread.sleep(3000);
        notify();
    }

    public synchronized void Unloader() throws InterruptedException {
        if (!processUnloaderFlag) {
            wait();
        }
        System.out.println("Unloader: " + process);
        processLoaderFlag = true;
        processTransporterFlag = false;
        processUnloaderFlag = false;
        Thread.sleep(3000);
        notify();
    }


}
