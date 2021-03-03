import java.util.Scanner;

public class Driver_lab1{

  public static void main(String [] args){
    Scanner in = new Scanner(System.in);
    String ans = "";
    while(in.hasNext()){
      String s = in.nextLine();
      str2int(s);
      //Since we don't want an extra line after the last input, check to see if done before adding a line
      if (in.hasNext()){
        System.out.println();
      }

    }
  }

  public static int[] str2int(String plainText){
    int[] eTxt = new int[plainText.length()];
    String charMappings = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ";
    String ans = "";
    for(int i = 0; i < plainText.length(); i++){
      eTxt[i] = charMappings.indexOf(plainText.toUpperCase().charAt(i));
      ans += (eTxt[i] + " ");
    }
    System.out.print(ans.trim());
    return eTxt;
  }
}
