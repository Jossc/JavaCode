package netty.java.nio.file;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashSet;

/**
 * @author Hikari
 * @version 1.0.0
 * @ClassName ChannelTest.java
 * @createTime 2020年06月30日 23:12:00
 */
public class ChannelTest {

    public static void main(String[] args) throws IOException {
        FileChannel fileChannel = FileChannel.open
                (Paths.get("/Users/crazy/java_error_in_idea_14558.log"), StandardOpenOption.READ);
        HashSet<StandardOpenOption> hashSet = new HashSet();
        hashSet.add(StandardOpenOption.WRITE);
        FileChannel outChannel = FileChannel.open(Paths.get("Users/crazy/Desktop/poi_brand.sql"), hashSet);
        MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE,
                0, fileChannel.size());
        /*MappedByteBuffer outBuffer = outChannel.map(FileChannel.MapMode.READ_WRITE,0,fileChannel.size());*/
        mappedByteBuffer.flip();
        outChannel.write(mappedByteBuffer);
    }
}
