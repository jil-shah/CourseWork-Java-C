import java.util.Random;

public class HugeInteger {
  private int sign;  //a value of 1,0,-1
  public int[] num;  //a list of integers(0-9)
  private int len;

  public HugeInteger(String val){
    /*creates a huge integer from the decimal string representation val
    an optional minus can be used followed by decimal digits */
    len = val.length();
    if (val == null || len == 0) {
      throw new IllegalArgumentException("The string cannot be null or empty");
    }
    // assume sign is positive and determine the index of the sign
    int counter = 0, indexSign = val.lastIndexOf("-"); 
    sign = 1;
    if (indexSign == 0){
      sign = -1;
      counter = 1; 
    }
    else if (indexSign >0){  //if the index sign is negative elsewhere in the string
      throw new IllegalArgumentException("Illegal number, the negative must be at the start");
    }

    while(counter < len && Character.digit(val.charAt(counter), 10) == 0 ){
      counter++;  //counts the number of zeros after iterating through the entire string 
    }
    if (counter == len){ //a integer with only zeros 
      sign = 0;
      num = new int[0];
      return;
    }
    // ignoring the initial zeros, add each number to the array
    num = new int[len-counter];
    for (int i =0; (i+counter) < len; i++ ){
      try {
    	num[i] = Integer.parseInt(val.substring(i+counter,1+i+counter));
        if (num[i] < 0 ){
          throw new IllegalArgumentException("Number is not valid");
        }
      }catch(Exception e){
        throw new IllegalArgumentException("Number is not valid.");
      }
    }
    len = num.length;
    return;
  }

  public HugeInteger(int n){
    /*creates a random huge integer of n-digits
    first digit is different than 0 and n must be greater than 1 */
    num = new int[n];
    Random rand = new Random(); 
    boolean flag = rand.nextBoolean(); //use a boolean to determine if the num is + or -
    if (flag == false){
      sign = -1; //bool is false = negative number
    }
    else{
      sign = 1;  //bool is true = positive number
    }
    num[0] = rand.nextInt(9)+1;  //get the first digit 1-9 number 
    for (int i=1; i<n-1; i++){  //iterate through the loop n-1 times starting from index 1
      num[i] = rand.nextInt(10);  //get a random integer between 0-9
    }
  }
  
  private HugeInteger (int[] num, int sign){
    this.sign = sign;
    this.num = num;
  }
  
  private static int[] add(int[] num1, int[] num2 ){
    //bigger number is num1, swap if not
    if (num1.length<num2.length) {  // if num1 is smaller swap the two
      int[] tempNum = num1;
      num1 = num2;
      num2 = tempNum;
    }
    int carry = 0,sum=0; 
    int len1 = num1.length, len2= num2.length;
    int[] res = new int[len1];
    //iterate from the left of the smaller number,
    while (len2>0) { 
      len1-=1; len2-=1; //shift to the next integer on the left
      sum = num1[len1] + num2[len2] + carry; //add all the digts in the placeholder
      if (sum>9) {  //if the number is greater than 10, you have to carry the one
        sum-=10;
    	carry = 1;
      }
      else {
        carry= 0; 
      }
      res[len1] = sum;  //add the digit to the list
    } //continue adding without the smaller number because all the digits are evaluated for 
    while (len1>0) {
      len1-=1;
      sum = num1[len1]+carry;
      if (sum>9) {
        sum-=10;
        carry = 1;
      }
      else {
        carry = 0;
      }
      res[len1] = sum;
    } // if the carry is not accounted for we need a new array with the carried one
    if (carry>0) {
      int [] newRes = new int[num1.length+1];
      newRes[0] = carry;
      for(int i=0; i<num1.length;i++) {
        newRes[i+1] = res[i];
      }
      return newRes;
    }
    return res;
  }
  
