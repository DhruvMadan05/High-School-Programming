import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    // ask for a positive integer
    // save this number
    Scanner myScan = new Scanner(System.in);

    System.out.println("Enter a positive integer");

    int num = myScan.nextInt();

    // assume the number is prime

    boolean isPrime = true;

    //starting with 2 look for a factor of the given number

    for(int i = 2; i < (num / 2); i++) {
      if(num % i == 0){
        isPrime = false;
        System.out.println(num + " is not prime.");
        System.out.println(num + " = " + (num / i) + " * " + i);
        break;
      }
    }

    // if the is prime is true
    // tell user that the number is prime

    if(isPrime == true) {
      System.out.println( num + " is Prime");
    }

  }
}
