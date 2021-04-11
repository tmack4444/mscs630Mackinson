import java.util.Scanner;

public class Driver_lab5 {

 public static void main(String [] args){
   Scanner in = new Scanner(System.in);
   String input = in.nextLine();
   String plaintext = in.nextLine();
   AESCipher keygen = new AESCipher();
   String[][] Keys = keygen.AESSeq(input, plaintext);
   String output = "";
   for(int i = 0; i < 4; i++){
     for(int j = 0; j < 4; j++){
       if(Keys[i][j].length() == 1)
       output += "0";
       output += Keys[i][j].toUpperCase();
     }
   }
   output = output.trim();
   System.out.print(output);
 }

}
