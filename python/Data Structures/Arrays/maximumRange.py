class Solution:
    def maximumPopulation(self, logs: List[List[int]]) -> int:
        
        years_mapped = dict()
        # Map each person = O(n)
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
        