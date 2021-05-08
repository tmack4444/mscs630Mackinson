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
    //  System.out.print("Enter File Name: ");
      //String sourceFile = input.nextLine();
      String sourceFile = "plaintext.mp3";
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
      //System.out.println(key);
      File audio = new File(sourceFile);
      InputStream is = new FileInputStream(audio);
      byte[] buffer = new byte[(int) audio.length()];
      //System.out.println("Now reading file");
      is.read(buffer);
      is.close();
      String bufferToHexArray = "";
      //System.out.println("Now loading file to hexString");
      final long startTime = System.currentTimeMillis();
      for(int i = 0; i < buffer.length; i++){
        String temp = Integer.toHexString(Byte.toUnsignedInt(buffer[i]));
        if(temp.length() == 1)
          bufferToHexArray += "0";
        bufferToHexArray += temp;
        /* Debugging code simply to get the amount of time it takes to convert every 100000 bytes to hex string
        if(i % 100000 == 0){
          System.out.println(i);
          System.out.println((System.currentTimeMillis() - startTime) / 1000);
        }
        */
      }
      //System.out.println("Now loading hexString to array of hexStrings");
      String[][][] Keys = new String[bufferToHexArray.length()/32][4][4];
      AESCipher encrypt = new AESCipher();
      for(int j = 0; j < Keys.length; j++){
        Keys[j] = encrypt.AESSeq(key, bufferToHexArray.substring(j*32, j*32 + 32));
      }
      int iterator = 0;
      String[] output = new String[Keys.length];
      for(int i = 0; i < Keys.length; i++){
        for(int r = 0; r < Keys[i].length; r++){
          for(int c = 0; c < Keys[i][r].length; c++){
            if(Keys[i][r][c].length() == 1){
              output[iterator] += "0";
            }
            output[iterator] += Keys[i][r][c];
          }
        }
        System.out.println(output[iterator]);
        iterator++;
      }

      //System.out.println("Done!");

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
