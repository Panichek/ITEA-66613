package home2;

    public class Transporter implements Runnable {
        private Process process;

        public Transporter(Process process) {
            this.process = process;
            new Thread(this).start();
        }
        public void run() {
            System.out.println("Start"+toString());
            while (Loader.getLoad() < 101) {
                try {
                    Thread.sleep(10);
                    process.Transporter();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        public String toString(String transporter) {
            return "Transporter";
        }
    }
