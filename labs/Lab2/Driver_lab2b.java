import java.util.Stack;
import java.util.Scanner;

public class Driver_lab2b{

  public static void main(String args[]){
    Scanner in = new Scanner(System.in);
    while(in.hasNext()){
      long a = in.nextInt();
      long b = in.nextInt();
      if(a < b){
        long temp = a;
        a = b;
        b = temp;
      }
      System.out.println(euclidAlgExt(a, b));
    }
  }

  public static long euclidAlgExt(long a, long b) {
      Stack<Long> qs = new Stack<Long>();    //qs is stack of quotients
      Stack<Long> ms = new Stack<Long>();    //ms is stack of multipliers (What number we multiply previous remainder by)
      Stack<Long> ds = new Stack<Long>();    //ds is stack of (potential) divisors
      Stack<Long> rs = new Stack<Long>();    //rs is stack of remainders
      long remainder = -1;
      long aSave = a;
      long bSave = b;
      long u = 0;
      long v = 0;
      do{
        remainder = a % b;
        if(remainder != 0){
          rs.push(remainder);
          qs.push(a);
          ms.push(a / b);
          ds.push(b);
          a = b;
          b = remainder;
        }
      }while(remainder != 0);
      //We don't care about the last line of the equation, we need to start at line n-1
        System.out.println("rs.peek(): " + rs.peek());
        System.out.println("qs.peek(): " + qs.peek());
        System.out.println("ds.peek(): " + ds.peek());
      //declare the vars that we will substitute to find our final u v
      long q = qs.peek();
      long m = ms.peek();
      long d = ds.peek();
      long r = 0;
      while(!qs.empty() && !ms.empty() && !ds.empty() && !rs.empty()){
          r = rs.pop();
            System.out.println("r: " + r);
            System.out.println("q: " + q);
            System.out.println("d: " + d);
          if(d == r){
            d = qs.pop() - ds.pop() * ms.pop();
            System.out.println("new d: " + d);
          } else if(q == r){
            q = qs.pop() - ds.pop() * ms.pop();
            System.out.println("new q: " + q);
          }
      }
      u = d;
      v = q;
      System.out.println(u);
      System.out.println(v);

    return remainder;

  }



}
