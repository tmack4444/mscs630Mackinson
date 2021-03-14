import java.util.Scanner;

public class Driver_lab3b {


  public static void main(String [] args){
    Scanner in = new Scanner(System.in);
    String pad = in.nextLine();
    String P = in.nextLine();
    int numPad = 16 % P.length();
    for(int i = 0; i < numPad; i++){
      P += pad;
    }
    int numArray = Math.max(1, P.length() / 16);
    int[][][] results = new int[numArray][4][4];
    for(int i = 0; i < numArray; i++) {
      String p = P.substring(i*16, (i*16 + 16));
      results[i] = getHexMatP(p);
    }

    for(int j = 0; j < numArray; j++){
      for(int k = 0; k < 4; k++){
        for(int l = 0; l < 4; l++){
          System.out.print(results[j][k][l] + " ");
        }
        System.out.println();
      }
      System.out.println();
    }
  }

  public static int[][] getHexMatP(String p){
    int[][] result = new int[4][4];
    int currInd = 0;
    for(int i = 0; i < 4; i++){
      for(int j = 0; j < 4; j++){
        int currVal = (p.charAt(currInd) + "").getBytes()[0];
        result[i][j] = currVal;
        currInd++;
      }
    }
    return result;
    }
  }
