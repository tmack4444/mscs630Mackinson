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
      return a[0][0];
    }
    if(a.length == 2){
      return (a[0][0] * a[1][1]) - (a[0][1] * a[1][0]);
    }
    int result = 1;
    for(int i = 0; i < a.length; i++){
      for(int j = 0; j < a[i].length; j++){
        result *= a[i][j] * cofModDet(m, recDet);
      }
    }

    return 0;
  }

}
