import java.util.Scanner;

public class Driver_lab2a{
  public static void main(String [] args){
    Scanner in = new Scanner(System.in);
    while(in.hasNext()){
      long a = in.nextInt();
      long b = in.nextInt();
      euclidAlg(a, b);
    }
  }
  public static long euclidAlg(long a, long b){
    // a should always be greater than b, but just in case
    if(a < b){
      long temp = a;
      a = b;
      b = temp;
    }
    long remainder;
    long quotient = 1;
    do{
      remainder = a % b;
    }while(remainder != 0);

  }



}
