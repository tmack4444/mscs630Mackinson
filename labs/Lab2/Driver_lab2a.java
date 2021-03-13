import java.util.Scanner;

class Driver_lab2a{
  public static void main(String [] args){
    String output = "";
    Scanner in = new Scanner(System.in);
    while(in.hasNext()){
      long a = in.nextLong();
      long b = in.nextLong();
      if(a < b){
        long temp = a;
        a = b;
        b = temp;
      }
      output += euclidAlg(a, b) + "\n";
    }
    output = output.trim();
    System.out.print(output);
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
