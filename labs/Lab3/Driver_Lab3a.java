import java.util.Scanner;

public class Driver_Lab3a {

  public static void main(String [] args){
    Scanner in = new Scanner(System.in);
    int m = in.nextInt();
    int n = in.nextInt();
    int matrix[][] = new int[n][n];
    for(int i = 0; i < n; i++){
      for(int j = 0; j < n; j++){
        matrix[i][j] = in.nextInt();
      }
    }
    int det = cofModDet(m, matrix);
    System.out.println(det);
  }

  public static int cofModDet(int m, int [][] a){
    if(a.length == 1){
      return Math.floorMod(a[0][0], m);
    }
    if(a.length == 2){
      int A = Math.floorMod(a[0][0], m);
      int B = Math.floorMod(a[0][1], m);
      int C = Math.floorMod(a[1][0], m);
      int D = Math.floorMod(a[1][1], m);
      int ad = Math.floorMod(A * D, m);
      int bc = Math.floorMod(B * C, m);
      return Math.floorMod((ad - bc), m);
    }
    int result = 0;
    boolean plus = true;        // keep track of if we are adding or subtracting our determinant
    for(int i = 0; i < a.length; i++){
          int[][] aDet = new int[a.length-1][a.length-1];
          int x = 0;
          int y = 0;
          for(int k = 0; k < a.length; k++){
            if(k != i){
              for(int l = 0; l < a.length; l++){
                if(l != 0){
                  aDet[x][y] = a[l][k];
                  x++;
                }
              }
              x = 0;
              y++;
            }
          }
            if(plus){
              result = Math.floorMod(result + Math.floorMod((Math.floorMod(a[0][i], m) * cofModDet(m, aDet)), m), m);
              plus = false;
            } else {
              result = Math.floorMod(result - Math.floorMod((Math.floorMod(a[0][i], m) * cofModDet(m, aDet)), m), m);
              plus = true;
            }
      }
      return result;
    }

}
