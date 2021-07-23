class Solution:
    def duplicateZeros(self, arr: List[int]) -> None:
        """
        Do not return anything, modify arr in-place instead.
        """
        zeroCount = 0
        i = len(arr) - 1
        n = len(arr)
        for idx, num in enumerate(arr):
            if num == 0:
                zeroCount += 1
                
        write = i + zeroCount
        while i >= 0 and zeroCount >= 0:
            if arr[i] != 0:
                if write < n:
                    arr[write] = arr[i]
            else:
                if write < n:
                    arr[write] = 0
                write -= 1
                if write < n:
                    arr[write] = 0
            i -= 1
            write -= 1
        print(zeroCount)
        
        
        