import java.util.Scanner;
import java.util.ArrayList;
/**
 * A number converter, allows user to convert numbers between
 * base 10, base 2, base 8, and base 16.
 * Project AuburnHacks -- Backup Project
 * @author Yuantai Pan
 * @version 1.00 Feb 9 2020
 */
 public class numberConverter2 {
   private String inputNumber;
   private int initialBase;
   private int convertedBase;
   private int result;
   public ArrayList<String> valueIn;
   public ArrayList<String> valueOut;
   public numberConverter2(String inputNumberIn, int initialBaseIn, int convertedBaseIn) {
      valueIn = new ArrayList<String>(0);
      valueOut = new ArrayList<String>(0);
      inputNumber = inputNumberIn;
      for (int i = 0; i < inputNumber.length(); i++) {
         valueIn.add(0, String.valueOf(inputNumber.charAt(i)));
      }
      initialBase = initialBaseIn;
      convertedBase = convertedBaseIn;
   }
   public String getNumber() {
      return inputNumber;
   }
   public int getIniBase() {
      return initialBase;
   }
   public int getConvertedBase() {
      return convertedBase;
   }
   public String convert() {
      if (initialBase == 10) {
         switch (convertedBase) {
            case 10:
               return inputNumber;
            case 2:
               return convert10to2(inputNumber);
            case 8:
               String modified = convert10to2(inputNumber);
               valueIn.clear();
               for (int i = 0; i < modified.length(); i++) {
                  valueIn.add(0, String.valueOf(modified.charAt(i)));
               }
               return convert2to8(modified);
            case 16:
               String modified2 = convert10to2(inputNumber);
               valueIn.clear();
               for (int i = 0; i < modified2.length(); i++) {
                  valueIn.add(0, String.valueOf(modified2.charAt(i)));
               }
               return convert2to16(modified2);
         }
      }
      else if (initialBase == 2) {
         switch (convertedBase) {
            case 10:
               return convert2to10(inputNumber);
            case 2:
               return inputNumber;
            case 8:
               return convert2to8(inputNumber);
            case 16:
               return convert2to16(inputNumber);
         }
      }
      else if (initialBase == 8) {
         switch (convertedBase) {
            case 10:
               String modified = convert8to2(inputNumber);
               valueIn.clear();
               for (int i = 0; i < modified.length(); i++) {
                  valueIn.add(0, String.valueOf(modified.charAt(i)));
               }
               return convert2to10(modified);
            case 2:
               return convert8to2(inputNumber);
            case 8:
               return inputNumber;
            case 16:
               String modified2 = convert8to2(inputNumber);
               valueIn.clear();
               for (int i = 0; i < modified2.length(); i++) {
                  valueIn.add(0, String.valueOf(modified2.charAt(i)));
               }
               return convert2to16(modified2);
         }
      }
      else if (initialBase == 16) {
         switch (convertedBase) {
            case 10:
               String modified = convert16to2(inputNumber);
               valueIn.clear();
               for (int i = 0; i < modified.length(); i++) {
                  valueIn.add(0, String.valueOf(modified.charAt(i)));
               }
               return convert2to10(modified);
            case 2:
               return convert16to2(inputNumber);
            case 8:
               String modified2 = convert16to2(inputNumber);
               valueIn.clear();
               for (int i = 0; i < modified2.length(); i++) {
                  valueIn.add(0, String.valueOf(modified2.charAt(i)));
               }
               return convert2to8(modified2);
            case 16:
               return inputNumber;
         }
      }
      return null;
   }
   private String convert2to10(String input) {
      if (input.equals("0")) {
         return "0";
      }
      int result = 0;
      for (int i = 0; i < valueIn.size(); i++) {
         result += Integer.parseInt(valueIn.get(i)) * Math.pow(2, i);
      }
      return String.valueOf(result);
   }
   private String convert2to16(String input) {
      if (input.equals("0")) {
         return "0";
      }
      valueOut.clear();
      while (valueIn.size()%4 != 0) {
         valueIn.add("0");
      }
      String result = "";
      int size = valueIn.size()/4;
      for (int i = 0; i < size; i++) {
         int value = 0;
         for (int j = 0; j < 4; j++) {
            value += Integer.parseInt(valueIn.get(j)) * Math.pow(2, j);
         }
         for (int l = 0; l < 4; l++) {
            valueIn.remove(0);
         }
         switch (value) {
            case 10:
               valueOut.add(0,"A");
               break;
            case 11:
               valueOut.add(0,"B");
               break;
            case 12:
               valueOut.add(0,"C");
               break;
            case 13:
               valueOut.add(0,"D");
               break;
            case 14:
               valueOut.add(0,"E");
               break;
            case 15:
               valueOut.add(0,"F");
               break;
            default:
               valueOut.add(0, String.valueOf(value));
         }
      }
      for (int k = 0; k < valueOut.size(); k++) {
         result += valueOut.get(k);
      }
      return result;
   }
   private String convert2to8(String input) {
      if (input.equals("0")) {
         return "0";
      }
      valueOut.clear();
      while (valueIn.size() % 3 != 0) {
         valueIn.add("0");
      }
      int size = valueIn.size();
      for (int i = 0; i < size / 3; i++) {
         int value = 0;
         for (int j = 0; j < 3; j++) {
            value += Integer.parseInt(valueIn.get(j)) * Math.pow(2, j);
         }
         for (int l = 0; l < 3; l++) {
            valueIn.remove(0);
         }
         valueOut.add(0, String.valueOf(value));
      }
      String result = "";
      for (int k = 0; k < valueOut.size(); k++) {
         result += valueOut.get(k);
      }
      return result;
   }
   private String convert10to2(String input) {
      if (input.equals("0")) {
         return "0";
      }
      if (input.equals("0")) {
         return "0";
      }
      valueOut.clear();
      int value = Integer.parseInt(input);
      while (value / 2 != 0 || value % 2 != 0) {
         valueOut.add(0, String.valueOf(value % 2));
         value /= 2;
      }
      String result = "";
      for (int i = 0; i < valueOut.size(); i++) {
         result += valueOut.get(i);
      }
      while (result.charAt(0) == '0') {
         result = result.substring(1);
      }
      return result;
   }
   private String convert16to2(String input) {
      if (input.equals("0")) {
         return "0";
      }
      if (input.equals("0")) {
         return "0";
      }
      valueOut.clear();
      String result = "";
      for (int i = 0; i < input.length(); i++) {
         String value = String.valueOf(input.charAt(i));
         switch (value) {
            case "A":
               value = "10";
               break;
            case "B":
               value = "11";
               break;
            case "C":
               value = "12";
               break;
            case "D":
               value = "13";
               break;
            case "E":
               value = "14";
               break;
            case "F":
               value = "15";
               break;
         }
         result += convert10to2(value);
      }
      while (result.charAt(0) == '0') {
         result = result.substring(1);
      }
      return result;
   }
   private String convert8to2(String input) {
      if (input.equals("0")) {
         return "0";
      }
      if (input.equals("0")) {
         return "0";
      }
      valueOut.clear();
      String result = "";
      for (int i = 0; i < input.length(); i++) {
         String value = String.valueOf(input.charAt(i));
         int value2 = Integer.parseInt(value);
         valueOut.clear();
         while (value2 / 2 != 0 || value2 % 2 != 0) {
            valueOut.add(0, String.valueOf(value2 % 2));
            value2 /= 2;
         }
         String result2 = "";
         for (int j = 0; j < valueOut.size(); j++) {
            result2 += valueOut.get(j);
         }
         while (result2.length() < 3) {
            result2 = "0" + result2;
         }
         result += result2;
      }
      while (result.charAt(0) == '0') {
         result = result.substring(1);
      }
      return result;
   }
}
