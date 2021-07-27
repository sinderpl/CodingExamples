class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if len(nums) <= 1:
            return 
        
        curr_idx = 0
        zero_count = 0
        
        for idx, num in enumerate(nums):
            if num != 0:
                nums[curr_idx] = num
                curr_idx += 1
                
        while curr_idx < len(nums):
            nums[curr_idx] = 0
            curr_idx += 1
                