import java.util.Scanner;

class Driver_Lab2a{
  public static void main(String [] args){
    Scanner in = new Scanner(System.in);
    while(in.hasNext()){
      long a = in.nextInt();
      long b = in.nextInt();
      if(a < b){
        long temp = a;
        a = b;
        b = temp;
      }
      System.out.println(euclidAlg(a, b));
    }
  }

  public static long euclidAlg(long a, long b){
    // a should always be greater than b, but just in case
    long remainder;
    long quotient = 1;
    do{
      remainder = a % b;
      if(remainder == 0){
        return b;
      } else {
        a = b;
        b = remainder;
      }
    }while(remainder != 0);
  return b;
  }



}
