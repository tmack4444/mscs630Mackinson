import java.io.IOException;
import java.io.InputStream;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Scanner;

public class DecryptAudio{

  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    //System.out.print("Enter File Name: ");
    //String sourceFile = input.nextLine();
    System.out.print("Enter Encryption Key: ");
    String key = input.nextLine();
    if(key.length() != 32){
      System.out.println("Error! Key is invalid");
    }

    try {
      String sourceFile = "ciphertext.txt";
      File cipher = new File(sourceFile);
      BufferedReader reader = new BufferedReader(new FileReader(cipher));
      List<String> list = reader.lines().collect(Collectors.toList());
      String[] cipherText = new String[list.size()];
      cipherText = list.toArray(cipherText);
      reader.close();
      AESDeCipher decrypt = new AESDeCipher();
      String[][] output = new String[4][4];
      output = decrypt.AESDSeq(key, cipherText[0]);
      



    } catch(IOException e){
      e.printStackTrace();
    }
  }
}
