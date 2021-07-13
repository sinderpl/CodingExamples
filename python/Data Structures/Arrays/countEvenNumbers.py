class Solution:
    def findNumbers(self, nums: List[int]) -> int:
        result = 0
        
        for num in nums:
            if self.isEven(num):
                result = result + 1
        return result
    
    def isEven(self, num: int) -> bool:
        even = 0
        valid = False
        
        while num // 10 > 0:
            valid = not valid
            num = num // 10
        
        return valid