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
      System.out.println(a[0][0] + " " + a[0][1]);
      System.out.println(a[1][0] + " " + a[1][1]);
      System.out.println();
      int A = Math.floorMod(a[0][0], m);
      int B = Math.floorMod(a[0][1], m);
      int C = Math.floorMod(a[1][0], m);
      int D = Math.floorMod(a[1][1], m);
      int ad = Math.floorMod(A * D, m);
      int bc = Math.floorMod(B * C, m);
      System.out.println("m: " + m);
      System.out.println("A: " + A);
      System.out.println("B: " + B);
      System.out.println("C: " + C);
      System.out.println("D: " + D);
      System.out.println("ad: " + ad);
      System.out.println("bc: " + bc);
      System.out.println(Math.floorMod((ad - bc), m) );
      System.out.println();
      return Math.floorMod((ad - bc), m);
    }
    int result = 1;
    boolean plus = true;        // keep track of if we are adding or subtracting our determinant
    for(int i = 0; i < a.length; i++){
          int[][] aDet = new int[a.length-1][a.length-1];
          int x = 0;
          int y = 0;
          for(int k = 0; k < a.length; k++){
            //System.out.println("y: " + x);
            if(k != i){

              for(int l = 0; l < a.length; l++){
                //System.out.println("x: " + x);
                if(l != 0){
                  //System.out.print(a[k][l] + " ");
                  aDet[x][y] = a[l][k];
                  x++;
                }

              }
              //System.out.println();
              x = 0;
              y++;
            }
          }
          //System.out.println();


            if(plus){
              result += Math.floorMod(a[i][0], m) * cofModDet(m, aDet);
              plus = false;
            } else {
              result -= Math.floorMod(a[i][0], m) * cofModDet(m, aDet);
              plus = true;
            }
      }
      return Math.floorMod(result,m);
    }

}
