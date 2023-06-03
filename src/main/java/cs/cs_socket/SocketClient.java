package cs.cs_socket;

/**
 * 创建一个客户端所需步骤：
	创建Socket对象，指明需要连接的服务器的地址和端口。
	建立连接后，通过输出流向服务器发送请求信息。
	通过输入流获取服务器的响应信息。
	关闭相关资源
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class SocketClient {
	public static void main(String[] args) {
		SocketClient socketClient = new SocketClient();
		socketClient.startClient(8999);
	}
	
	void startClient(int port){
		
		try {
			Socket clientSocket = new Socket("localhost", port);
			System.out.println("Clent start");
			//给服务器发消息
			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
			//接收服务器传过来的消息
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			//键盘输入消息，发送给服务端
			BufferedReader inputReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			String readLine = null;
			while (!(readLine = inputReader.readLine()).equals("bye")) {
				System.out.println("我(客户端)" + readLine);
				//将键盘输入的消息发送给服务器
				bufferedWriter.write(readLine + "\n");
				bufferedWriter.flush();
				String response = bufferedReader.readLine();
				System.out.println("服务端： " + response);
			}
			bufferedWriter.close();
			inputReader.close();
			clientSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
