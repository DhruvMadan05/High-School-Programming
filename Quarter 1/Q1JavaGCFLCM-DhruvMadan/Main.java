import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    //Get 2 positive integer from users
    Scanner myScan = new Scanner(System.in);
    System.out.println("Please input 2 positive integers:");
    int num1 = myScan.nextInt();
    int num2 = myScan.nextInt();
    //Save thse inputs for later
    int a = num1;
    int b = num2;
    // Define remainder as mod of 2 numbers

    int r = (num1 % num2);
    int gcf = 0;
    //test if r is equal to 0 if it is tell user that num2 is GCF
    // save num 2 as GCF
    if(r == 0) {
      gcf = num2;
      System.out.println("The GCF of " + num1 + " and " + num2 + " is " + gcf);
      //if remainder is not zero shift numbers
      //shift num to as to te divident
      //shift remainder to divisor
      //do the diviion and repeat unill remainder = 0
    } else {
      while(r > 0){
        num1 = num2;
        num2 = r;
        r = (num1 % num2);
        if(r == 0) {
          gcf = num2;
          //tell user the output
          System.out.println("The GCF of " + num1 + " and " + num2 + " is " + gcf);
        }
      }
    }
    //get lcm by multiplying both input numbers and divide by gcf
    //tell user output
    int lcm = ((a * b) / gcf);
    System.out.println("The LCM of " + num1 + " and " + num2 + " is " + lcm);
  }
} 