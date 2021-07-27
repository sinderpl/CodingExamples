class Solution:
    def checkIfExist(self, arr: List[int]) -> bool:
        compliments = set()
        for val in arr:
            if val // 2 in compliments or val * 2 in compliments:
                return True
            else:
                compliments.add(val)
            
        return False
        