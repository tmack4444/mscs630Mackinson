import java.io.IOException;
import java.io.InputStream;
import java.io.FileReader;
import java.io.BufferedReader;
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
          BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
          String[] cipherText = new String[ (int) reader.lines().count()];
          for(int i = 0; i < cipherText.length; i++){
            cipherText[i] = reader.readLine();
            System.out.println(cipherText[i]);
          }
          reader.close();

    } catch(IOException e){
      e.printStackTrace();
    }

  }

}
