import java.util.Scanner;
import java.util.ArrayList;
/**
 * A number converter, allows user to convert numbers between
 * base 10, base 2, base 8, and base 16.
 * Project AuburnHacks -- Backup Project
 * @author Yuantai Pan
 * @version 1.00 Feb 9 2020
 */
 public class numberConverter1 {
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      String inputNumber = "";
      int initialBase = 0;
      int convertedBase = 0;
      System.out.println("Number Converter v1.24\n\nPlease enter the initial value which" 
         + "\nhas to be greater than zero," + "\ncannot include decimals," + "\nand letters for base16 has to be capitalized:");
      inputNumber = scan.nextLine();
      System.out.println("Enter the initial base:");
      initialBase = scan.nextInt();
      System.out.println("Enter the base to convert to:");
      convertedBase = scan.nextInt();
      numberConverter2 number = new numberConverter2(inputNumber, initialBase, convertedBase);
      System.out.println("The number conversion from base" + initialBase
          + " to base" + convertedBase + " is " + number.convert() +".");
   }
 }