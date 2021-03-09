

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

  public static long[] euclidAlgExt(long a, long b) {
      long remainder = -1;
      long rLast;
      long aSave = a;
      long bSave = b;
      long d = 1;
      do{
        rLast = remainder;
        remainder = a % b;
        if(remainder == 0){
          d = b;
        } else {
          a = b;
          b = remainder;
        }
      }while(remainder != 0);

    while(aSave * remainder + bSave * rLast){

    }

    return [d, rLast, remainder];

  }



}
