import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

     public static void main(String[] args) {
          Scanner in = new Scanner(System.in);
          int a;
          a = in.nextInt();
          int b;
          b = in.nextInt();
          int result;
          result = sub(a, b);
          System.out.println(result);
     }

     
     public static int sub(int a, int b) {
          return a-b;
     }

}