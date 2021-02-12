

public class Matrix {
    
	private int[][]  matrixData;
	private int    rowsNum;	
	private int    colsNum;	
	
	public Matrix( int row, int col )  //done
	{   
		//use the ternary operator to check if row or column is greater than 0
		
		// if the condition is true then set the new matrix row number to equal 3, if not it will equal to the row number 
		this.rowsNum = row <= 0 ? 3: row; 
		// if the condition is true then set the new matrix column number to equal 3, if not it will equal to the column number 
		this.colsNum = col <= 0 ? 3: col; 
		// set the new matrix data size to the value of rows and columns
		this.matrixData = new int[this.rowsNum][this.colsNum];
		
		//iterate through each element in the matrix using the ith, jth position values
		for  (int i=0; i<rowsNum; i++) {
			for (int j=0; j<colsNum;j++) {
				this.matrixData[i][j]=0;      //and preset each value to zero
			}
		}
	}

	public Matrix( int[][] table)  //done
	{	

		this.rowsNum = table.length;  //set the rows number to the length of rows 
		this.colsNum = table[0].length;  //set the columns number to the length of the columns 
		this.matrixData = new int[rowsNum][colsNum]; // construct the matrix 
		// write the values of the table into the matrix 
		
		for (int i=0; i<rowsNum; i++ ) {    //iterate through each row
			for (int j=0; j<colsNum; j++) {    //iterate through each column in the row
				this.matrixData[i][j] = table[i][j];  //copy the values in the table into the matrix 
			}
		}
		
	}
	
    public int getsizeofrows(){   //only for the original matrix to simplify this.matrixdata.length 
        
		return this.matrixData.length; // return the length of the rows
    }
        
    public int getsizeofcols(){
		
        return this.matrixData[0].length; //return the length of the columns
    }
        
	public int getElement(int i, int j) throws IndexOutOfBoundsException
	{ 	
		//check if i and j values are not in the range of the value of the rows or columns or value is negative
        if(getsizeofrows()<=i || getsizeofcols()<=j || i<0 || j<0) { 
            throw new IndexOutOfBoundsException("Invalid indexes."); // throw the exception and display the error
        }
        else {
        	return (matrixData[i][j]);  //return the value thats in the ith row and jth column 
        }
		
	}
        
    public boolean setElement(int x, int i, int j){ 
       
    	if(getsizeofrows()<=i || getsizeofcols()<=j || i<0 || j<0) { // if i and j are not in the range or are less than 0
            return false; // the exception occurs so false as i and j are above the valid index range
        }
        else{
        	this.matrixData[i][j] = x; //x is assigned the value in the ith row and jth column of the matrix 
        	return true;
        } 
    } 
    


    public Matrix copy(){  //done 

		Matrix copy = new Matrix (this.matrixData);   //the matrix copy is equal to the matrix data, the original remains unchanged
        return  copy;  //returns the deep copy of the matrix
    }    
                
	public void addTo( Matrix m ) throws ArithmeticException
	{

		//check if the sizes of matrix match the columns and the rows
		if(m.rowsNum == getsizeofrows() && m.colsNum == getsizeofcols()) {
			//iterate through the rows
			int sum, A, B;
			for (int i=0; i<getsizeofrows(); i++) {   //iterate through the rows
				for (int j=0; j<getsizeofcols(); j++) {  //iterate through the columns on the specific row
					A = this.matrixData[i][j]; // set A to the value at the current index in original matrix
					B = m.matrixData[i][j];  // set B to the value at the current index in matrix m 
					sum = A + B; //take the sum of both the values
					
					this.matrixData[i][j] = sum; // change the original value in the original matrix to the sum
				}
			}
		}
		else {  // if both matrix sizes are not equal 
			throw new ArithmeticException("Invalid operation"); //then throw the exception with the specified message
		}
	
	}
	
    public Matrix subMatrix(int i, int j) throws ArithmeticException{ 
        
    	if(getsizeofrows()<=i || getsizeofrows() <=j || i<0 || j<0) {  // if i and j are not in the range or are less than 0
    		throw new ArithmeticException ("Submatrix not defined"); //throw the exception and display the error
    	}
    	
    	else {  // if i and j are in the range
    		Matrix subM = new Matrix (i+1,j+1); // create a matrix with the defined size of i and j 
    		for (int m=0; m<subM.rowsNum; m++) {  //iterate through each row 
    			for (int n=0; n<subM.colsNum; n++) {  //iterate through each column 
    				//set the new matrix to the corresponding values in the original matrix using the set and get method
    				subM.setElement((this.getElement(m, n)), m, n);
    			}
    		}
    		return  subM; //return the sub matrix
    	}
    }
        

    public boolean isUpperTr(){
    	
    	for (int i=0; i<getsizeofrows();i++) {  //iterate through the rows and columns only to go through the elements below the triangle
    		for (int j=0; j<i; j++) {         
    			if (this.getElement(i,j)!=0) { //check if the value in the ith and jth position which is a value below the diagonal is zero
    				return false;  // return false because the matrix is not upper triangular 
    			}
    		}
    	}
        return true;  //return true because the matrix has only 0 values below the diagonal
	}
        
    public static Matrix sum(Matrix[] matArray) throws ArithmeticException{

        Matrix superMatrix = new Matrix (matArray[0].rowsNum,matArray[0].colsNum); // create a new matrix of the new matrix size
        for (int i=0; i<matArray.length; i++) { //iterate through each matrix 
        	if (matArray[i].rowsNum != matArray[0].rowsNum || matArray[i].colsNum != matArray[0].colsNum) {  //check if the sizes of the rows and columns are the same
        		throw new ArithmeticException ("Invalid operation"); //if not throw an exception
        	}
        	else {  //if the sizes are the same
        		superMatrix.addTo(matArray[i]); //then take the sum of the matrices using the addto method and put them into the supermatrix
        	}
        }
        return superMatrix; //return the new matrix which holds the numb
    }
        
	public String toString(  )
	{
        String output = "";  // set the original string to an empty string variable
        
		//iterate through each element in the matrix using the ith, jth position values starting from the top left position
        for (int i = 0; i < getsizeofrows(); i++) {
            for (int j = 0; j < getsizeofcols(); j++) {
                output += matrixData[i][j];  // add the value that is in the current position into the string
                output += " ";  //add a space before moving to the next value
            }
            output += "\n"; //add a new line 
        }
		return output;  //return the final string with the matrix values
	}

    
}
