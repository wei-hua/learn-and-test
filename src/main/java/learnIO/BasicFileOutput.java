package learnIO;

import java.io.*;

/**
 * 从内存读入，并输出带行号的文本
 */
public class BasicFileOutput {
  public static void main(String[] args) throws Exception{
    BufferedReader in = new BufferedReader(
      new StringReader(
        BufferedInputFile.read("C:\\Users\\Administrator\\Documents\\test")));

//    PrintWriter out = new PrintWriter(
//      new BufferedWriter(
//        new FileWriter("C:\\Users\\Administrator\\Documents\\testOut")));

    PrintWriter out = new PrintWriter("C:\\Users\\Administrator\\Documents\\testOut");

    int lineCount = 1;
    String s;
    while ((s = in.readLine()) != null) {
      out.println(lineCount++ + ":" +s);
    }
    out.close();

  }
}
