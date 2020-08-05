package netty.java.nio.file;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;

/**
 * @author crazy
 * @title: FileChannelTest
 * @projectName JavaCode
 * @description: TODO
 * @date 2020/6/2419:52
 */
public class FileChannelTest {

    public static void main(String[] args) throws Exception {
        RandomAccessFile randomAccessFile
                = new RandomAccessFile("/Users/crazy/Downloads/", "rws");
        FileChannel channel = randomAccessFile.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(48);
        ByteBuffer buffer = ByteBuffer.allocate(48);
        ByteBuffer[] bufferArray = {buf, buffer};
        long read = channel.read(bufferArray);
        while (read != -1) {
            System.out.println("Read " + bufferArray);
            buf.flip();
            buffer.flip();
            while (buf.hasRemaining()) {
                System.out.print((char) buf.get());
            }
            buf.clear();
            buffer.clear();
            read = channel.read(bufferArray);
        }
        randomAccessFile.close();
    }
}
