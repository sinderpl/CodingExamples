class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        longest = 0
        curr = 0
        
        for num in nums:
            if num == 1:
                curr = curr + 1
            else:
                curr = 0
            longest = curr if curr > longest else longest
        
        return longest