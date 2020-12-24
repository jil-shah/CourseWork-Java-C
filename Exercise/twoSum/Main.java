
public class Main
{
    static int[] twoSum(int[] nums, int target) {
        int l=0;
        int r = nums.length-1;
        int [] answer = {0,0};      
        while (l<r){
            if((nums[l]+nums[r])==target){
                answer[0] = l;
                answer[1] = r;
                return answer;
            }
            else if ((nums[l]+nums[r])<target){
                l++;
            }
            else{
                r--;
            }
        }
        return answer;
    }
    public static void main(String[] args){
        int A[] = {4,5,1,3};
        int num = 7;
        int res[]= twoSum(A,num);
        for (int i=0; i<2;i++){
            System.out.println(res[i]);
        }
    }
}
