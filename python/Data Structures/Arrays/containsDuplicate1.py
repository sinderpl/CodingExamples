"Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct."

class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        if not nums or len(nums) == 1:
            return False
         
        compliments = set()
        for num1 in nums:
            if num1 in compliments:
                return True
            else:
                compliments.add(num1)
                
        return False
