package cs.client;

import java.io.IOException;

public class ClientTest {

    public static void main(String[] args) throws IOException {
//        Client client = new Client("127.0.0.1",9000);
        Client client = new Client();
        client.start();
    }

}
