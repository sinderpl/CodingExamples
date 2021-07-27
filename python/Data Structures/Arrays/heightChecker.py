class Solution:
    def heightChecker(self, heights: List[int]) -> int:
        expected = sorted(heights)
        
        count = 0
        for idx in range(len(heights)):
            if heights[idx] != expected[idx]:
                count += 1
            
        return count