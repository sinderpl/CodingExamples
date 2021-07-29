class Solution:
    # This does not work 
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