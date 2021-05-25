import java.util.Scanner;

public class Driver_lab5 {

 public static void main(String [] args){
   Scanner in = new Scanner(System.in);
   String input = in.nextLine();
   String plaintext = in.nextLine();
   AESCipher keygen = new AESCipher();
   String[] output = keygen.AES(plaintext, input);
   System.out.print(output[0]);
 }

}
