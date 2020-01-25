import java.io.IOException;
import java.net.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class HomeClient {
    public static void main(String[] args) {
        try {
            Socket s1 = new Socket(InetAddress.getByName("127.0.0.1"), 1234);
            String data = "client1 hello";
            s1.getOutputStream().write(data.getBytes());
            byte[] buf = new byte[0];
            int r = s1.getInputStream().read(buf);
            data = new String(buf, 0, r);
            System.out.println("Answer: " + data);
            s1.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

