package learnIO;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;


/**
 * Created by Alina on 2019/9/17.
 */
public class LargeMappedFiles {
  static int length = 0x8FFFFFF; //128M

  public static void main(String[] args) throws Exception {
    MappedByteBuffer out = new RandomAccessFile("C:\\Users\\Administrator\\Documents\\testout", "rw")
      .getChannel()
      .map(FileChannel.MapMode.READ_ONLY, 0, length);

    for (int i = 0; i<length; i++) {
      out.put((byte)'x');
    }
  }
}
