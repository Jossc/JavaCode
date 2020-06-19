package netty.java;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;

/**
 * @ClassName TimeServerHandler
 * @Description 自定义客户端连接
 * @Author Crazy
 * @Date 2020/6/18 22:58
 */
@Slf4j
public class TimeServerHandler implements Runnable {

    private final Socket socket;

    public TimeServerHandler(Socket socket) {
        this.socket = socket;
    }


    @Override
    public void run() {
        BufferedReader bufferedReader = null;
        PrintWriter out = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()
            ));
            out = new PrintWriter(socket.getOutputStream());
            String body = null;
            while (true) {
                //循环一直读取
                body = bufferedReader.readLine();
                if (Objects.isNull(body)) {
                    break;
                }
                System.err.println("time Server Handler is :" + body);
                out.println("哈哈哈  你想干什么啊");
            }
        } catch (IOException e) {
            System.err.println(e);
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }

    }
}
