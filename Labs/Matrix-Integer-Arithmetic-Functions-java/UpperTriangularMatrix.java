public class UpperTriangularMatrix { 
    private int n;
    private int[] array;
    
    public UpperTriangularMatrix(int n){
        if (n <= 0) {   //check if n is negative or zero 
        	this.n = 1; //set the n to 1 if it is 
        }else {
        	this.n=n;   // set the size to the local n value
        }
        this.array = new int [n*(n+1)/2];   // set a new array to the size of the one dimensional array 
        for (int i=0; i<array.length;i++) { // iterate through each position in the one dimensional array 
        	array[i]=0;        	            //and set the value to 0
        }
    }
    
    public UpperTriangularMatrix(Matrix upTriM) throws IllegalArgumentException{ 
        
        if ((upTriM.isUpperTr())) {  //if the matrix is upper triangular
        	
        	this.n = upTriM.getsizeofrows();  // n is equal the number of rows and columns since its a n by n matrix 
        	this.array = new int [this.n*(n+1)/2]; //upper triangular so the both triangular are zero values 
        	int count =0;
        	// iterate through each position in the one dimensional array using ith and jth values
        	for (int i=0; i<upTriM.getsizeofrows();i++) {
        		for (int j=i; j<upTriM.getsizeofrows(); j++)  // n by n matrix so columns and rows number is the same
        		array[count++] = upTriM.getElement(i, j);  // add the value in the ith, jth position of the matrix to the array 
        		 //increase the position value by 1 to add a value to the next position in the matrix
            }
        }
        else {  // if the matrix is not upper triangular throw the exception 
        	throw new IllegalArgumentException ("Not an upper triangular Matrix");
        }
    }    
        
    public int getDim(){
        return this.n; // return the number of rows in this matrix
    }
    
    public int getoneDIndex(int i, int j) {  // get the index on the 1D array
    	int index = i * getDim() - i * i/2 + i/2 + j - i ;   // equation gets the 1D equivalent of the 2D array element 
    	return (index); //return the index
    }
    
    public int getElement(int i, int j) throws IndexOutOfBoundsException{

    	if (i>=0 && i<=getDim() && j>=0 && j<=getDim()) { //check if i and j are valid indices
    		/*
    		 * check if the column index is smaller than the row index, if so return 0
    		 * if not then we get the equivalent 1D index of the 2D array and the value at that index is returned
    		 */
    		return j < i ? 0: this.array[this.getoneDIndex(i,j)]; 
    	}

    	else { // if the i and j indices are not valid
    		throw new IndexOutOfBoundsException("Invalid indexes");  //throw the error
    	}
    }
    
    public void setElement(int x, int i, int j) throws IndexOutOfBoundsException,IllegalArgumentException{
    	
    	if (i>=0 && i<=getDim() && (j>=0 && j<=getDim())) { // check if the i and j are valid
    		this.array[this.getoneDIndex(i, j)] =x;  // assign the element on row i and column j to x
    	}
    	else if(j<i && x!= 0) { // if the value of x is not zero on the lower part of the matrix 
    		throw new IllegalArgumentException("Incorrect argument"); //throw an exception 
    	}
    	else {  // if i or j is not a valid values
    		throw new IndexOutOfBoundsException("Invalid index"); //throw an exception because i or j is not in the range
    	}
    }
    
    public Matrix fullMatrix(){

        int[][] temp = new int[getDim()][getDim()]; //temp matrix the same size as the original matrix 
        //int count =0; //set the counter to zero 
        //iterate through each row 
        for (int i=0; i<getDim();i++) { 
        	//iterate through the columns ignoring the upper triangle zeros so starting from i, ignoring the zeros in the lower part
        	for (int j=i; j<getDim(); j++) {
        		//set the temporary matrix element at the current position to the matrix value of the same position
        		temp[i][j] = this.getElement(i, j);
        	}
        }
        Matrix full = new Matrix(temp); // build a new matrix
        
        return full; //and return the matrix 
    }
    
   
      
    public String toString(){
        String output = "";  // set the original string to an empty string variable
        Matrix temp = this.fullMatrix();
		//iterate through each element in the matrix using the ith, jth position values starting from the top left position
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < n; j++) {

                output += temp.getElement(i, j);  // add the value that is in the current position into the string
                output += " ";  //add a space before moving to the next value
            }
            output += "\n"; //add a new line 

        }
		return output;  //return the final string with the matrix values
    }
    
    public int getDet(){
    	//product of the main diagonal
    	int prod = 1;
    	// iterate through the rows 
    	for (int i=0; i<getDim(); i++) {
    		prod*= this.getElement(i, i); // multiply the original product with the new value on the diagonal 
    	}
    	return prod; //the prod is the determinant
    }

    
    public double[] effSolve(double[] b) throws IllegalArgumentException{
    	
    	double[] sol = new double[b.length]; // the carrying solution which in this case would be x in Ax=b
    	//general variables that are the length of the x, A and b

    	int bL =b.length;
    	int aL = this.array.length;
    	    	
    	//get the 1D array index on the diagonal of i
    	int det=1;
    	for (int i = 0; i< getDim(); i++) {
    		//get the determinant of the values
    		det *= this.array[i* getDim() - i * i/2+ i/2]; // determinant using the 1D index formula
    	}
    	
    	if(getDim() != bL) { //check if the length of b matrix  is appropriate
    		throw new IllegalArgumentException("The dimension of the matrix is not defined for operation"); //throw and error if so
    	}
    	else if(det==0){ //check if the determinant is equal to 0 since the det of the matrix should be non-zero
    		throw new IllegalArgumentException("The determinant of the matrix is 0"); //throw an error if so 
    	}
    	else {
	    	
	    	/*
	    	 * starting from the column on the right at the bottom, 
	    	 * move towards the left until the diagonal element and calculate x for each row
	    	 * x3 will be calculated first and then x2,x1. 
	    	 */
    		int countR=0;  // counter for the row number in the A matrix 
	    	for (int i = (aL-1); i>=0 ; i-=countR) {  // i goes through each element in the row starting from bottom left 
	    		
	    		countR++;  //increase counter of row number by 1 to begin with the leftmost row
	    		double value =0; // holds the value of one solution 
	    		int countC = 0;  // index holder for the b matrix 
	    		double rightS = b[getDim()-countR];  // setting the rightS to the equivalent row value in matrix B 
	    		
	    		for (int j=i; j> i-countR ; j--) {  // j will be equal to the row number and decreases by 1 as long as it does not pass the diagonal element
	    			if (countC +1 != countR) {  //if the next value in the column from right to left
	    				rightS -= this.array[j]*sol[getDim()-countC-1]; // subtract each calculation by the A value times the x solution calculated
	      			}
	    			else {
	    				value = rightS/ (this.array[j]);  //if this is the last iteration for this row, set the value to the b value divided by the current A value
	    			}
	    			countC +=1; //increase counter by 1 to move to to the next value in B, normally used to multiply the other elements in B by the same factor if A[0,0] is not equal to 1
	    		}
	    		
	    		sol[getDim()-countR] = value;  //set the value of the solution x, x3 is done first into the matrix

	    	}
    		
            return sol; //return solution matrix
    	}   
    }
}
