class Solution {

    public int lengthOfLongestSubstring(String s) {
        int countL = 1;
        int max = 1;
        int countj = 0;
        if (s.length() == 0){
            return 0;
        }
        for (int i=0; i<s.length(); i++){
            for (int j = countj; j < i; j++){
                if (s.charAt(i)!=s.charAt(j)){
                    countL+=1;
                }
                else{
                    countj = j+1; 
                }
            }
            if (max < countL){
                max = countL;
            }
            countL=1;
            
        }
        return max;
    }
}
