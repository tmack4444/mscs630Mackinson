import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.File;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.util.Scanner;
import java.util.Random;

public class EncryptAudio {

    public static void main(String[] args) throws IOException {
      Scanner input = new Scanner(System.in);
      System.out.print("Enter File Name: ");
      String sourceFile = input.nextLine();
      /*System.out.print("Enter Encryption Key: ");
      String key = input.nextLine();
      if(key.length() > 32){
        key = key.substring(0, 32);
      } else if (key.lnegth() < 32){
        //TODO generate a random hex string of length 32 - inputKey;
      }
      key = Integer.toHexString
      */
      String key = keyGen();
      System.out.println(key);
      File audio = new File(sourceFile);
      InputStream is = new FileInputStream(audio);
      byte[] buffer = new byte[(int) audio.length()];
      System.out.println("Now reading file");
      is.read(buffer);
      is.close();
      String bufferToHexArray = "";
      System.out.println("Now loading file to hexString");
      final long startTime = System.currentTimeMillis();
      for(int i = 0; i < buffer.length; i++){
        String temp = Integer.toHexString(Byte.toUnsignedInt(buffer[i]));
        if(temp.length() == 1)
          bufferToHexArray += "0";
        bufferToHexArray += temp;
        if(i % 100000 == 0){
          System.out.println(i);
          System.out.println((System.currentTimeMillis() - startTime) / 1000);
        }
      }
      System.out.println("Now loading hexString to array of hexStrings");
      String[] plaintext = new String[bufferToHexArray.length()/32];
      for(int j = 0; j < plaintext.length; j++){
        plaintext[j] = bufferToHexArray.substring(j+1 , j+1 * 32);
      }
      System.out.println("Done!");
      //Encrypt the file

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

    public static String keyGen(){
      Random r = new Random();
      StringBuffer sb = new StringBuffer();
      while(sb.length() < 32){
        sb.append(String.format("%08x", r.nextInt()));
      }
      return sb.toString().substring(0, 32);
    }
}
