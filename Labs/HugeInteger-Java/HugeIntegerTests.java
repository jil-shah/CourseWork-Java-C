import java.math.BigInteger;
public class HugeIntegerTests{
  public static void main (String []args) {
	HugeInteger n1,n2,n3;
	BigInteger y1,y2,y3;
	int correctAns = 0;
	int failedTests = 0;
	String str1;
	String str2;
	boolean flag=true;
	//many tests for constructors -------------------------------
	try {
	  n1 = new HugeInteger("3974932-34839");
	}catch(Exception e){
	  correctAns++;
	}
	try {
	  n1 = new HugeInteger("397493234sda839");
	}catch(Exception e){
	  correctAns++;
	}
	try {
      n1 = new HugeInteger(":397493234839");
	}catch(Exception e){
	  correctAns++;
	}
	try {
	  n1 = new HugeInteger("100");
	  correctAns++;
	}catch(Exception e){
	  System.out.println(e);
	  failedTests++;
	}
	try {
	  n1 = new HugeInteger("-293210390491100");
	  correctAns++;
	}catch(Exception e){
	  System.out.println(e);
	  failedTests++;
	}
	try {
	  n1 = new HugeInteger("null");
	  failedTests++;
	}catch(Exception e){
	  correctAns++;
	}

	if (failedTests!=0) {
      System.out.println("Constructor Test Cases Failed "+failedTests+"/6");
	}
    else {
      System.out.println("Constructor Test Cases Passed "+correctAns+"/6");
	}
	
	correctAns=0; failedTests =0;
	//many tests completed for addition ---------------------------------
	//two positive integers (num1 == num2)
	try {
	  n1 = new HugeInteger("53432454359340");
	  n2 = new HugeInteger("12000248234324");
	  n3 = n1.add(n2); 
	  y1 = new BigInteger(n1.toString());
	  y2 = new BigInteger(n2.toString());
	  y3 = y1.add(y2);
	  str1 = n3.toString();
	  str2 = y3.toString();
	  for (int i=0; i<str1.length();i++) {
		if ((int)str1.charAt(i)!=(int)str2.charAt(i)) {
		  flag = false;
		  break;
		}
	  }
	  if (flag) {correctAns ++;}
	  else {failedTests++;}
	}
	catch(Exception e){
	  System.out.println(e);
	  failedTests++;
	}
	//one positive integers (num1 = 0)
	try {
	  n1 = new HugeInteger("0");
	  n2 = new HugeInteger("500");
	  n3 = n1.add(n2);	
	  y1 = new BigInteger(n1.toString());
	  y2 = new BigInteger(n2.toString());
	  y3 = y1.add(y2);
	  str1 = n3.toString();
	  str2 = y3.toString();
	  for (int i=0; i<str1.length();i++) {
		if ((int)str1.charAt(i)!=(int)str2.charAt(i)) {
		  flag = false;
		  break;
		}
	  }
	  if (flag) {correctAns ++;}
	  else {failedTests++;}
	}
	catch(Exception e){
	  System.out.println(e);
	  failedTests++;
	}
    //two positive integers (num2 = 0)
	try {
	  n1 = new HugeInteger("999");
	  n2 = new HugeInteger("0");
	  n3 = n1.add(n2);	
	  y1 = new BigInteger(n1.toString());
	  y2 = new BigInteger(n2.toString());
	  y3 = y1.add(y2);
	  str1 = n3.toString();
	  str2 = y3.toString();
	  for (int i=0; i<str1.length();i++) {
		if ((int)str1.charAt(i)!=(int)str2.charAt(i)) {
		  flag = false;
		  break;
		}
	  }
	  if (flag) {correctAns ++;}
	  else {failedTests++;}
	}catch(Exception e){
	  System.out.println(e);
	  failedTests++;
	}
	//two positive integers (num1 > num2)
	try {
	  n1 = new HugeInteger("1000");
	  n2 = new HugeInteger("999");
	  n3 = n1.add(n2);	
	  y1 = new BigInteger(n1.toString());
	  y2 = new BigInteger(n2.toString());
	  y3 = y1.add(y2);
	  str1 = n3.toString();
	  str2 = y3.toString();
	  for (int i=0; i<str1.length();i++) {
		if ((int)str1.charAt(i)!=(int)str2.charAt(i)) {
		  flag = false;
		  break;
		}
	  }
	  if (flag) {correctAns ++;}
	  else {failedTests++;}
	}
	catch(Exception e){
	  System.out.println(e);
	  failedTests++;
	}
	//two positive integers (num1 < num2)
	try {
	  n1 = new HugeInteger("999");
	  n2 = new HugeInteger("1200");
	  n3 = n1.add(n2);	
	  y1 = new BigInteger(n1.toString());
	  y2 = new BigInteger(n2.toString());
	  y3 = y1.add(y2);
	  str1 = n3.toString();
	  str2 = y3.toString();
	  for (int i=0; i<str1.length();i++) {
		if ((int)str1.charAt(i)!=(int)str2.charAt(i)) {
		  flag = false;
		  break;
		}
	  }
	  if (flag) {correctAns ++;}
	  else {failedTests++;}
	}
	catch(Exception e){
	  System.out.println(e);
	  failedTests++;
	}
	//opposite signed integers (-num1 = num2)
	try {
	  n1 = new HugeInteger("-555");
	  n2 = new HugeInteger("555");
	  n3 = n1.add(n2);	
	  y1 = new BigInteger(n1.toString());
	  y2 = new BigInteger(n2.toString());
	  y3 = y1.add(y2);
	  str1 = n3.toString();
	  str2 = y3.toString();
	  for (int i=0; i<str1.length();i++) {
		if ((int)str1.charAt(i)!=(int)str2.charAt(i)) {
		  flag = false;
		  break;
		}
	  }
	  if (flag) {correctAns ++;}
	  else {failedTests++;}
	}
	catch(Exception e){
	  System.out.println(e);
	  failedTests++;
	}
	//opposite signed integers (num1 = -num2)
	try {
	  n1 = new HugeInteger("555");
	  n2 = new HugeInteger("-555");
	  n3 = n1.add(n2);	
	  y1 = new BigInteger(n1.toString());
	  y2 = new BigInteger(n2.toString());
	  y3 = y1.add(y2);
	  str1 = n3.toString();
	  str2 = y3.toString();
	  for (int i=0; i<str1.length();i++) {
		if ((int)str1.charAt(i)!=(int)str2.charAt(i)) {
		  flag = false;
		  break;
		}
	  }
	  if (flag) {correctAns ++;}
	  else {failedTests++;}
	}
	catch(Exception e){
	  System.out.println(e);
	  failedTests++;
	}
	//opposite signed integers (-num1 and num1 > num2)
	try {
	  n1 = new HugeInteger("-555");
	  n2 = new HugeInteger("495");
	  n3 = n1.add(n2);	
	  y1 = new BigInteger(n1.toString());
	  y2 = new BigInteger(n2.toString());
	  y3 = y1.add(y2);
	  str1 = n3.toString();
	  str2 = y3.toString();
	  for (int i=0; i<str1.length();i++) {
		if ((int)str1.charAt(i)!=(int)str2.charAt(i)) {
		  flag = false;
		  break;
		}
	  }
	  if (flag) {correctAns ++;}
	  else {failedTests++;}
	}
	catch(Exception e){
	  System.out.println(e);
	  failedTests++;
	}
	//opposite signed integers (-num1 and num1 < num2)
	try {
	  n1 = new HugeInteger("-195");
	  n2 = new HugeInteger("5999");
	  n3 = n1.add(n2);	
      /*System.out.println(n1.toString());
      System.out.println(n2.toString());
      System.out.println(n3.toString());
      System.out.println();*/
	  y1 = new BigInteger(n1.toString());
	  y2 = new BigInteger(n2.toString());
	  y3 = y1.add(y2);
	  str1 = n3.toString();
	  str2 = y3.toString();
	  for (int i=0; i<str1.length();i++) {
		if ((int)str1.charAt(i)!=(int)str2.charAt(i)) {
		  flag = false;
		  break;
		}
	  }
	  if (flag) {correctAns ++;}
	  else {failedTests++;}
	}
	catch(Exception e){
	  System.out.println(e);
	  failedTests++;
	}
	//opposite signed integers (-num2 and num1 > num2)
	try {
	  n1 = new HugeInteger("555");
	  n2 = new HugeInteger("-500");
	  n3 = n1.add(n2);	
	  y1 = new BigInteger(n1.toString());
	  y2 = new BigInteger(n2.toString());
	  y3 = y1.add(y2);
	  str1 = n3.toString();
	  str2 = y3.toString();
	  for (int i=0; i<str1.length();i++) {
		if ((int)str1.charAt(i)!=(int)str2.charAt(i)) {
		  flag = false;
		  break;
		}
	  }
	  if (flag) {correctAns ++;}
	  else {failedTests++;}
	}
	catch(Exception e){
	  System.out.println(e);
	  failedTests++;
	}
    //opposite signed integers (-num2 and num1 < num2)
	try {
	  n1 = new HugeInteger("490");
	  n2 = new HugeInteger("-500");
	  n3 = n1.add(n2);	
	  y1 = new BigInteger(n1.toString());
	  y2 = new BigInteger(n2.toString());
	  y3 = y1.add(y2);
	  str1 = n3.toString();
	  str2 = y3.toString();
	  for (int i=0; i<str1.length();i++) {
		if ((int)str1.charAt(i)!=(int)str2.charAt(i)) {
		  flag = false;
		  break;
		}
	  }
	  if (flag) {correctAns ++;}
	  else {failedTests++;}
	}
	catch(Exception e){
	  System.out.println(e);
	  failedTests++;
	}
	//both are negative integers (num1 > num2)
	try {
	  n1 = new HugeInteger("-555");
	  n2 = new HugeInteger("-500");
	  n3 = n1.add(n2);	
	  y1 = new BigInteger(n1.toString());
	  y2 = new BigInteger(n2.toString());
	  y3 = y1.add(y2);
	  str1 = n3.toString();
	  str2 = y3.toString();
	  for (int i=0; i<str1.length();i++) {
		if ((int)str1.charAt(i)!=(int)str2.charAt(i)) {
		  flag = false;
		  break;
		}
	  }
	  if (flag) {correctAns ++;}
	  else {failedTests++;}
	}
	catch(Exception e){
	  System.out.println(e);
	  failedTests++;
	}
	//both are negative integers (num1 == num2)
	try {
	  n1 = new HugeInteger("-555");
	  n2 = new HugeInteger("-99");
	  n3 = n1.add(n2);	
	  y1 = new BigInteger(n1.toString());
	  y2 = new BigInteger(n2.toString());
	  y3 = y1.add(y2);
	  str1 = n3.toString();
	  str2 = y3.toString();
	  for (int i=0; i<str1.length();i++) {
		if ((int)str1.charAt(i)!=(int)str2.charAt(i)) {
		  flag = false;
		  break;
		}
	  }
	  if (flag) {correctAns ++;}
	  else {failedTests++;}
	}
	catch(Exception e){
	  System.out.println(e);
	  failedTests++;
	}
	if (failedTests!=0) {
      System.out.println("Addition Test Cases Failed "+failedTests+"/13");
	}
	else {
	  System.out.println("Addition Test Cases Passed "+correctAns+"/13");
	}
	
	//many tests completed for subtraction ----------------------------------------------------------------
	
	correctAns = 0; 
	failedTests = 0;
    //two positive integers (num1 == num2)
    try {
	  n1 = new HugeInteger("5345453609893849989");
	  n2 = new HugeInteger("493455098989898234");
	  n3 = n1.subtract(n2);	
	  y1 = new BigInteger(n1.toString());
	  y2 = new BigInteger(n2.toString());
	  y3 = y1.subtract(y2);
	  str1 = n3.toString();
	  str2 = y3.toString();
	  for (int i=0; i<str1.length();i++) {
		if ((int)str1.charAt(i)!=(int)str2.charAt(i)) {
		  flag = false;
		  break;
		}
	  }
	  if (flag) {correctAns ++;}
	  else {failedTests++;}
	}catch(Exception e){
	  System.out.println(e);
	  failedTests++;
	}
    //two positive integers (num1 > num2)
    try {
	  n1 = new HugeInteger("555");
	  n2 = new HugeInteger("509");
	  n3 = n1.subtract(n2);	
	  y1 = new BigInteger(n1.toString());
	  y2 = new BigInteger(n2.toString());
	  y3 = y1.subtract(y2);
	  str1 = n3.toString();
	  str2 = y3.toString();
	  for (int i=0; i<str1.length();i++) {
		if ((int)str1.charAt(i)!=(int)str2.charAt(i)) {
		  flag = false;
		  break;
		}
	  }
	  if (flag) {correctAns ++;}
	  else {failedTests++;}
	}catch(Exception e){
	  System.out.println(e);
	  failedTests++;
	}
    //two positive integers (num1 < num2)
    try {
	  n1 = new HugeInteger("99");
	  n2 = new HugeInteger("555");
	  n3 = n1.subtract(n2);	
	  y1 = new BigInteger(n1.toString());
	  y2 = new BigInteger(n2.toString());
	  y3 = y1.subtract(y2);
	  str1 = n3.toString();
	  str2 = y3.toString();
	  for (int i=0; i<str1.length();i++) {
		if ((int)str1.charAt(i)!=(int)str2.charAt(i)) {
		  flag = false;
		  break;
		}
	  }
	  if (flag) {correctAns ++;}
	  else {failedTests++;}
	}catch(Exception e){
	  System.out.println(e);
	  failedTests++;
	}
    //two negative integers (num1 == num2)
    try {
	  n1 = new HugeInteger("-55");
	  n2 = new HugeInteger("-55");
	  n3 = n1.subtract(n2);	
	  y1 = new BigInteger(n1.toString());
	  y2 = new BigInteger(n2.toString());
	  y3 = y1.subtract(y2);
	  str1 = n3.toString();
	  str2 = y3.toString();
	  for (int i=0; i<str1.length();i++) {
		if ((int)str1.charAt(i)!=(int)str2.charAt(i)) {
		  flag = false;
		  break;
		}
	  }
	  if (flag) {correctAns ++;}
	  else {failedTests++;}
	}catch(Exception e){
	  System.out.println(e);
	  failedTests++;
	}
    //two negative integers (num1 > num2)
    try {
	  n1 = new HugeInteger("-598");
	  n2 = new HugeInteger("-559");
	  n3 = n1.subtract(n2);	
	  y1 = new BigInteger(n1.toString());
	  y2 = new BigInteger(n2.toString());
	  y3 = y1.subtract(y2);
	  str1 = n3.toString();
	  str2 = y3.toString();
	  for (int i=0; i<str1.length();i++) {
		if ((int)str1.charAt(i)!=(int)str2.charAt(i)) {
		  flag = false;
		  break;
		}
	  }
	  if (flag) {correctAns ++;}
	  else {failedTests++;}
	}catch(Exception e){
	  System.out.println(e);
	  failedTests++;
	}
    //two negative integers (num1 < num2)
    try {
	  n1 = new HugeInteger("-55");
	  n2 = new HugeInteger("-1008");
	  n3 = n1.subtract(n2);	
	  y1 = new BigInteger(n1.toString());
	  y2 = new BigInteger(n2.toString());
	  y3 = y1.subtract(y2);
	  str1 = n3.toString();
	  str2 = y3.toString();
	  for (int i=0; i<str1.length();i++) {
		if ((int)str1.charAt(i)!=(int)str2.charAt(i)) {
		  flag = false;
		  break;
		}
	  }
	  if (flag) {correctAns ++;}
	  else {failedTests++;}
	}catch(Exception e){
	  System.out.println(e);
	  failedTests++;
	}
    //opposite signed integers (num1 == num2)
    try {
	  n1 = new HugeInteger("55");
	  n2 = new HugeInteger("-55");
	  n3 = n1.subtract(n2);	
	  y1 = new BigInteger(n1.toString());
	  y2 = new BigInteger(n2.toString());
	  y3 = y1.subtract(y2);
	  str1 = n3.toString();
	  str2 = y3.toString();
	  for (int i=0; i<str1.length();i++) {
		if ((int)str1.charAt(i)!=(int)str2.charAt(i)) {
		  flag = false;
		  break;
		}
	  }
	  if (flag) {correctAns ++;}
	  else {failedTests++;}
	}catch(Exception e){
	  System.out.println(e);
	  failedTests++;
	}
    //opposite signed integers (num1 > num2)
    try {
	  n1 = new HugeInteger("999");
	  n2 = new HugeInteger("-99");
	  n3 = n1.subtract(n2);	
	  y1 = new BigInteger(n1.toString());
	  y2 = new BigInteger(n2.toString());
	  y3 = y1.subtract(y2);
	  str1 = n3.toString();
	  str2 = y3.toString();
	  for (int i=0; i<str1.length();i++) {
		if ((int)str1.charAt(i)!=(int)str2.charAt(i)) {
		  flag = false;
		  break;
		}
	  }
	  if (flag) {correctAns ++;}
	  else {failedTests++;}
	}catch(Exception e){
	  System.out.println(e);
	  failedTests++;
	}
    //opposite signed integers (num1 < num2)
    try {
	  n1 = new HugeInteger("-55847384");
	  n2 = new HugeInteger("9999934737");
	  n3 = n1.subtract(n2);	
	  y1 = new BigInteger(n1.toString());
	  y2 = new BigInteger(n2.toString());
	  y3 = y1.subtract(y2);
	  str1 = n3.toString();
	  str2 = y3.toString();
	  for (int i=0; i<str1.length();i++) {
		if ((int)str1.charAt(i)!=(int)str2.charAt(i)) {
		  flag = false;
		  break;
		}
	  }
	  if (flag) {correctAns ++;}
	  else {failedTests++;}
	}catch(Exception e){
	  System.out.println(e);
	  failedTests++;
	}
    // one is zero
    try {
	  n1 = new HugeInteger("0");
	  n2 = new HugeInteger("999");
	  n3 = n1.subtract(n2);	
	  y1 = new BigInteger(n1.toString());
	  y2 = new BigInteger(n2.toString());
	  y3 = y1.subtract(y2);
	  str1 = n3.toString();
	  str2 = y3.toString();
	  for (int i=0; i<str1.length();i++) {
		if ((int)str1.charAt(i)!=(int)str2.charAt(i)) {
		  flag = false;
		  break;
		}
	  }
	  if (flag) {correctAns ++;}
	  else {failedTests++;}
	}catch(Exception e){
	  System.out.println(e);
	  failedTests++;
	}
	if (failedTests!=0) {
	  System.out.println("Subtraction Test Cases Failed "+failedTests+"/10");
    }
	else {
	  System.out.println("Subtraction Test Cases Passed "+correctAns+"/10");
	}
	
	correctAns=0; failedTests =0;
	//many tests completed for multiplication ---------------------------------
	//two positive integers (num1 == num2)
	try {
	  n1 = new HugeInteger("53432454359340");
	  n2 = new HugeInteger("12000248234324");
	  n3 = n1.multiply(n2); 
	  y1 = new BigInteger(n1.toString());
	  y2 = new BigInteger(n2.toString());
	  y3 = y1.multiply(y2);
	  str1 = n3.toString();
	  str2 = y3.toString();
	  for (int i=0; i<str1.length();i++) {
		if ((int)str1.charAt(i)!=(int)str2.charAt(i)) {
		  flag = false;
		  break;
		}
	  }
	  if (flag) {correctAns ++;}
	  else {failedTests++;}
	}
	catch(Exception e){
	  System.out.println(e);
	  failedTests++;
	}
	//one positive integers (num1 = 0)
	try {
	  n1 = new HugeInteger("0");
	  n2 = new HugeInteger("500");
	  n3 = n1.multiply(n2); 
	  y1 = new BigInteger(n1.toString());
	  y2 = new BigInteger(n2.toString());
	  y3 = y1.multiply(y2);
	  str1 = n3.toString();
	  str2 = y3.toString();
	  for (int i=0; i<str1.length();i++) {
		if ((int)str1.charAt(i)!=(int)str2.charAt(i)) {
		  flag = false;
		  break;
		}
	  }
	  if (flag) {correctAns ++;}
	  else {failedTests++;}
	}
	catch(Exception e){
	  System.out.println(e);
	  failedTests++;
	}
    //two positive integers (num2 = 0)
	try {
	  n1 = new HugeInteger("999");
	  n2 = new HugeInteger("0");
	  n3 = n1.multiply(n2); 
	  y1 = new BigInteger(n1.toString());
	  y2 = new BigInteger(n2.toString());
	  y3 = y1.multiply(y2);
	  str1 = n3.toString();
	  str2 = y3.toString();
	  for (int i=0; i<str1.length();i++) {
		if ((int)str1.charAt(i)!=(int)str2.charAt(i)) {
		  flag = false;
		  break;
		}
	  }
	  if (flag) {correctAns ++;}
	  else {failedTests++;}
	}catch(Exception e){
	  System.out.println(e);
	  failedTests++;
	}
	//two positive integers (num1 > num2)
	try {
	  n1 = new HugeInteger("1000");
	  n2 = new HugeInteger("999");
	  n3 = n1.multiply(n2); 
	  y1 = new BigInteger(n1.toString());
	  y2 = new BigInteger(n2.toString());
	  y3 = y1.multiply(y2);
	  str1 = n3.toString();
	  str2 = y3.toString();
	  for (int i=0; i<str1.length();i++) {
		if ((int)str1.charAt(i)!=(int)str2.charAt(i)) {
		  flag = false;
		  break;
		}
	  }
	  if (flag) {correctAns ++;}
	  else {failedTests++;}
	}
	catch(Exception e){
	  System.out.println(e);
	  failedTests++;
	}
	//two positive integers (num1 < num2)
	try {
	  n1 = new HugeInteger("999");
	  n2 = new HugeInteger("1200");
	  n3 = n1.multiply(n2); 
	  y1 = new BigInteger(n1.toString());
	  y2 = new BigInteger(n2.toString());
	  y3 = y1.multiply(y2);
	  str1 = n3.toString();
	  str2 = y3.toString();
	  for (int i=0; i<str1.length();i++) {
		if ((int)str1.charAt(i)!=(int)str2.charAt(i)) {
		  flag = false;
		  break;
		}
	  }
	  if (flag) {correctAns ++;}
	  else {failedTests++;}
	}
	catch(Exception e){
	  System.out.println(e);
	  failedTests++;
	}
	//opposite signed integers (-num1 = num2)
	try {
	  n1 = new HugeInteger("-555");
	  n2 = new HugeInteger("555");
	  n3 = n1.multiply(n2); 
	  y1 = new BigInteger(n1.toString());
	  y2 = new BigInteger(n2.toString());
	  y3 = y1.multiply(y2);
	  str1 = n3.toString();
	  str2 = y3.toString();
	  for (int i=0; i<str1.length();i++) {
		if ((int)str1.charAt(i)!=(int)str2.charAt(i)) {
		  flag = false;
		  break;
		}
	  }
	  if (flag) {correctAns ++;}
	  else {failedTests++;}
	}
	catch(Exception e){
	  System.out.println(e);
	  failedTests++;
	}
	//opposite signed integers (num1 = -num2)
	try {
	  n1 = new HugeInteger("555");
	  n2 = new HugeInteger("-555");
	  n3 = n1.multiply(n2); 
	  y1 = new BigInteger(n1.toString());
	  y2 = new BigInteger(n2.toString());
	  y3 = y1.multiply(y2);
	  str1 = n3.toString();
	  str2 = y3.toString();
	  for (int i=0; i<str1.length();i++) {
		if ((int)str1.charAt(i)!=(int)str2.charAt(i)) {
		  flag = false;
		  break;
		}
	  }
	  if (flag) {correctAns ++;}
	  else {failedTests++;}
	}
	catch(Exception e){
	  System.out.println(e);
	  failedTests++;
	}
	//opposite signed integers (-num1 and num1 > num2)
	try {
	  n1 = new HugeInteger("-555");
	  n2 = new HugeInteger("495");
	  n3 = n1.multiply(n2); 
	  y1 = new BigInteger(n1.toString());
	  y2 = new BigInteger(n2.toString());
	  y3 = y1.multiply(y2);
	  str1 = n3.toString();
	  str2 = y3.toString();
	  for (int i=0; i<str1.length();i++) {
		if ((int)str1.charAt(i)!=(int)str2.charAt(i)) {
		  flag = false;
		  break;
		}
	  }
	  if (flag) {correctAns ++;}
	  else {failedTests++;}
	}
	catch(Exception e){
	  System.out.println(e);
	  failedTests++;
	}
	//opposite signed integers (-num1 and num1 < num2)
	try {
	  n1 = new HugeInteger("-195");
	  n2 = new HugeInteger("5999");
	  n3 = n1.multiply(n2); 
	  y1 = new BigInteger(n1.toString());
	  y2 = new BigInteger(n2.toString());
	  y3 = y1.multiply(y2);
	  str1 = n3.toString();
	  str2 = y3.toString();
	  for (int i=0; i<str1.length();i++) {
		if ((int)str1.charAt(i)!=(int)str2.charAt(i)) {
		  flag = false;
		  break;
		}
	  }
	  if (flag) {correctAns ++;}
	  else {failedTests++;}
	}
	catch(Exception e){
	  System.out.println(e);
	  failedTests++;
	}
	//opposite signed integers (-num2 and num1 > num2)
	try {
	  n1 = new HugeInteger("555");
	  n2 = new HugeInteger("-500");
	  n3 = n1.multiply(n2); 
	  y1 = new BigInteger(n1.toString());
	  y2 = new BigInteger(n2.toString());
	  y3 = y1.multiply(y2);
	  str1 = n3.toString();
	  str2 = y3.toString();
	  for (int i=0; i<str1.length();i++) {
		if ((int)str1.charAt(i)!=(int)str2.charAt(i)) {
		  flag = false;
		  break;
		}
	  }
	  if (flag) {correctAns ++;}
	  else {failedTests++;}
	}
	catch(Exception e){
	  System.out.println(e);
	  failedTests++;
	}
    //opposite signed integers (-num2 and num1 < num2)
	try {
	  n1 = new HugeInteger("490");
	  n2 = new HugeInteger("-500");
	  n3 = n1.multiply(n2); 
	  y1 = new BigInteger(n1.toString());
	  y2 = new BigInteger(n2.toString());
	  y3 = y1.multiply(y2);
	  str1 = n3.toString();
	  str2 = y3.toString();
	  for (int i=0; i<str1.length();i++) {
		if ((int)str1.charAt(i)!=(int)str2.charAt(i)) {
		  flag = false;
		  break;
		}
	  }
	  if (flag) {correctAns ++;}
	  else {failedTests++;}
	}
	catch(Exception e){
	  System.out.println(e);
	  failedTests++;
	}
	//both are negative integers (num1 > num2)
	try {
	  n1 = new HugeInteger("-555");
	  n2 = new HugeInteger("-500");
	  n3 = n1.multiply(n2); 
	  y1 = new BigInteger(n1.toString());
	  y2 = new BigInteger(n2.toString());
	  y3 = y1.multiply(y2);
	  str1 = n3.toString();
	  str2 = y3.toString();
	  for (int i=0; i<str1.length();i++) {
		if ((int)str1.charAt(i)!=(int)str2.charAt(i)) {
		  flag = false;
		  break;
		}
	  }
	  if (flag) {correctAns ++;}
	  else {failedTests++;}
	}
	catch(Exception e){
	  System.out.println(e);
	  failedTests++;
	}
	//both are negative integers (num1 == num2)
	try {
	  n1 = new HugeInteger("-555");
	  n2 = new HugeInteger("-99");
	  n3 = n1.multiply(n2); 
	  y1 = new BigInteger(n1.toString());
	  y2 = new BigInteger(n2.toString());
	  y3 = y1.multiply(y2);
	  str1 = n3.toString();
	  str2 = y3.toString();
	  for (int i=0; i<str1.length();i++) {
		if ((int)str1.charAt(i)!=(int)str2.charAt(i)) {
		  flag = false;
		  break;
		}
	  }
	  if (flag) {correctAns ++;}
	  else {failedTests++;}
	}
	catch(Exception e){
	  System.out.println(e);
	  failedTests++;
	}
	if (failedTests!=0) {
      System.out.println("Multiplication Test Cases Failed "+failedTests+"/13");
	}
	else {
	  System.out.println("Multiplication Test Cases Passed "+correctAns+"/13");
	}
	
  }
}
