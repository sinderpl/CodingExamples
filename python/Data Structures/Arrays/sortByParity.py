class Solution:
    def sortArrayByParity(self, nums: List[int]) -> List[int]:
        left = 0
        right = len(nums) -1
        
        while left < right:
            if nums[left] % 2 > nums[right] % 2:
                temp = nums[left]
                nums[left] = nums[right]
                nums[right] = temp
                
            
            if nums[left] % 2 == 0:
                left += 1
            if nums[right] % 2 == 1:
                right -= 1
            
        
        return nums

    def sortArrayByParity(self, nums: List[int]) -> List[int]:
        pos = 0
        # We only need to swap the even numbers when we reach their position
        # We come in and keep track of the first odd number and in worst case we move it on the end of the array
        for idx, num in enumerate(nums):
            if num  % 2 == 0:
                nums[idx], nums[pos] = nums[pos], nums[idx]
                pos += 1
        return nums