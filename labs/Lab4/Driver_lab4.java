import java.util.Scanner;

public class Driver_lab4 {

 public static void main(String [] args){
   Scanner in = new Scanner(System.in);
   String input = in.nextLine();
   AESCipher keygen = new AESCipher();
   String[] Keys = keygen.roundKeysHex(input);
   String output = "";
   for(int i = 0; i < 11; i++){
     output += Keys[i].toUpperCase() + "\n";
   }
   output = output.trim();
   System.out.println(output);
 }

}
