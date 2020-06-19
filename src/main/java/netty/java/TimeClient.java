package netty.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;

/**
 * @ClassName TimeClinet
 * @Description 客户端
 * @Author Crazy
 * @Date 2020/6/18 23:13
 */
public class TimeClient {

    private static final int PORT = 8085;

    public static void main(String[] args) {
        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            socket = new Socket("127.0.0.1", PORT);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());
            out.println("query time order");
            String resp = in.readLine();
            System.err.println("now is :" + resp);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(out)) {
                out.flush();
                out.close();
                out = null;
            }
            if (Objects.nonNull(in)) {
                try {
                    in.close();
                    in = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }
}
