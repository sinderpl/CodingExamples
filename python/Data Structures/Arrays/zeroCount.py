class Solution:
    def duplicateZeros(self, arr: List[int]) -> None:
        """
        Do not return anything, modify arr in-place instead.
        """
        zeroCount = 0
        length = len(arr)
        idx = length -1

        for num in arr:
            if num == 0:
                zeroCount += 1
        
        write = idx + zeroCount
        
        while idx >= 0 and zeroCount >= 0:
            if arr[idx] != 0:
                if write < length:
                    arr[write] = arr[idx]
            else:
                if write < length:
                    arr[write] = 0
                write -= 1
                if write < length:
                    arr[write] = 0
            idx -= 1
            write -= 1
        

#Uses additional space complexity that is not neeeded
class Solution:
    def duplicateZeros(self, arr: List[int]) -> None:
        """
        Do not return anything, modify arr in-place instead.
        """
        
        cp = arr.copy()
        curr = 0
        
        for idx, num in enumerate(cp):
            if curr >= len(arr):
                break
                
            arr[curr] = num
            curr += 1
            if num == 0 and curr < len(arr):
                arr[curr] = 0
                curr += 1
            
            
            
            
                
        
           
        