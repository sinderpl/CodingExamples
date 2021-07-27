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

    class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if len(nums) <= 1:
            return 1
        curr = 1
        
        for idx in range(1, len(nums)):
            if nums[idx] != nums[idx -1]:
                nums[curr] = nums[idx]
                curr += 1
                
        return curr
            