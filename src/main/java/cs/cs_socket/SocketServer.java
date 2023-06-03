package cs.cs_socket;

/**
 * socket的基本使用，创建一个服务端所需步骤:
	创建ServerSocket对象绑定监听端口。
	通过accept()方法监听客户端的请求。
	建立连接后，通过输入输出流读取客户端发送的请求信息。
	通过输出流向客户端发送请求信息。
	关闭相关资源。
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
	public static void main(String[] args) {
		//第一步
		SocketServer socketServer = new SocketServer();
		socketServer.startServer(8999);
	}
	
	private void startServer(int port){
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			System.out.println("Sever start, wait connect...");
			//第二步 调用accept()方法开始监听，等待客户端的连接 这个方法会阻塞当前线程
			Socket socket = serverSocket.accept();
			System.out.println("Clint connect successful");
			//第三步 建立输入输出流读数据
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			String receivedMsg;
			while ((receivedMsg = br.readLine()) != null && !("end").equals(receivedMsg)){
				System.out.println("客户端： " + receivedMsg);
				//第四步 给客户端发送请求
				String response = "hello client";
				System.out.println("我(服务端): "+response);
				bw.write(response+ "\n");
				bw.flush();
			}
			//关闭相关资源
			socket.close();
			serverSocket.close();
			br.close();
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
