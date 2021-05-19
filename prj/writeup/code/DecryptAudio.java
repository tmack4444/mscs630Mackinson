import java.io.IOException;
import java.io.InputStream;
import java.io.File;
import java.nio.file.Files;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Scanner;

public class DecryptAudio{

  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter File Name: ");
    String sourceFile = input.nextLine();
    System.out.print("Enter Encryption Key: ");
    String key = input.nextLine();
    if(key.length() != 32){
      System.out.println("Error! Key is invalid");
    }

    try {
      File cipher = new File(sourceFile);
      BufferedReader reader = new BufferedReader(new FileReader(cipher));
      List<String> list = reader.lines().collect(Collectors.toList());
      String[] cipherText = new String[list.size()];
      cipherText = list.toArray(cipherText);
      reader.close();
      AESDeCipher decrypt = new AESDeCipher();
      String[][][] output = new String[cipherText.length][4][4];
      for(int j = 0; j < output.length ; j++){
        output[j] = decrypt.AESDSeq(key, cipherText[j]);
      }
      byte[] decryptedData = new byte[output.length*16];
      int iterator = 0;
      for(int i = 0; i < output.length; i++){
        for(int c = 0; c < 4; c++){
          for(int r = 0; r < 4; r++){
            decryptedData[iterator] = (byte) Integer.parseInt(output[i][c][r], 16);
            iterator++;
          }
        }
      }
      try {
        FileOutputStream fos = new FileOutputStream("decrypted.mp3");
        fos.write(decryptedData);
        fos.close();
      } catch(IOException e){
        e.printStackTrace();
      }
    } catch(IOException e){
      e.printStackTrace();
    }
  }
}
