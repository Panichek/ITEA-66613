import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class HomeServer extends Thread {
    Socket ss;
    int num;

    public HomeServer(int num, Socket ss) {
        this.ss = ss;
        this.num = num;
        setDaemon(true);
        start();
    }

    public static void main(String[] args) {
        try {
            int connection = 0;
            ServerSocket ss = new ServerSocket(1234, 0, InetAddress.getByName("127.0.0.1"));
            System.out.println("Start, waiting...");
            new HomeServer(++connection, ss.accept());
            System.out.println("Connected" + connection);
            Socket client = ss.accept();
            client.getOutputStream().write(111);
            client.close();
            //ss.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        try {
            InputStream is = ss.getInputStream();
            OutputStream os = ss.getOutputStream();
            byte[] buf = new byte[64 * 1024];
            int r = is.read(buf);
            String data = new String(buf, 0, r);
            System.out.println("Accept " + data);
            data = "Hello from server";
            os.write(data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
