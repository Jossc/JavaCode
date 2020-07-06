package mysql;

import com.github.shyiko.mysql.binlog.BinaryLogFileReader;
import com.github.shyiko.mysql.binlog.event.Event;
import com.github.shyiko.mysql.binlog.event.deserialization.ChecksumType;
import com.github.shyiko.mysql.binlog.event.deserialization.EventDeserializer;

import java.io.File;
import java.io.IOException;

/**
 * @author crazy
 * @title: TTTT
 * @projectName JavaCode
 * @description: TODO
 * @date 2020/7/316:28
 */
public class TTTT {
    public static void main(String[] args) throws IOException {
        String filePath="/Users/crazy/Downloads/mysql_bin.000304";
        File binlogFile = new File(filePath);
        EventDeserializer eventDeserializer = new EventDeserializer();
        eventDeserializer.setChecksumType(ChecksumType.CRC32);
        BinaryLogFileReader reader = new BinaryLogFileReader(binlogFile, eventDeserializer);
        for (Event event; (event = reader.readEvent()) != null; ) {
            System.out.println(event.toString());
        }
        reader.close();
    }
}
