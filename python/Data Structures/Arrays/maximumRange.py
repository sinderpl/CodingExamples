class Solution:
    def maximumPopulation(self, logs: List[List[int]]) -> int:
        
        years_mapped = dict()
        # Map each person = O(n)
        # First bottleneck is having to map every year out which increases processing time
        # The second is also here since we use additional storage to account for all the years
        for years in logs:
            currYear = years[0]
            
            while currYear < years[1]:
                years_mapped[currYear] = years_mapped.get(currYear,0) + 1
                currYear += 1
        
        max_year = 0
        max_year_count = 0
        for year, count in years_mapped.items():
            if count > max_year_count:
                max_year = year
                max_year_count = count
            elif count == max_year_count and year < max_year:
                max_year = year
                max_year_count = count
        # O(n* (death- currYear)) ??
        return max_year
        

#Hashmap is not really that much more efficient
#The runtime was slightly faster most likely due to the speedier lookup than dictionairy
# Not much of a space improvement either
class Solution:
    def maximumPopulation(self, logs: List[List[int]]) -> int:
        
        years_mapped = [0] * 100
        print(years_mapped)
        # Map each person = O(n)
        for years in logs:
            currYear = years[0]
            # O(n* (death- currYear))
            while currYear < years[1]:
                years_mapped[currYear - 1950] += 1
                currYear += 1
        
        max_year = 0
        max_year_count = 0
        for year, count in enumerate(years_mapped):
            if count > max_year_count:
                max_year = year
                max_year_count = count
            elif count == max_year_count and year < max_year:
                max_year = year
                max_year_count = count
        
        return 1950 + max_year
        