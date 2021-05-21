import java.util.Scanner;

public class Driver_lab5 {

 public static void main(String [] args){
   Scanner in = new Scanner(System.in);
   String input = in.nextLine();
   String plaintext = in.nextLine();
   AESCipher keygen = new AESCipher();
   String output = keygen.AESSeq(input, plaintext);
   System.out.print(output);
 }

}