  // bigger number is num1 and smaller is num2, num1-num2
  private static int[] subtract(int[] num1, int[] num2){
	int len1=num1.length,len2=num2.length;
	int[] res = new int[len1];
    int borrow = 0,diff;
    //start with the rightmost digit
    while(len2>0 && len1>0) { 
      len1-=1; len2-=1;  //decrement the array length by 1 each time
      diff = num1[len1] - num2[len2] - borrow;  //subtract the numbers and account for the borrowed one if needed
      if (diff<0) { // if difference is below 0 we need to borrow a one from the integer on the left
        diff+=10;
      	borrow = 1; 
        }
      else {
        borrow= 0; 
      }
      res[len1] = diff;  //set the difference into the array of numbers, the array will be in reverse order
    }
    while(len1>0) { //iterate through the rest of the integers in the larger number 
      len1-=1; diff = 0; //decrement the index by 1 
      diff = num1[len1] - borrow; // take the difference
      if(diff < 0) {  //borrow 1 if greater than 0
        diff+=10;  
        borrow = 1;
      }
      else {
    	borrow = 0;
      }
      res[len1] = diff;  //return the difference 
    }
    
    return removeZeros(res);  //remove the excess zeros if needed
  }

  
  private static int [] removeZeros(int[] num1) {
	int zeroCounter = 0;
	for (int i=0; i<num1.length;i++) { ///iterate through the array
	  if (num1[i] > 0) { //break when the the number is greater than zero
	    break;
	  }
	  zeroCounter+=1; //increase zero counter by 1 when the digit is zero
	}
	int newLen = num1.length-zeroCounter;
	int [] simplifiedAns = new int [newLen];
	for (int i=0; i< newLen;i++) {
	  simplifiedAns[i] = num1[zeroCounter+i];
	}
	return simplifiedAns;
  }

  public HugeInteger add(HugeInteger H){
	if (this.sign == H.sign) {  //if the same signs add the numbers normally
	  return new HugeInteger (add(this.num,H.num),this.sign);
	}
	else if (this.sign == 0) {  //if one of the signs is zero the other term is the sum
      return H;
    }
	else if (H.sign == 0) {
      return this;
    }
	else {
      int flag = compareActualNumbers(H);  //compare the integers, 1 is if num1>num2 and -1 if num2>num1
      if (flag == 0) { // if the numbers are equal but opposite signs
    	return new HugeInteger(new int[0],0); 
      }
      else if (flag == 1 && H.sign == -1 ) {  //num 1 is bigger than num 2 and num 2 is negative or num 1 is positive
    	return new HugeInteger (subtract(this.num,H.num),1);
      }
      else if (flag == -1 && H.sign == -1 ) {  //num 1 is smaller than num 2 and num 2 is negative
      	return new HugeInteger (subtract(H.num,this.num),-1);
      }
      else if (flag == 1 && this.sign == -1 ) {  //num 1 is bigger than num 2 and num 1 is negative
    	return new HugeInteger (subtract(this.num,H.num),-1);
      }
      else if (flag == -1 && this.sign == -1 ) {  //num 1 is smaller than num 2 and num 1 is negative
      	return new HugeInteger (subtract(H.num,this.num),1);
      }
      
	}
	return new HugeInteger (new int[0],0);
  }
 
  public HugeInteger subtract(HugeInteger h){
	//if this is 0 then the difference will be the negative of H (num1-num2) 
	if (this.sign == 0) { 
      return new HugeInteger(h.num,-h.sign);
    } // if H is 0 then the difference will be this
    else if (h.sign == 0) {
      return this;
    }
    if (this.sign != h.sign) {  //if one of the signs in negative, take the sum of both
      return new HugeInteger(add(this.num,h.num),this.sign);
    }
    else {
      int flag = compareActualNumbers(h);  //compare the numbers, determine the larger one
      if (flag == 0) { //if the numbers are equivalent
      	return new HugeInteger(new int[0],0);
      }
      else if (flag == 1 && h.sign == -1 && this.sign == -1) {  //num 1 is bigger than num 2 and num 2 and num1 are negative
        return new HugeInteger (subtract(this.num,h.num),-1);
      }
      else if (flag == -1 && h.sign == -1 && this.sign == -1 ) {  //num 1 is smaller than num 2 and num 2 and num 1 is negative
        return new HugeInteger (subtract(h.num,this.num),1);
      }
      else if (flag == 1 && this.sign ==1) {   // num 1 is bigger than num 2 and both are positive
    	return new HugeInteger (subtract(this.num,h.num),1);
      }
      else if (flag == -1 && this.sign ==1) { // num 1 is bigger than num 2 and both are positive
    	return new HugeInteger (subtract(h.num,this.num),-1);
      }
      
    }
	return new HugeInteger (new int[0],0);
  }

