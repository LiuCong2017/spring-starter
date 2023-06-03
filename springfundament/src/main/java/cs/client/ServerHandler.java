package cs.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

//处理服务端发过来的消息
public class ServerHandler implements Runnable{
    private Socket socket;

    public ServerHandler(Socket socket) {
        super();
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream in = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(in,"utf-8");
            BufferedReader br = new BufferedReader(isr);

            String msg = null;
            while((msg = br.readLine())!=null){
                System.out.println("服务端说: "+msg);
//				System.out.println(msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
