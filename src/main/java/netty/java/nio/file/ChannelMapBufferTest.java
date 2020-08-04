package netty.java.nio.file;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author Hikari
 * @version 1.0.0
 * @ClassName ChannelMapBufferTest.java
 * @createTime 2020年08月03日 21:42:00
 */
public class ChannelMapBufferTest {

    public static void main(String[] args) {
        new ChannelMapBufferTest().testMapBuffer();

    }

    public void testMapBuffer() {
        try (FileChannel open = FileChannel
                .open(Paths.get("C:\\Users\\Crazy\\Desktop\\gc.log"),
                StandardOpenOption.READ);
             FileChannel out = FileChannel.
                     open(Paths.get("C:\\Users\\Crazy\\Desktop\\1.log"),
                     StandardOpenOption.CREATE, StandardOpenOption.WRITE,
                     StandardOpenOption.READ)) {
            MappedByteBuffer mappedByteBuffer = open.map(FileChannel.MapMode.READ_ONLY, 0, open.size());
            out.write(mappedByteBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
