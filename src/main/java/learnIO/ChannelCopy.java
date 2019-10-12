package learnIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by Alina on 2019/9/17.
 */
public class ChannelCopy {
  private static final int BSIZE = 1024;
  public static void copy(String sourceFile, String destFile) throws Exception {
    FileChannel in = new FileInputStream(sourceFile).getChannel();
    FileChannel out = new FileOutputStream(destFile).getChannel();

    ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
    while (in.read(buffer) != -1) {
      buffer.flip(); // prepare for writing
      out.write(buffer);
      buffer.clear(); //prepare for reading
    }
  }
}
