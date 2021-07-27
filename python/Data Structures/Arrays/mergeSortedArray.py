class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        m -= 1
        n -= 1
        total_len = m + n + 1
        
        while m >= 0 and n >= 0:
            if nums1[m] > nums2[n]:
                nums1[total_len] = nums1[m]
                m -= 1
            else:
                nums1[total_len] = nums2[n]
                n -= 1
            total_len -= 1
        
        while n >= 0:
            nums1[total_len] = nums2[n]
            n -= 1
            total_len -= 1



        # Implemeneted quicksort instead as a challenge
        def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        n -= 1
        for num in nums2: 
            nums1[m] = num
            m += 1

        self.quickSort(nums1, 0, m-1)
        print(nums1)
    
    def quickSort(self, nums: List[int], low: int, high: int) -> None:
        if (low < high):
            part_idx = self.partition(nums, low, high)
            
            self.quickSort(nums, low, part_idx -1) # Before PI
            self.quickSort(nums, part_idx + 1, high) #After PI
            
    def partition(self, nums: List[int], low: int, high: int) -> int:
        pivot = nums[high]
        i = low -1
        j = low
        
        while j <= high -1:
            if nums[j] < pivot:
                i += 1
                temp = nums[j]
                nums[j] = nums[i]
                nums[i] = temp
            j += 1
        
        temp = nums[high]
        nums[high] = nums[i + 1]
        nums[i + 1] = temp
        return i + 1