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

  public static long[] euclidAlgExt(long a, long b) {
      long remainder = -1;
      long q = 0;
      long x = 0;
      long y = 1;
      long x1 = 1
      long y1 = 0;
      long saveA = a;
      long saveB = b;
      //the steps arraylist will store the values from each step in the process, so that we can work back up to the x and y values in part b
      ArrayList<Long[]> steps = new ArrayList<Long[]>();
      Long step[] = new Long[4];
      long result[] = new long[3];
      if(a < b){
        long temp = a;
        a = b;
        b = temp;
      }
      do{
        remainder = a % b;
        if(remainder != 0){
          q = a / b;
          a = b;
          b = remainder;
          x += x - q * x;
          y += y - q * y;
          //step[0] = a; //our divisor
          //step[1] = b; //our quotient
          //step[2] = a / b; // our potential divisor
          //step[3] = remainder; // our remainder

          steps.add(step);
        } else {
          q = b;
        }
      }while(remainder != 0);
      ArrayList<Long> backwardsSteps = new ArrayList<Long>(); //Probably not the best way to do this but I need something that works
      /* we need to find x and y such that ax + by = q
        So work backwards. d = q - m * d
        Where d is our gcd, q is our quotient from the last step, m is our multiplier and d is our divisor
        So we use the value of r from each step, and find any vars that match that value
        We then substitute their values for q - m * d from the step above
        Finally, we just have to simplify the array list down until it's in terms of x * a + y * break;


      */
      //while(a * x + b * y != q){

    //  }
      //System.out.println(u);
    //  System.out.println(v);
      result[0] = b;
      result[1] = x;
      result[2] = y;
    return result;

  }



}