  public int compareTo(HugeInteger h) {
	if (this.sign == 0 && h.sign==0) {return 0;}
	if (h.sign==0 && this.sign==1) {return 1;}
	else if (h.sign ==0 && this.sign==-1) {return -1;}
	else if (this.sign ==0 && h.sign==1) {return -1;}
	else if (this.sign ==0 && h.sign==-1) {return 1;}
    int flag = compareActualNumbers(h);
    //System.out.println(flag);
    if (flag ==0) {return 0;}
    if(flag ==1) {  //a>b
      if (this.sign==1 && h.sign ==1) {return 1;}  //both +
      else if (this.sign==1 && h.sign ==-1) {return 1;} //h is -ve
      else if (this.sign==-1 && h.sign ==1) {return -1;} //this is -ve
      else if (this.sign==-1 && h.sign ==-1) {return -1;} //both are -ve then the lower number is higher
    }
    else if (flag==-1) {  //a<b
      if (this.sign==1 && h.sign ==1) {return -1;}  //both +  
      else if (this.sign==1 && h.sign ==-1) {return 1;} //h is -ve 10>-15
      else if (this.sign==-1 && h.sign ==1) {return -1;} //this is -ve -10 <15
      else if (this.sign==-1 && h.sign ==-1) {return 1;}  //both are negative -20 > -25
    }
    return 0;
  }
  private int compareActualNumbers(HugeInteger h) {
    if (this.len >h.len) {  //check if the length of this is bigger h
	  return 1;   //if so this is in the correct order
    }
	else if(this.len < h.len) {  //check if the length of h is bigger this
	  return -1;
	}
	int count=0;

	while (count<this.len) {  // when both lengths are the same
	  if (this.num[count]> h.num[count]) {  //we iterate from the left to see if the digit in this is greater than h
	    return 1;  // if so this will be bigger
	  }
	  else if (this.num[count] < h.num[count]) { //if the number in this is smaller
	    return -1;  //then this is smaller
	  }
	  count++;
	}
  return 0;  //they both are the same number
  }

  public HugeInteger multiply(HugeInteger h) {
	if (this.sign ==0 || h.sign == 0) { //if both numbers are zero
	  return new HugeInteger(new int[0],0);
	}
	int flag = this.sign;
	if (h.sign==-1) {flag=-flag;}
	//if (h.len ==1) { return (multiplySimple(this,flag,h.num[0]));}
	//if (this.len ==1) { return (multiplySimple(h,flag,this.num[0]));}
	
    int[] product = karatsuba(this.num,h.num);
	product = removeZeros(product);
	return new HugeInteger(product,flag);
  }
  
  /*private static HugeInteger multiplySimple(HugeInteger H ,int sign, int dig) {
	int[] product = new int [H.len+1];   //new array one empty space bigger than the original
	int carry =0, prod, prodI = product.length-1; // a carry, the index for the product array and an integer to calculate the temporary product
	for (int i =H.len-1; i>=0;i--) {
	  prod = H.num[i]*dig +carry;  //calculate the product for the current index
	  if (prod>9) {                //greater than 9 
		product[prodI--]=prod%10;  //divide the product by 10 keep the remainder
	    carry = prod/10;           // the tens digit value is determined and carried
	  }
	  else {
		product[prodI--]=prod%10;   // divide the product by 10 keep the remainder
		carry = 0;		            //carry is 0
	  }
	}

	if (carry==0) {                 //if carry is 0  
	  return new HugeInteger(removeZeros(product),sign);  //return a new huge integer with removed initial zeros
	}
	else {
      product[prodI] =carry;  //if carry has a value then store the carry in the product array  
  	  return new HugeInteger (product,sign);  //return a new huge integer
	}
  }*/
  
  
  /*
   * Using the karatsuba algorithm 
   * Resource Listed Below 
   * https://courses.csail.mit.edu/6.006/spring11/exams/notes3-karatsuba
   * */
  
