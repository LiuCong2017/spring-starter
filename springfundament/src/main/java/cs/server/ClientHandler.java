package cs.server;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.List;

//与客户端交互
public class ClientHandler implements Runnable{

    private Socket socket;
    private String host; //客户端地址
    private List<PrintWriter> allOut;

    //初始化socket及客户端ip
    public ClientHandler(Socket socket){
        this.socket = socket;
        InetAddress address = socket.getInetAddress();//获取客户端地址信息
        host = address.getHostAddress();//获取地址字符串形式
        this.allOut = Server.allOut;
    }

    //广播
    private void sendMessage(String msg){
        synchronized(allOut){
            for(PrintWriter o:allOut){
                o.println(msg);
            }
        }
    }

    public void run(){
        PrintWriter pw = null;

        try {
            //获取输入流
            InputStream in = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(in, "utf-8");
            BufferedReader br = new BufferedReader(isr);
            //创建输出流
            OutputStream out = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(out, "utf-8");
            pw = new PrintWriter(osw, true);

            synchronized (allOut) {
                allOut.add(pw);//将输出存入共享集合
            }
            sendMessage(host + "上线了,当前在线客户端: " + allOut.size());
            String msg = null;
            /*
             * 使用br.readLine()读取客户端发送过来的一行字符串时，
             * 由于客户端所在系统不同，那么这里执行的结果也不同。
             * 当Linux的客户端断开连接时：
             * br.readLine方法会返回null
             * 当windows的客户端断开连接时：
             * br.readLine方法会直接抛出异常
             */
            while ((msg = br.readLine()) != null) {
                sendMessage(host + ": " + msg);//消息广播给所有客户端
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //客户端断开连接后的操作
            synchronized(allOut){
                allOut.remove(pw);
            }
            sendMessage(host+"已下线,当前在线: "+allOut.size());
            //释放资源
            try {
                socket.close();
            } catch (IOException e) {
                System.out.println("客户端断开了连接发生异常");
                e.printStackTrace();
            }
        }

    }


}
