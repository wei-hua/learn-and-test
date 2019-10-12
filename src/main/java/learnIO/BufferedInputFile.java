package learnIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

/**
 * read content from file or string and use buffer to speed up.
 */
public class BufferedInputFile {
  public static String read(String fileName) throws Exception {
    //reading input by lines
    BufferedReader in = new BufferedReader(new FileReader(fileName));
    String s;
    StringBuilder sb = new StringBuilder();
    while ((s = in.readLine())!= null) {
      sb.append(s+"\n");
    }
    in.close();
    return sb.toString();
  }

  public static void readByLineAndInversePrint(String fileName) throws Exception{
    LinkedList linkedList = new LinkedList();

    BufferedReader in = new BufferedReader(new FileReader(fileName));
    String s;
    while ((s = in.readLine())!= null) {
      linkedList.add(s);
    }
    in.close();
    while (linkedList.size()!= 0) {
      System.out.print(linkedList.pollLast()+"\n");
    }
  }

  public static void main(String[] args) throws Exception {
//    System.out.print(read("C:\\Users\\Administrator\\Documents\\test"));
    readByLineAndInversePrint("C:\\Users\\Administrator\\Documents\\test");
  }
}
