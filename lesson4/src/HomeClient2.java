import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class HomeClient2 {
    public static void main(String[] args) {
        try {
            Socket s2 = new Socket(InetAddress.getByName("127.0.0.1"), 1234);
            String data = "client2 hello!";
            OutputStream os = s2.getOutputStream();
            s2.getOutputStream().write(data.getBytes());
            byte[] buf = new byte[0];
            int r = s2.getInputStream().read(buf);
            data = new String(buf, 0, r);
            System.out.println("Answer: " + data);
            s2.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
