import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class EncryptAudio {

    public static void main(String[] args) throws IOException {
      Scanner input = new Scanner(System.in);
      System.out.print("Enter File Name: ");
      String sourceFile = input.nextLine();
      System.out.print("Enter Encryption Key: ");
      String key = input.nextLine();
      InputStream is = new FileInputStream(sourceFile);
      byte[] buffer = new byte[1024];
      int length;
      //Instead of outputing the input stream, convert it to hex, and
      while((length = is.read(buffer)) > 0) {
        System.out.println(buffer);
      }
      // TODO
      /*
      OutputStream os = new FileOutputStream(resultFile);
      byte[] buffer = new byte[1024];
      int length;
      while((length = is.read(buffer)) > 0) {
        os.write(buffer, 0, length);
      }
      */
    }
}
