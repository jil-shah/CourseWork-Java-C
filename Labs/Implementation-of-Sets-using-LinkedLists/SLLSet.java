import org.w3c.dom.Node;

public class SLLSet {
    private int size;
    private SLLNode head;
/*
 * set - an unordered collection of elements with no repetitions
 * union - has two sets A and B written as A U B, and is the set which contains all the elements no repetitions
 * intersection - of two sets A and B written as A n B and is a set with all the elements in common 
 * Difference of two sets A and B are written as A\B and is the set containing those elements that are in the first variable, A
 */
    public SLLSet() {
        //construct an empty SLL set
    	this.size = 0;
    	this.head = null;
    }

    public SLLSet(int[] sortedArray) {
        // construct an object that contains the integers in the input array 
    	size = sortedArray.length;
    	SLLNode tempNode = new SLLNode (sortedArray[0],null);    //create a new set that is empty
    	head = tempNode;
    	if (sortedArray != null && sortedArray.length !=0) {
	    	for (int i=1; i<size; i++) {  //iterate through the size of the array
	    		tempNode.next= new SLLNode(sortedArray[i],null);   //convert the array that contains integers to a set 
	    		tempNode = tempNode.next;  // shift to the next node in the set
	    	}
    	}

    }

    public int getSize() {
    	//System.out.printf("%d\n", this.size);
        return size;  //return the size of the set
    }

    public SLLSet copy() {
        //return the deep copy of this SLLSet, two sets do not share memory, but are identical sets - node objects are not common
    	if(this.head ==null) {
    		return new SLLSet();
    	}
    	
    	SLLNode tempNode = head;  //copies the head of the set
    	int [] copyA = new int[size];
    	//iterate through the set
    	for (int i=0; i<size; i++) { 
    		copyA[i] = tempNode.value;  //copy the value in the current index from the original set to the copy  
    		tempNode= tempNode.next;  //shift to the next value in the set
    	}
        return new SLLSet(copyA);  //convert the array to a set and then return the set

    }

    public boolean isIn(int v) {
    	//check if the integer is in the set 
    	SLLNode tempNode = head; 
    	//iterate through the set 
    	for (int i=0; i<getSize(); i++) {
    		if (v==tempNode.value) {   //and check if the integer is equal to current value at the node
    			return true;           //return true if it is the same
    		}
    		tempNode = tempNode.next;  //shift to the next value 
    	}
        return false; //if the value is not found then return false 
    }

    
    public void add(int v) {
        // adds the integer v to the set if v was not already an element in the set
    	//first check if v is not found
    	if (isIn(v) == false) {
    		SLLNode tempNode =head;
    		SLLNode tempNodeV = new SLLNode(v,null);
    		int new_size = getSize()+1;
    		if (tempNode==null ) {  //check if the set is empty

    			size++;   //if so increase the size of the set 
    			tempNodeV.next=null;  //and then v becomes the first value
    			head = tempNodeV;     //change head because the added integer became the first value of the set
    			
    		}
    		else if (tempNodeV.value<tempNode.value){  //check if the new value is less than the initial  value
    			head = new SLLNode(v,head);  //set the head to the new value we are trying to add
    			size++; // increase the size of the set by 1 		
    		}

    		else {
    			for (int i=0; i<new_size; i++) {  //iterate through the entire set
    				if (tempNode.next == null) {  //check if the next element is null so the last element in the set
    	        		size++;  // if so increase the size of the set
    					tempNode.next = tempNodeV;  //and insert the new value into the next element
    					break;  //exit the loop as v was already added 
    				}
    				else if(tempNodeV.value<tempNode.next.value) {  //check if v is smaller than the next integer in the set
    					size++;  //increase the size if it is  
    					tempNodeV.next = tempNode.next;    //store the next value to make sure we do not lose the value when inserting v
    					tempNode.next = tempNodeV;    // insert v into the set
    					break;  //exit the loop as the node is already added 
    				}
    				tempNode=tempNode.next;  //shift to the next value in the set
    				//System.out.printf("%d %d %d \n",tempNode.value,tempNodeV.value, size);	
    			}

    		}
    	}
    }
    
