class Solution:
    def replaceElements(self, arr: List[int]) -> List[int]:
        curr = -1
    
        for idx in range(len(arr) -1, -1, -1):
            temp = arr[idx]
            arr[idx] = curr
            if temp > curr:
                curr = temp
        return arr