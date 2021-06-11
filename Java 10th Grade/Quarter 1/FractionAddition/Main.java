import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    //Get first Fraction from user in Fraction Form
    //Save as strings
    Scanner myScan = new Scanner(System.in);
    System.out.println("Please input 2 fractions comprized of positive integers");
    System.out.println("Input fractions with fractional bar (Example 6/7):");
    String rawFrac1 = myScan.next();
    String rawFrac2 = myScan.next();
    //----------------------------------------------------------------------------
    //Split Raw fractions at fraction bar
    //define temporary storage
    String[] temp1;
    //Define what character needs to be split and removed
    String delimiter = "/";
    //Split fraction
    temp1 = rawFrac1.split(delimiter);  
    //Save 2 halves to numerator and denomenator 
    String strNum1 = temp1[0];
    String strDem1 = temp1[1];

    //Split Second Raw Fraction
    String[] temp2;
    temp2 = rawFrac2.split(delimiter);
    //Save 2 halves to numerator and denomenator
    String strNum2 = temp2[0];
    String strDem2 = temp2[1];
    //----------------------------------------------------------------------------
    //Convert all strings to integers
    int intNum1 = Integer.parseInt(strNum1);
    int intDem1 = Integer.parseInt(strDem1);
    int intNum2 = Integer.parseInt(strNum2);
    int intDem2 = Integer.parseInt(strDem2);
    //----------------------------------------------------------------------------
    //Test if the denominators are equall before adding numerators
    int lcmDem = 0;
    int multiNum1 = 0;
    int multiNum2 = 0;
    if(intDem1 == intDem2){
      //save one of the denominators as final for adding; LCM
      lcmDem = intDem1;
      multiNum1 = intNum1;
      multiNum2 = intNum2;
    } else {
      //find the LCM of both denominators
      //--------------------------------------------------------------------------
      int tempDem1 = intDem1;
      int tempDem2 = intDem2;
      // Define remainder as mod of 2 numbers
      int r = (tempDem1 % tempDem2);
      int gcf = 0;
      //test if r is equal to 0 if it is tell user that tempDem2 is GCF
      // save tempDem2 as GCF
      if(r == 0) {
        gcf = tempDem2;
        lcmDem = ((intDem1 * intDem2) / gcf);
        //if remainder is not zero shift numbers
        //shift num to as to te divident
        //shift remainder to divisor
        //do the divison and repeat unill remainder = 0
      } else {
        while(r > 0){
          tempDem1 = tempDem2;
          tempDem2 = r;
          r = (tempDem1 % tempDem2);
          if(r == 0) {
            gcf = tempDem2;
            //get lcm by multiplying both input numbers and divide by gcf
            lcmDem = ((intDem1 * intDem2) / gcf);
          }
        }
      }
      //-------------------------------------------------------------------------------------
      //Divide both intDem by lcmDem to find what to multiply numerators by
      int multi1 = (lcmDem / intDem1);
      int multi2 = (lcmDem / intDem2);
      //Multiply numerators by numbers from last step
      multiNum1 = (intNum1 * multi1);
      multiNum2 = (intNum2 * multi2);
    }
    //Add multiNum1 and multiNum2 together
    int ansNum = (multiNum1 + multiNum2);
    
    //Find GCF of ansNum and lcmDem
    //---------------------------------------------------------------------------------------
    int tempansNum = ansNum;
    int templcmDem = lcmDem;
    // Define remainder as mod of 2 numbers
    int r = (tempansNum % templcmDem);
    int gcFinal = 0;
    //test if r is equal to 0 if it is tell user that templcmDem is GCF
    // save templcmDem as GCF
    if(r == 0) {
      gcFinal = templcmDem;
      //if remainder is not zero shift numbers
      //shift num to as to te divident
      //shift remainder to divisor
      //do the divison and repeat unill remainder = 0
    } else {
      while(r > 0){
        tempansNum = templcmDem;
        templcmDem = r;
          r = (tempansNum % templcmDem);
          if(r == 0) {
            gcFinal = templcmDem;
          }
        }
      }
    //---------------------------------------------------------------------------------------
    //Divide ansNum and lcmDem by gcFinal to get simplified fraction
    int numFinal = (ansNum / gcFinal);
    int demFinal = (lcmDem / gcFinal);
    //Give output to user
    System.out.println(numFinal + "/" + demFinal);
  }
}
