class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if len(nums) < 1:
            return
        currIndex = 1
        currNum = nums[0]
        for val in nums:
            if currNum != val:
                nums[currIndex] = val
                currNum = val
                currIndex += 1
        return currIndex