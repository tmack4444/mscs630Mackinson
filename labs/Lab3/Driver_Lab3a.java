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

    return 0;
  }

}
