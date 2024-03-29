class Solution:
    # This does not work for the [1,1] edge case
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        res = list()
        count = 1
        nums.sort()
        print(nums)
        
        for idx in range(0, len(nums)):
            
            if count != nums[idx]:
                print('count', count, ' nums[idx]', nums[idx])
                while count < nums[idx]:
                    res.append(count)
                    count += 1
            count = nums[idx] + 1
            # count = nums[idx] + 1
            
        # for curr in range(count, count ):
        #     res.append(curr)
            
        print(res)
        return res


    # Works but has extra space complexity
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        appears = set(nums)
        result = list()
        
        for num in range(1, len(nums)+1):
            if num not in appears:
                result.append(num)
        
        return result

    # Flip the bits and see if you saw the index before in the original arr
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        res = list()

        for idx in range(0, len(nums)):
            val = abs(nums[idx]) - 1
            if nums[val] > 0:
                nums[val] = -nums[val]
                
        for idx in range(0, len(nums)):
            if nums[idx] >= 0:
                res.append(idx+1)

        return res