package netty.java.nio.file;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * @author crazy
 * @title: FileChannelTestTwo
 * @projectName JavaCode
 * @description: 管道的双详情
 * @date 2020/6/3017:36
 */
public class FileChannelTestTwo {

    public static void main(String[] args) throws Exception {
        RandomAccessFile fromFile = new RandomAccessFile("/Users/crazy/Downloads/fromFile.txt", "rw");
        FileChannel fromChannel = fromFile.getChannel();
        RandomAccessFile toFile = new RandomAccessFile("/Users/crazy/Downloads/toFile.txt", "rw");
        FileChannel toChannel = toFile.getChannel();
        long position = 0;
        long count = fromChannel.size();
        toChannel.transferFrom(fromChannel, position, count);

    }
}
