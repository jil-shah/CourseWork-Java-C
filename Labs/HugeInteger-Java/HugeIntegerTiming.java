import java.math.BigInteger;
import java.util.Arrays;

public class HugeIntegerTiming {
  public static void main (String[] args) {
    HugeInteger huge1,huge2,huge3;
    BigInteger n1,n2,n3;
    long Ti,Tf;
    double runTime = 0.0;
    int maxNumInt = 500; 
    int maxRunTime = 500;
    int n=10;
    
    for (int numInts=0; numInts<maxNumInt; numInts++) {
      huge1 = new HugeInteger(n);
      huge2 = new HugeInteger(n);
      //n1 = new BigInteger(huge1.toString());
      //n2 = new BigInteger(huge2.toString());
      Ti = System.currentTimeMillis();
      for (int j=0; j<maxRunTime;j++) {
        huge3 = huge1.multiply(huge1);
      }
      Tf = System.currentTimeMillis();
      runTime += (double)(Tf-Ti)/((double)maxRunTime);
      
    }
    runTime = runTime/((double)maxNumInt);
    System.out.println(runTime);
  }
}
