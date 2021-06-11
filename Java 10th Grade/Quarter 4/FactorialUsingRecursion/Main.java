import java.util.*;
import java.lang.*; 
import java.io.*;

public class Main {
  public static void main(String[] args) {
		Scanner scan1 = new Scanner(System.in);

		System.out.println("type a number");
		int result = scan1.nextInt();
    long results = sum(result);
    System.out.println(results);
  }
  public static long sum(int k) {
    if (k > 0) {
      return k * sum(k - 1);
    } else {
      return 1;
    }
  }
}