  private int[] karatsuba(int[] num1, int[] num2) {
	if (removeZeros(num1).length==0){return num1;}  
	if (removeZeros(num2).length==0){return num2;}
	int reqL;  
	/*
	 *determine if num1 is bigger than num 2
	 *check if the number length is odd, if so required size increases by 1
	 *this will confirm we will never have a decimal when we take the half 
	*/
	if (num1.length>num2.length) { 
	  if (num1.length%2==0) {
		reqL = num1.length; 
	  }else {
		reqL = num1.length+1;  //increase required length by 1 because it is odd
	  }
	}
	else{
	  if(num2.length%2==0) {
		reqL= num2.length;
	  }
	  else {
		reqL = num2.length+1;  //increase required length by 1 because it is odd
	  }
	}
	//change both numbers to become the same length which will add zeros to the front if it is odd
	num1 = equalLength(num1,reqL);
	num2 = equalLength(num2,reqL);
	
	/*
	 * this checks if were multiplying a number with a list of zeros. We can skip the following steps 
	 * because [0,0] * [1,0] = [0,0]
	 * return whichever list contains the zeros
	 */

	//determine what is the half point of the even numbered list
	int half = reqL/2;
	
	//split the numbers into its respective upper and lower half to get a,b,c,d
	int [] a = new int[half],b = new int[half],c = new int[half],d = new int[half];
    for (int i = 0; i < reqL; i++){
	  if (i < half){  //add the upper half to a and c
	    a[i] = num1[i];
	    c[i] = num2[i];
	  }
	  else{  //add the lower half to b and d
	    b[i - half] = num1[i];
	    d[i - half] = num2[i];
	  }
    }
    //test when a,b,c,d all have only 1 integer - fastest way is to use integers and then convert
	if (half == 1) {
	  int x1 = a[0]*c[0];                                  //multiply a and c
	  int x2 = b[0]*d[0];                                  //multiply b and d
	  //int x3 = ((a[0] + b[0]) * (c[0] + d[0])) - x2 - x1;  // the formula (a+b)*(c+d)-step2 -step1  -- simplified to a*d+b*c
	  int x3 = a[0]*d[0]+b[0]*c[0];
	  x1 *=100;                                            //to add two zeros multiply by 100
	  x3 *=10;                                             //to add one zero multiply by 10
	  int out = x1+x2+x3;                                  // add all the values
	  //we need to convert the integer into a string and then an array
	  String[] outStr = Integer.toString(out).split("");  
	  int[] prod = new int[outStr.length];
	  for (int i=0;i<outStr.length;i++) {
        prod[i] = Integer.parseInt(outStr[i]);
	  }
	  return prod; //return the array with the answer of the product 
	}
	//karatsuba algorithm applied once again but  this will lead to recursion until 1-digit arrays are multiplied
	
	int[] s1 = karatsuba(a,c); //upper
	int[] s2 = karatsuba(b,d); //lower
	//(a+b)*(c+d)  -- simplified to a*d+b*c  because a recursive will occur twice simplified method will take longer
	//int[] s5 = add(karatsuba(a,d),karatsuba(b,c));
	
	int[] s3 = karatsuba(add(a,b),(add(c,d)));
	// step 3 - 2 -1  -- assume s3 will always be bigger
	int[] s4 = subtract(s3,s2);
	int[] s5 = subtract(s4,s1);
	

	//s1 with half point zeros + s2 +s3 with half-1 zeros
	int[] s1New = shiftLeft(s1, reqL);
	int[] s3New = shiftLeft(s5, reqL/2);
	//int[] sum = add(s1New,s2);
	int[] prod = add(add(s1New,s2),s3New);
	return prod;
  }
  
  private int[] equalLength(int[] num,int len) {
	// add zeros to the front to make two arrays the same size
    int difference = len-num.length;  //the extra number of zeros 
    int [] temp = new int[len]; // the temp array of the wanted size
    for (int i=0; i<len;i++) { 
      if (i<difference) {  //until all extra zeros are added
    	temp[i] = 0; 
      }
      else {  //add the actual value in num if all extra zeros are already added
    	temp[i] = num[i-difference];
      }
    }
    return temp;  //return the list
  }


  public int[] shiftLeft (int[] num, int n) {
	//shift all digits to the left 
    int[] temp = new int[num.length+n];  // a temp array, the size includes the number of shifts
    for (int i=0;i<num.length;i++) { 
      if (i<num.length) {  //copy all the digits in the array until the end
    	temp[i] = num[i];
      }
      else {
    	temp[i] = 0; // fill the rest in with zeros 
      }
    }
    return temp;  //return the array
  }
  

  
  @Override
  public String toString(){
    if (sign == 0) {  //sign is zero the string is empty
      return ("0");
    }
    String finalStr = "";
    for (int i=0; i<this.num.length; i++) {  //iterate through the string
      finalStr +=String.valueOf(this.num[i]);  //concat all the numbers into a single string
    }
    if (this.sign == -1) { //if the sign is negative 
      finalStr = "-" + finalStr;  //add a negative to the front of the string
    }
    return finalStr;
  }
}
