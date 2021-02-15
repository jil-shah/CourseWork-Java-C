import java.math.BigInteger;
import java.util.Arrays;

public class HugeIntegerTiming {
  public static void main (String[] args) {
    HugeInteger huge1,huge2,huge3;
    BigInteger n1,n2,n3;
    long Ti,Tf;
    double runTime = 0.0;
    int maxNumInt = 4500, maxRunTime = 500,compare;
    int n=50;

    for (int numInts=0; numInts<maxNumInt; numInts++) {
      huge1 = new HugeInteger(n);
      huge2 = new HugeInteger(n);
      n1 = new BigInteger(huge1.toString());
      n2 = new BigInteger(huge2.toString());
      Ti = System.currentTimeMillis();
      for (int j=0; j<maxRunTime;j++) {
        n3 = n1.add(n2);
      }
      Tf = System.currentTimeMillis();
      runTime += (double)(Tf-Ti)/((double)maxRunTime);    
    }
    runTime = runTime/((double)maxNumInt);
    System.out.println("The run time for HugeInteger class for Add is "+runTime);   // ------------- Huge Integer add 
    
    runTime = 0.0;
    for (int numInts=0; numInts<maxNumInt; numInts++) {
      huge1 = new HugeInteger(n);
      huge2 = new HugeInteger(n);
      n1 = new BigInteger(huge1.toString());
      n2 = new BigInteger(huge2.toString());
      Ti = System.currentTimeMillis();
      for (int j=0; j<maxRunTime;j++) {
        n3 = n1.add(n2);
      }
      Tf = System.currentTimeMillis();
      runTime += (double)(Tf-Ti)/((double)maxRunTime);    
    }
    runTime = runTime/((double)maxNumInt);
    System.out.println("The run time of the BigInteger class for Add is "+runTime); // ------------------ BigInteger add
    
    runTime = 0.0;
    for (int numInts=0; numInts<maxNumInt; numInts++) {
      huge1 = new HugeInteger(n);
      huge2 = new HugeInteger(n);
      n1 = new BigInteger(huge1.toString());
      n2 = new BigInteger(huge2.toString());
      Ti = System.currentTimeMillis();
      for (int j=0; j<maxRunTime;j++) {
        n3 = n1.subtract(n2);
      }
      Tf = System.currentTimeMillis();
      runTime += (double)(Tf-Ti)/((double)maxRunTime);    
    }
    runTime = runTime/((double)maxNumInt);
    System.out.println("The run time for HugeInteger class for Subtract is "+runTime);   // ------------- Huge Integer Subtract 
    
    runTime = 0.0;
    for (int numInts=0; numInts<maxNumInt; numInts++) {
      huge1 = new HugeInteger(n);
      huge2 = new HugeInteger(n);
      n1 = new BigInteger(huge1.toString());
      n2 = new BigInteger(huge2.toString());
      Ti = System.currentTimeMillis();
      for (int j=0; j<maxRunTime;j++) {
        n3 = n1.subtract(n2);
      }
      Tf = System.currentTimeMillis();
      runTime += (double)(Tf-Ti)/((double)maxRunTime);    
    }
    runTime = runTime/((double)maxNumInt);
    System.out.println("The run time of the BigInteger class for Subtract is "+runTime); // ------------------ BigInteger Subtract

    runTime = 0.0;
    for (int numInts=0; numInts<maxNumInt; numInts++) {
      huge1 = new HugeInteger(n);
      huge2 = new HugeInteger(n);
      n1 = new BigInteger(huge1.toString());
      n2 = new BigInteger(huge2.toString());
      Ti = System.currentTimeMillis();
      for (int j=0; j<maxRunTime;j++) {
        n3 = n1.multiply(n2);
      }
      Tf = System.currentTimeMillis();
      runTime += (double)(Tf-Ti)/((double)maxRunTime);    
    }
    runTime = runTime/((double)maxNumInt);
    System.out.println("The run time for HugeInteger class for Multiply is "+runTime);   // ------------- Huge Integer multiply 
    
    runTime = 0.0;
    for (int numInts=0; numInts<maxNumInt; numInts++) {
      huge1 = new HugeInteger(n);
      huge2 = new HugeInteger(n);
      n1 = new BigInteger(huge1.toString());
      n2 = new BigInteger(huge2.toString());
      Ti = System.currentTimeMillis();
      for (int j=0; j<maxRunTime;j++) {
        n3 = n1.multiply(n2);
      }
      Tf = System.currentTimeMillis();
      runTime += (double)(Tf-Ti)/((double)maxRunTime);    
    }
    runTime = runTime/((double)maxNumInt);
    System.out.println("The run time of the BigInteger class for Multiply is "+runTime); // ------------------ BigInteger multiply
    runTime = 0.0;

    for (int numInts = 0; numInts < maxNumInt; numInts++) {
      huge1 = new HugeInteger(n);
      huge2 = new HugeInteger(n);
      Ti = System.currentTimeMillis();
      for (int j = 0; j < maxRunTime; j++) {
    	compare = huge1.compareTo(huge2);
      }
      Tf = System.currentTimeMillis();
      runTime += (double) (Tf - Ti) / ((double) maxRunTime);
    }
    runTime = runTime/((double)maxNumInt);
    System.out.println("The run time for HugeInteger class for Compare is "+runTime);   // ------------------ Huge Integer compare To
    runTime = 0.0;
    for (int numInts=0; numInts<maxNumInt; numInts++) {
      huge1 = new HugeInteger(n);
      huge2 = new HugeInteger(n);
      n1 = new BigInteger(huge1.toString());
      n2 = new BigInteger(huge2.toString());
      Ti = System.currentTimeMillis();
      for (int j=0; j<maxRunTime;j++) {
        compare = n1.compareTo(n2);
      }
      Tf = System.currentTimeMillis();
        runTime += (double)(Tf-Ti)/((double)maxRunTime);    
      }
    runTime = runTime/((double)maxNumInt);
    System.out.println("The run time of the BigInteger class for Compare is "+runTime); // ------------------ BigInteger compare To
  }
}
