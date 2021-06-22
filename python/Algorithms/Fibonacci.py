

#Recursion
class Solution:
    def fib(self, n: int) -> int:
        if (n <= 1) :
            return n 
        return self.fib(n-1) + self.fib(n-2)

#Bottom up memoization
    def fib(self, n: int) -> int:
        if (n <= 1):
            return n
        
        cache = [0,1]
        for i in range(2,n+1):
            cache.append(cache[i-1] + cache[i-2])
            
        return cache[n]
        
#Top down memoization
 #SAme as above but you precompute the N and store as a global


#Top Down Iterative
    def fib(self, n: int) -> int:
        if n <= 1:
            return n
        elif n == 2:
            return 1

        prev1 = 1
        prev2 = 1
        curr = 0

        for i in range(3, n+1):
            curr = prev1 + prev2
            prev2 = prev1
            prev1 = curr
        return curr

# Golden ratio forumula
    def fib(self, N):
        golden_ratio = (1 + 5 ** 0.5) / 2
        return int((golden_ratio ** N + 1) / 5 ** 0.5)