    public void remove(int v) {
        // removes v if it is in the set
    	if (isIn(v) == true) {
    		SLLNode tempNodeV = new SLLNode(v,null);  // a temporary node for the new SLL of the number we are removing 
        	SLLNode tempNode = head;  // temp node for the initial value of the set
        	if (tempNode.value == tempNodeV.value ) {  //check if the initial value is the value of v
        		head = head.next;  // remove the head so the next value becomes head
        		size--;  // decrease the size by 1
        		//return;  //return nothing 
        	}
        	else {
        		int new_size = getSize()-1;  //decrease the temp integer by 1
	    		for (int i=0; i<new_size;i++) {  // iterate through each value in the set 
	    			if (tempNodeV.value == tempNode.next.value ) {  //check if the next value in the set is equal to the value of v
	    				tempNode.next = tempNode.next.next;   // then we will change the next value to value after that because that will remove v
	    				size--; //decrease the size by 1
	    				break;  //return to exit the function
	    			}
	    			tempNode = tempNode.next;	// move to the next value in the set
	    		}
        	}
    	}
    }

    public SLLSet union(SLLSet s) {
        /*
         * returns a new set which represents the union of this SLLset and the input 
         * union - has two sets A and B written as A U B, and is the set which contains all the elements no repetitions
         */

		SLLNode tempNode1 = head; // create a temp node to hold the initial value of the set
		SLLNode tempNode2 = s.head;  //second temporary node to hold the initial value of the set s
		SLLNode AuBNode;  //initialize a new node for the ouput set
		SLLSet AuBSet = new SLLSet();   //initialize a new set 
		
    	/*
    	 *  check if either s or the original this set have a head of null
    	 *  if so it means one set has no actual values so return the set that does have values and that will be AuB
    	 */
        if (tempNode1 == null) {                          
        	return s;
        }
        else if (tempNode2 == null) {
        	return this;
        }
		//check which set has the smaller head value and set that to the new SLL node 
		if (tempNode1.value<tempNode2.value) {                         //if this set has a smaller value than set s, 
			AuBNode = new SLLNode(tempNode1.value,null);               //we use this's head value
			tempNode1 = tempNode1.next;
		}
		else if (tempNode2.value<tempNode1.value) {                   //if s set has a smaller value than this set, 
			AuBNode = new SLLNode(tempNode2.value,null);              //we use s's head value
			tempNode2 = tempNode2.next;
		}
		//check for other situation where both values are the same 
		else {
			AuBNode = new SLLNode(tempNode1.value,null);             //if both are the same 
			tempNode1= tempNode1.next;                               //shift both nodes to the next value because we already accounted for the value
			tempNode2 = tempNode2.next;
		}
		AuBSet.size++;  //increase the size of the set by 1
		AuBSet.head = AuBNode;     //insert the head value into the set 

		//now account for every value after the set until null is reached for either set
		while (tempNode1 != null && tempNode2 !=null) {     
			//use the same conditions as earlier but check which one is smaller for the next node (value in the set)
			if (tempNode1.value<tempNode2.value) {                       //if this set has a smaller value than set s, 
				AuBNode.next = new SLLNode(tempNode1.value,null);
				tempNode1 = tempNode1.next;
			}
			else if (tempNode2.value<tempNode1.value) {                   //if s set has a smaller value than this set, 
				AuBNode.next = new SLLNode(tempNode2.value,null);
				tempNode2 = tempNode2.next;
			}
			else{                                                          //if both are the same
				AuBNode.next = new SLLNode(tempNode1.value,null);        
				tempNode1= tempNode1.next;
				tempNode2 = tempNode2.next;
			}
			AuBNode  = AuBNode.next;     //shift to the next value 
			AuBSet.size++;                //increase the size of the new set by 1
		}
		
		//iterate through the rest of the set if one of the sets is currently at null
		
		while (tempNode1 != null) {              //this is a larger set than s so repeat until this's node reaches the end of the set       
			AuBNode.next = new SLLNode(tempNode1.value,null);        //create a new node with the current node value 
			tempNode1 = tempNode1.next;                              // shift to the next value that needs to be evaluated
			AuBNode= AuBNode.next;                                   // shift to the next value in the new set, which in this case will remain null unless there are still more values in this
			AuBSet.size++;                                           //increase the new set value by 1
		}
		
		while (tempNode2 != null) {                              //s is a larger set than this so repeat until s's node reaches the end of the set  
			AuBNode.next = new SLLNode(tempNode2.value,null);      //do the same thing as the other iteration but for s's set 
			tempNode2 = tempNode2.next;
			AuBNode= AuBNode.next;
			AuBSet.size++;			
		}
			
		return AuBSet;  //return AuB, the union

    }

