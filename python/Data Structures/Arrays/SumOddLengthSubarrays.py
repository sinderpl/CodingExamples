# https://www.youtube.com/watch?v=J5IIH35EBVE
class Solution:
    def sumOddLengthSubarrays(self, arr: List[int]) -> int:
        total_sum = 0
        length = len(arr)

        #Solution is extremely inneficient as it generates every possible permutation
        # O(n ^ 3) runtime and O(1) space complexity

        #For every item in array
        for i in range(length):
            # Generate every possible odd array between i and end of array
            for j in range(i, length, 2):
                # Then add all the values:
                for k in range(i, j+1):
                    total_sum += arr[k]
        
        return total_sum
        

#THe optimal solution
# Time : O (n)
#Space : O(1)
class Solution:
    def sumOddLengthSubarrays(self, arr: List[int]) -> int:
        total_sum = 0
        length = len(arr)

        for idx in range(len(arr)):
            # check how many subarrays end in the current index
            end = idx + 1
            # check how many subarrays start with the current index
            start = length - idx
            # This is the total amount of times this number occurs in subarrays
            total = start * end
            
            # sanity check for a edge case since if total is odd we need another count
            odd = total // 2
            if total % 2 == 1:
                odd += 1
        
            #Multiply the number of occurences by the value of the number
            # total_sum += odd * arr[idx]
            
            # the shorthand version would be
            total_sum +=  arr[idx] * (( ((idx + 1) * (length - idx)) +1) // 2)
        return total_sum