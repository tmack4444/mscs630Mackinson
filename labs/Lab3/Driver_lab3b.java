import java.util.Scanner;

public class Driver_lab3b {


  public static void main(String [] args){
    Scanner in = new Scanner(System.in);
    char pad = in.nextLine().charAt(0);
    String P = in.nextLine();
    int numPad = 16 % P.length();
    for(int i = 0; i < numPad; i++){
      P += pad;
    }
    int numArray = Math.max(1, P.length() / 16);
    int[][][] results = new int[numArray][4][4];
    for(int i = 0; i < numArray; i++) {
      String p = P.substring(i*16);
      results[i] = getHexMatP(pad, p);
    }
    String output = "";
    for(int j = 0; j < numArray; j++){
      for(int k = 0; k < 4; k++){
        for(int l = 0; l < 4; l++){
          output += (Integer.toHexString(results[j][l][k]).toUpperCase() + " ");
        }
        output += "\n";
      }
      output += "\n";
    }
    output = output.trim();
    System.out.print(output);
  }

  public static int[][] getHexMatP(char s, String P){
    int[][] result = new int[4][4];
    int currInd = 0;
    while(P.length() <= 16){
      P += s + "";
    }
    String p = P.substring(0, 16);
    for(int i = 0; i < 4; i++){
      for(int j = 0; j < 4; j++){
        int currVal = Integer.parseInt(Integer.toHexString(p.charAt(currInd)), 16);
        result[j][i] = currVal;
        currInd++;
      }
    }
    return result;
    }
  }