    public SLLSet intersection(SLLSet s) {
        //intersection - of two sets A and B written as A n B and is a set with all the elements in common 
    	SLLSet AnBSet = new SLLSet();  //initialize the new set
    	SLLNode tempNode1= head;  //set the temp node to the initial value of head
    	SLLNode tempNode2= s.head;  //set the temp node 2 to the initial value of s's head 
    	SLLNode AnBNode = null;
	    	/*inefficient method 
	    	for (int i =0; i<getSize(); i++) {  //iterate through the original set size
	    		if (s.isIn(tempNode.value) ==true) {  // check if the value is common between the sets
	    			AnBSet.add(tempNode.value);  // if it is then add the value into the new set
	    		}  
	    		tempNode =tempNode.next;  //shift to the next value 
	    	}*/
 
        if (tempNode2 == null || tempNode1 == null) {       //check if either are empty sets and if so just return an empty set since no values will be the same                   
        	return AnBSet;
        }
        while (tempNode1 != null && tempNode2 != null) {
			//use the same conditions as earlier but check which one is smaller for the next node (value in the set)
			if (tempNode1.value<tempNode2.value) {                       //if this set has a smaller value than set s, 
				tempNode1 = tempNode1.next;                                  //move to the next value in set this
			}
			else if (tempNode2.value<tempNode1.value) {                 //if s set has a smaller value than this set, 
				tempNode2 = tempNode2.next;                                  //move to the next value in set s
			}
			else{                                                       //if both are the same then we add the value to output set 
				if (AnBNode !=null) {                                      //if two values are the same and this is not the initial position of the new set
					AnBNode.next = new SLLNode(tempNode1.value,null);        //set that value to the head 
					AnBNode= AnBNode.next;                                   //shift to the next value in the output set
				}
				else {                                                     //if both initial head values are the same
					AnBNode = new SLLNode (tempNode1.value,null);            //inset the value to the new list 
					AnBSet.head = AnBNode;                                   //and set that value to the head 
				}
				AnBSet.size++;                             //increase size by 1 of the new set before repeating the loop
				tempNode1= tempNode1.next;                 //shift both nodes to the right for the next value
				tempNode2= tempNode2.next;
			}
        }
        return AnBSet;  //return AnB, the intersection of set A and B
    }

    public SLLSet difference(SLLSet s) {
    	//Difference of two sets A and B are written as A\B and is the set containing those elements that are in A
    	// A is SLLSet B is s  so this\s
    	SLLNode tempNode = head;        //set the temp node to the initial value of head
    	SLLSet  diffSet = new SLLSet ();   //initialize the new set
 
    	for (int i=0; i<getSize(); i++) {   //iterate through the original set size
    		if (s.isIn(tempNode.value)==false) {   //check if the value in set s is not found in the original set
    			diffSet.add(tempNode.value);  // add the value into the new set if not found
    		}
    		tempNode = tempNode.next;  //shift to the next value in the original set
    	}
        return diffSet;  // return A\B, the difference of the sets  
    }

    public static SLLSet union(SLLSet[] sArray) {
    	// creates a new object representing the union of the sets in the array
        SLLSet ss = new SLLSet();  // create a new set 
        for (int i=0; i<sArray.length; i++) {  //iterate through the array 
        	ss = ss.union(sArray[i]);  // use union to unite the current set in the array into the new set 
        	//all the common values will be added into the set 
        } 
        return ss;  //return the union of multiple sets
    }

    @Override
    public String toString() {
		String output = "";  // initialize an empty string
		if (head ==null) { //if there are no values in the set 
			return output; //return an empty string
		}
		SLLNode tempNode = head;    //set a temp node to the initial value in the set
		// iterate through the set starting from 0 to the null character 
		for (int i=0; i<size; i++) {  
	        if(i == size -1){  // check if the current iteration number is the last value
	          output += tempNode.value;  // add the value to the output 
	        }
	        //if its not the last number in the set
	        else{
					  output += tempNode.value + ", ";  //add the value in the set and a comma
	        }
	
				  tempNode = tempNode.next;  //shift to the next value in the set
		} 
        return output;  //return the changed string
    }
}
