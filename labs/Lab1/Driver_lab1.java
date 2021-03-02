import java.util.Scanner;

public class Driver_lab1{

  public static void main(String [] args){
    Scanner in = new Scanner(System.in);

    String s = in.nextLine();
    System.out.println(s);
    str2int(s);
  }

  public static int[] str2int(String plainText){
    int[] eTxt = new int[plainText.length()];
    String charMappings = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ";
    for(int i = 0; i < plainText.length(); i++){
      eTxt[i] = charMappings.indexOf(plainText.toUpperCase().charAt(i));
      System.out.print(eTxt[i] + " ");
    }
    return eTxt;
  }
}
