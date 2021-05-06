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
      System.out.println("Now reading file");
      is.read(buffer);
      is.close();
      String bufferToHexArray = "";
      System.out.println("Now loading file to hexString");
      for(int i = 0; i < buffer.length; i++){
      //System.out.println(i);
        String temp = Integer.toHexString(Byte.toUnsignedInt(buffer[i]));
        if(temp.length() == 1)
          bufferToHexArray += "0";
        bufferToHexArray += temp;
        //if(bufferToHexArray.length()>=32){
        //  plaintext[j] = bufferToHexArray.substring(0,32);
        //}

      }
      System.out.println("Now loading hexString to array of hexStrings");
      String[] plaintext = new String[bufferToHexArray.length()/32];
      for(int j = 0; j < plaintext.length; j++){
      }
      System.out.println("Done!");

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
