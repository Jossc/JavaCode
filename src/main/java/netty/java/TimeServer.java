package netty.java;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName TimeServer
 * @Description TODO
 * @Author Crazy
 * @Date 2020/6/18 23:25
 */
public class TimeServer {
    public static void main(String[] args) throws IOException {
        int port = 8085;
        ServerSocket server = null;
        try {
            // 创建服务
            server = new ServerSocket(port);
            System.out.println("The time server is start  in port :" + port);
            Socket socket = null;
            while (true) {
                // 监听
                socket = server.accept();
                new Thread(new TimeServerHandler(socket)).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                server.close();
                System.out.println("The time server is close!");
                server = null;
            }
        }
    }

}
