package learnIO;

import java.io.StringReader;

/**
 * use my class bufferedInputFile to read file content to memory
 * and then use StringReader to read from memory
 */
public class MemoryInput {
  public static void main(String[] args) throws Exception{
    StringReader in = new StringReader(BufferedInputFile.read("C:\\Users\\Administrator\\Documents\\test"));
    int c;
    while ((c = in.read()) != -1) {
      System.out.print((char) c);
    }
  }
}
