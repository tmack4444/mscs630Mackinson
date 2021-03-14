import java.util.Scanner;
import java.lang.Byte;

public class Driver_lab3b {


  public static void main(String [] args){
    Scanner in = new Scanner(System.in);
    String pad = in.nextLine();
    String P = in.nextLine();
    int numPad = 16 % P.length();
    System.out.println("P.length: " + P.length());
    System.out.println("P.length % 16: " + 16 %  P.length() );
    System.out.println("numPad: " + numPad);
    for(int i = 0; i < numPad; i++){
      P += pad;
    }
    int numArray = Math.max(1, P.length() / 16);
    int result[][] = new int[4][4*numArray];
    System.out.println("P.length: " + P.length());
    System.out.println("numPad: " + numPad);
    System.out.println("numArray " + numArray);
    for(int i = 0; i < numArray; i++) {
      String p = P.substring(i*16, (i*16 + 16));
      getHexMatP(p);
    }
  }

  public static int[][] getHexMatP(String p){
    int[][] result = new int[4][4];
    for(int i = 0; i < 4; i++){
      for(int j = 0; j < 4; j++){
        byte currVal = Byte.parseByte(p.charAt( (i+1 * j) ) + "" );
        result[i][j] = currVal;
        System.out.print(result[i][j] + " ");
      }
      System.out.println();
    }
    return result;
    }
  }
