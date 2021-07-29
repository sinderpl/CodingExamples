class Solution:
    def thirdMax(self, nums: List[int]) -> int:
        if len(nums) < 2:
            return nums[0]
        if len(nums) < 3:
            return nums[0] if nums[0] > nums[1] else nums[1]
        
        first = nums[0]
        second = -sys.maxsize
        third = -sys.maxsize

        for num in nums:
            if num > first:
                first = num

        for num in nums:
            if num > second and num < first:
                second = num
        
        for num in nums:
            if num > third and num < second:
                third = num
                
        return third if third != -sys.maxsize else first

    def thirdMax(self, nums: List[int]) -> int:
        if len(nums) < 2:
            return nums[0]
        if len(nums) < 3:
            return nums[0] if nums[0] > nums[1] else nums[1]
        
        first = nums[0]
        second = -sys.maxsize
        third = -sys.maxsize
        
        for idx in range(1, len(nums)):
            currNum = nums[idx]
            if first != currNum and second != currNum and third != currNum:
                if currNum > first:
                    third = second
                    second = first
                    first = currNum
                elif currNum > second:
                    third = second
                    second = currNum
                elif currNum > third:
                    third = currNum
                
        return third if third != -sys.maxsize else first
