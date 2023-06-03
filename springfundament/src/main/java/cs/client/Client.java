package cs.client;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client{

    private Socket socket;
    private static final String serverIP = "127.0.0.1";
    private static final int serverPort = 8088;

    //客户端初始化
    public Client(){
        try {
            System.out.println("正在连接服务器...");
            socket = new Socket(serverIP,serverPort);
            System.out.println("与服务端建立连接");
        } catch (Exception e) {
            System.out.println("连接服务器失败");
            e.printStackTrace();
        }
    }

    //启动客户端
    public void start(){
        try {
            Scanner sc = new Scanner(System.in);

            //创建发送消息给服务器的输出流
            OutputStream out = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(out,"utf-8");
            PrintWriter pw = new PrintWriter(osw,true); //true表示自动刷新

            //启动接收消息线程
            ServerHandler handler = new ServerHandler(socket);
            Thread t = new Thread(handler);
            t.start();

            System.out.println("聊天开始:");
            String msg = null;
//		long lastSend = System.currentTimeMillis()-1000;
            while(true){
                msg = sc.nextLine();
//			if(System.currentTimeMillis()-lastSend<1000){
//				System.out.println("说话太快了，稍等一下！");
//			}
                pw.println(msg);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
