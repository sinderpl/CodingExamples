class Solution:
    import math
    def sortedSquares(self, nums: List[int]) -> List[int]:
        res = list()
        
        for num in nums:
            res.append(num ** 2)
            
        res.sort()
        
        
        return res