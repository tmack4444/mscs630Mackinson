import java.util.Scanner;
import java.util.ArrayList;

public class Driver_lab2b{

  public static void main(String args[]){
    Scanner in = new Scanner(System.in);
    while(in.hasNext()){
      long a = in.nextInt();
      long b = in.nextInt();
      long[] result = euclidAlgExt(a, b);
      System.out.println(result[0]);
      System.out.println(result[1]);
      System.out.println(result[2]);
    }
  }
  /*
   * Ok, I took a ton of time to get here but just to be sure I don't forget...
   * So, this works by calculating our x and y as we calculate the gcd
   * Instead of calculating the GCD and working backwards, I'm working backwards forwards
   * That probably doesn't make any sense, but basically rather than use the remainders, quotients
   * and other values we generate to work backwards to create our x and y, I Instead
   * use those values as we generate the GCD. We end up at the same result, and it doesn't
   * require me to do anything confusing, like create a string of all the vars and then somehow
   * turn that string into a formula with the values parsed in... That's where I was going before this
   */
  public static long[] euclidAlgExt(long a, long b) {
      long remainder = -1;
      long temp = 0;
      long q = 0;
      long x = 0;
      long y = 1;
      long x1 = 1;
      long y1 = 0;
      long saveA = a;
      long saveB = b;
      long result[] = new long[3];
      if(a < b){
        temp = a;
        a = b;
        b = temp;
      }
      do{
        remainder = a % b;
        if(remainder != 0){
          q = a / b;
          a = b;
          b = remainder;

          temp = x;
          x = x1 - q * x;
          x1 = temp;

          temp = y;
          y = y1 - q * y;
          y1 = temp;

        } else {
          q = b;
        }
      }while(remainder != 0);
      result[0] = b;
      result[1] = x;
      result[2] = y;
    return result;

  }



}
