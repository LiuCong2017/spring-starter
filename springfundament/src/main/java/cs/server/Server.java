package cs.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class Server {

    private ServerSocket server;
    static List<PrintWriter> allOut;

    //初始化端口及输出IO
    public Server() throws Exception{
        server = new ServerSocket(8088);
        allOut = new ArrayList<PrintWriter>();
    }

    //服务启动方法
    public void start(){
        //阻塞方法
        while(true){
            try {
                //接受客户端连接
                System.out.println("等待一个客户端连接...");
                Socket socket = server.accept();
                System.out.println("与一个客户端建立了连接!");

                //启动交互线程处理连接
                ClientHandler handler = new ClientHandler(socket);
                Thread t = new Thread(handler);
                t.start();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}