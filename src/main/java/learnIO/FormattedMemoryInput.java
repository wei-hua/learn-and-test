package learnIO;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

/**
 * 使用字节流读取内存中的所有字节，这样可以输出所有的字节，包括格式化的字节
 */
public class FormattedMemoryInput {
  public static void main(String[] args) throws Exception{
    DataInputStream in = new DataInputStream
      (new ByteArrayInputStream(
        BufferedInputFile.read("C:\\Users\\Administrator\\Documents\\test").getBytes()));
    while (in.available() != 0) {
      System.out.print((char)in.readByte());
    }
  }
}
