import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.File;
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
      File audio = new File(sourceFile);
      InputStream is = new FileInputStream(audio);
      byte[] buffer = new byte[(int) audio.length()];
      is.read(buffer);
      is.close();
      System.out.println(buffer.length);
      /*
      for(int i = 0; i < buffer.length; i++){
        System.out.println(buffer[i]);
      }
      */
      //Instead of outputing the input stream, convert it to hex, and
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
