class Solution:
    def sumOddLengthSubarrays(self, arr: List[int]) -> int:
        total_sum = 0
        length = len(arr)

        #Solution is 

        #For every item in array
        for i in range(length):
            # Generate every possible odd array between i and end of array
            for j in range(i, length, 2):
                # Then add all the values:
                for k in range(i, j+1):
                    total_sum += arr[k]
        
        return total_sum
        

