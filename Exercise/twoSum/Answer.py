class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        x=[]
        for i in range (len(nums)):
            for j in range (i,len(nums)-1):
                if (target == (nums[i]+nums[j+1])):
                    x.append(i)
                    x.append(j+1)
                
        return x
