class Solution:
    def validMountainArray(self, arr: List[int]) -> bool:
        if len(arr) < 3:
            return False
        steps = 0
        
        # Walk upwards, counting steps until first slope down
        while steps + 1 < len(arr) and arr[steps] < arr[steps + 1]:
            steps += 1
        
        # Check if there was no incline or it ends in a cliff
        if steps == 0  or steps == len(arr) -1:
            return False
        
        #Walk downwards the slope counting to make sure there are no inclines again
        while steps + 1 < len(arr) and arr[steps] > arr[steps + 1]:
            steps += 1
        
        #compare if length equals to step down
        return steps == len(arr) - 1