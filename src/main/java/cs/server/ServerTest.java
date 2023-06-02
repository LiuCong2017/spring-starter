package cs.server;

public class ServerTest {
    public static void main(String[] args) {
        try {
            Server server = new Server();
            server.start();
        } catch (Exception e) {
            System.out.println("服务端启动失败");
            e.printStackTrace();
        }
    }
}
