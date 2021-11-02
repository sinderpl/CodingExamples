"Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k"


class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        if not nums or len(nums) == 1:
            return False
        
        pairs = dict()
        
        for idx, num in enumerate(nums):
            if num in pairs:
                if abs(pairs[num] - idx) <= k:
                    return True
            pairs[num] = idx
            
        return False
