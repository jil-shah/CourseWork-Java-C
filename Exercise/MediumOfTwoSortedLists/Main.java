public class Main
{
    static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedArray = new int [nums1.length+nums2.length];
        double medium = 0;
        int i=0,j=0,k=0;
        //merge and sort both arrays
        while (i<nums1.length && j < nums2.length){
            if (nums1[i] < nums2[j]){  // if the number in list 1 is higher than 1
                mergedArray[k] = nums1[i];
                i++;
                k++;
            }
            else if (nums1[i] > nums2[j]){   //if the number in list 2 is higher than 1
                mergedArray[k] = nums2[j];
                j++;
                k++;
            }
            else{  //if both numbers are the same, put both in the merged list
                mergedArray[k] = nums1[i];
                k++; i++;
                mergedArray[k] = nums2[j];
                k++;j++;
            }
        }
        while (i < nums1.length){   //append the rest of the elements 
            mergedArray[k] = nums1[i];
            i++;
            k++;
        }
        while (j < nums2.length){   //append the rest of the elements 
            mergedArray[k] = nums2[j];
            j++;
            k++;
        }
        int len = mergedArray.length;  //the length of the merged list
        if ((len % 2) !=  0){  //if odd number
            medium = mergedArray[(len)/2];
        }
        else {  //if even number
            medium =(mergedArray[(len-1)/2] + mergedArray[(len)/2])/2.0 ;
        }
        
        return medium;
    }
    
    public static void main(String[] args) {
     int []l1 = {1,2};
     int []l2 = {3,4};
     double x = findMedianSortedArrays (l1,l2);
     System.out.println(x);
    }
}
