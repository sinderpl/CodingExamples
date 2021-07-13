class Solution:
    import math
    def sortedSquares(self, nums: List[int]) -> List[int]:
        res = [0] * len(nums)
        left = 0
        right = len(nums) -1
        index = right
        
        while left <= right:
            if abs(nums[left]) > abs(nums[right]):
                res[index] = nums[left] ** 2
                left += 1
            else:
                res[index] = nums[right] ** 2
                right -= 1
            index -= 1
        
        return res